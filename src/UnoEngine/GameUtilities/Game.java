package UnoEngine.GameUtilities;

import UnoEngine.CardPiles.DiscardPile;
import UnoEngine.Cards.*;
import UnoEngine.PlayerUtilities.Player;

public abstract class Game {
    protected PlayerQueue playerQueue;
    protected DiscardPile discardPile;

    public Game(PlayerQueue playerQueue, DiscardPile discardPile, CardDealer cardDealer) {
        this.playerQueue = playerQueue;
        this.discardPile = discardPile;
        this.cardDealer = cardDealer;
    }

    protected CardDealer cardDealer;

    public abstract void play();

    public abstract void setPlayersInGame(int totalPlayers);

    protected abstract void manageCardEffects();

    protected abstract void managePenalties();

    protected abstract void managePlayerTurn();

    protected boolean gameNotEnded() {
        return !playerQueue.hasPlayerWon();
    }

    protected boolean checkActiveEffect(Card card){
        if(card instanceof EffectCard)
            return ((EffectCard) card).hasActiveEffect();

        return false;
    }

    protected void applyEffect(EffectCard card) {
        if(card instanceof HasReverseEffect) {
            playerQueue.reverseRotation();
        }
        if(card instanceof HasDrawEffect)
        {
            int cardsToDeal = ((HasDrawEffect) card).cardsToDraw();
            cardDealer.dealToPlayer(playerQueue.getNextPlayer(), cardsToDeal);
            System.out.println(playerQueue.getNextPlayer() + " draws " + cardsToDeal + " cards");

        }
        if(card instanceof HasSkipEffect) {
            System.out.println(playerQueue.getNextPlayer() + " is SKIPPED");
            playerQueue.skipPlayer();
        }
        card.setInactiveEffect();
    }

    protected void displayDiscardTop() {
        Card topCard = discardPile.examineTopCard();

        if(topCard != null)
            System.out.println("Discard pile: " + topCard);
        else {
            System.out.println("Discard pile is empty");
        }
    }

    protected void givePenalty(Player currentPlayer, int penaltyCards){
        System.out.println(currentPlayer + " draws 2 cards");
        cardDealer.dealToPlayer(currentPlayer, penaltyCards);
    }

}
