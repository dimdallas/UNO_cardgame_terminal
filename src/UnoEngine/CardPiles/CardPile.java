package UnoEngine.CardPiles;

import UnoEngine.Cards.Card;

import java.util.*;

public abstract class CardPile{
    private Stack<Card> cardStack;

    CardPile() {
        this.cardStack = new Stack<>();
    }

    public void shuffle(){
        Collections.shuffle(cardStack);
    }

    public boolean isEmpty(){
        return cardStack.isEmpty();
    }

    public int countCards(){
        return cardStack.size();
    }

    protected Card removeTopCard() throws NoSuchElementException {
        if(isEmpty())
            throw new NoSuchElementException("Card pile is empty");
        return cardStack.pop();
    }

    protected Card getTopCard(){
        try {
            return cardStack.peek();
        }
        catch (EmptyStackException e){
            return null;
        }
    }

    protected void addTopCard(Card card){
        cardStack.push(card);
    }

    protected void removeAllCards(){
        cardStack.empty();
    }

    protected void setCardStack(AbstractList<Card> cardStack){
        this.cardStack = (Stack<Card>) cardStack;
    }
    protected AbstractList<Card> getCardStack(){
        return this.cardStack;
    }


}
