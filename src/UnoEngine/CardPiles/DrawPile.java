package UnoEngine.CardPiles;

import UnoEngine.Cards.Card;

import java.util.Stack;

public class DrawPile extends CardPile implements Drawable{
    private static DrawPile Instance;

    public static DrawPile getInstance(){
        if(Instance == null)
            Instance = new DrawPile();
        return Instance;
    }

    private DrawPile() {
        super();
    }

    @Override
    public Card drawTopCard(){
        return removeTopCard();
    }

    public void refill(Stack<Card> oldPile){
        setCardStack(oldPile);
    }
}
