package UnoEngine;

import java.util.AbstractList;

public abstract class CardsInHand {

    protected AbstractList<Card> cardList;
    protected CardValidator cardValidator;


    public AbstractList<Card> getCards(){
        return cardList;
    }

    public AbstractList<Card> getValidCards(){
        return cardValidator.getValidCards(cardList);
    }
    public boolean noCardsRemaining(){
        return cardList.isEmpty();
    }

    public int cardsRemaining() {
        return cardList.size();
    }

    public void sortCards(){
        cardList.sort((c1, c2) -> {
            int colorComparison = c1.getColor().compareTo(c2.getColor());
            if(colorComparison == 0){
                return c1.getSymbol().compareTo(c2.getSymbol());
            }
            return colorComparison;
        });
    }

    public void addCard(Card card){
        cardList.add(card);
    }

    public void removeCard(Card card){
        cardList.remove(card);
    }
}
