package UnoEngine;

import java.util.NoSuchElementException;
import java.util.Stack;

public class DrawPile extends CardPile implements Drawable{
    private static DrawPile Instance;

    public static DrawPile getInstance(){
        if(Instance == null)
            Instance = new DrawPile();
        return Instance;
    }

    @Override
    public Card drawTopCard(){
        return removeTopCard();
    }

    public void refill(Copyable<Stack<Card>> oldPile){
        setCardStack(oldPile.copy());
    }
}
