package UnoEngine;

import java.util.AbstractCollection;
import java.util.AbstractList;
import java.util.ArrayList;

public abstract class CardValidator {
    private final DiscardPile discardPile;

    protected CardValidator(){
        discardPile = DiscardPile.getInstance();
    }

    public abstract AbstractList<Color> getValidColors();
    public abstract AbstractList<Symbol> getValidSymbols();

    public abstract AbstractList<Card> getValidCards(AbstractList<Card> givenCards);

    public Card examineDiscarded(){
        return discardPile.examineTopCard();
    }

    public Color getDiscardedColor(){
        return examineDiscarded().getColor();
    }

    public Symbol getDiscardedSymbol(){
        return examineDiscarded().getSymbol();
    }
}
