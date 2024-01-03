package UnoEngine;

import com.sun.istack.internal.NotNull;

import java.util.NoSuchElementException;
import java.util.Stack;

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


    public void dealStartingCards(@NotNull Object[] players){
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
            System.out.println("Discarded " + deckOfCards.getTopCard());
            discardPile.discardCard(deckOfCards.drawTopCard());
        }while (discardPile.examineTopCard() instanceof EffectCard);
    }

    public void formDrawPile(Copyable<Stack<Card>> notEmptyPile){
        drawPile.refill(notEmptyPile);
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
}
