package UnoEngine.GameUtilities;

import UnoEngine.CardPiles.*;
import UnoEngine.Cards.Card;
import UnoEngine.Cards.EffectCard;
import UnoEngine.PlayerUtilities.Player;

import java.util.NoSuchElementException;

public class CardDealer {
    private final DeckOfCards deckOfCards;
    private final DrawPile drawPile;
    private final DiscardPile discardPile;

    private final int startingCards;

    public CardDealer(DeckOfCards deckOfCards, int startingCards){
        this.startingCards = startingCards;
        this.deckOfCards = deckOfCards;
        drawPile = DrawPile.getInstance();
        discardPile = DiscardPile.getInstance();
    }


    public void dealStartingCards(Object[] players){
        deckOfCards.shuffle();

        for (Object playerObj : players){
            dealToPlayerFromPile((Player) playerObj, startingCards, deckOfCards);
        }
    }

    public void discardedToDraw(){
        Card keepDiscarded = discardPile.drawTopCard();
        discardPile.resetEffects();
        formDrawPile(discardPile);
        discardPile.discardCard(keepDiscarded);
    }

    public void deckToDrawPile(){
        playInitialCard();

        formDrawPile(deckOfCards);
    }

    private void playInitialCard(){
        do{
            Card discardedCard = deckOfCards.drawTopCard();
            System.out.println("Discarded " + discardedCard);
            discardPile.discardCard(discardedCard);
        }while (discardPile.examineTopCard() instanceof EffectCard);
    }

    public void formDrawPile(CopyableCardStack notEmptyPile){
        drawPile.refill(notEmptyPile.copy());
        drawPile.shuffle();
    }

    public void dealToPlayer(Player player, int quantity) {
        dealToPlayerFromPile(player, quantity, drawPile);
    }

    private void dealToPlayerFromPile(Player player, int quantity, Drawable currentPile ){
        while (quantity != 0){
            dealToPlayerFromPile(player, currentPile);
            quantity--;
        }
    }

    private void dealToPlayerFromPile(Player player, Drawable currentPile){
        try {
            player.addCardInHand(currentPile.drawTopCard());
        }
        catch (NoSuchElementException exception){
            discardedToDraw();
            player.addCardInHand(currentPile.drawTopCard());
        }
    }

    public boolean cannotDealNext() {
        return drawPile.isEmpty();
    }

    public int cardsRemaining() {
        return drawPile.countCards();
    }

    public int getMaxPlayers() {
        return deckOfCards.getTotalCards() / startingCards;
    }
}
