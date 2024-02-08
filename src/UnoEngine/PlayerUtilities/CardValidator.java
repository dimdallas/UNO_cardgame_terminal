package UnoEngine.PlayerUtilities;

import UnoEngine.CardPiles.DiscardPile;
import UnoEngine.Cards.Card;
import UnoEngine.Cards.Color;
import UnoEngine.Cards.Symbol;

import java.util.AbstractList;

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
