import UnoEngine.CardPiles.ClassicDeckOfCards;
import UnoEngine.CardPiles.DiscardPile;
import UnoEngine.Cards.Card;
import UnoEngine.Cards.EffectCard;
import UnoEngine.GameUtilities.CardDealer;
import UnoEngine.GameUtilities.Game;
import UnoEngine.GameUtilities.PlayerQueue;
import UnoEngine.PlayerUtilities.Player;

import java.util.Scanner;

public class ClassicGame extends Game {
    Scanner scanner;
    public ClassicGame() {
        super(PlayerQueue.getInstance(),
                DiscardPile.getInstance(),
                new CardDealer(new ClassicDeckOfCards(), 7));
        scanner = new Scanner(System.in);
    }

    @Override
    public void setPlayersInGame(int totalPlayers) {
        if(totalPlayers > cardDealer.getMaxPlayers()){
            throw new RuntimeException("Current Deck can not support so many players");
        }
        playerQueue.setTotalPlayers(totalPlayers);
        for(int i = 0; i < totalPlayers; i++) {
            System.out.println("Give your name");
            playerQueue.registerPlayer(scanner.nextLine());
        }
    }

    @Override
    public void play() {
        cardDealer.dealStartingCards(playerQueue.getPlayers());
        cardDealer.deckToDrawPile();

        int i=0;

        while (gameNotEnded()){
            System.out.println("-----------"+ (i++) +"-----------");
            if(cardDealer.cannotDealNext())
                cardDealer.discardedToDraw();
            System.out.println("Cards remaining in DrawPile: " + cardDealer.cardsRemaining());

            displayDiscardTop();

            manageCardEffects();

            managePenalties();

            managePlayerTurn();
        }

        System.out.println("Player " + playerQueue.getCurrentPlayer() + " has won");
    }

    @Override
    protected void managePenalties() {
        Player currentPlayer = playerQueue.getNextPlayer();

        if(currentPlayer.forgotToSayUNO()){
            System.out.println("Player didn't say UNO, he gets PENALTY");
            givePenalty(currentPlayer, 2);
        }
    }

    @Override
    protected void managePlayerTurn() {
        playerQueue.setNextPlayer();
        System.out.println("Current player: " + playerQueue.getCurrentPlayer()
                +", cards remaining: " + playerQueue.getCurrentPlayer().remainingCards());

        playerQueue.playTurn();
    }

    @Override
    protected void manageCardEffects() {
        Card inspectedCard = discardPile.examineTopCard();
        if(checkActiveEffect(inspectedCard))
            applyEffect((EffectCard) inspectedCard);
    }
}
