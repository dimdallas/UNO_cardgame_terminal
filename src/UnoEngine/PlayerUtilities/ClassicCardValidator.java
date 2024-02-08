package UnoEngine.PlayerUtilities;

import UnoEngine.Cards.Card;
import UnoEngine.Cards.Color;
import UnoEngine.Cards.Symbol;

import java.util.AbstractList;
import java.util.ArrayList;

public class ClassicCardValidator extends CardValidator{
    private static ClassicCardValidator Instance;

    public static ClassicCardValidator getInstance(){
        if(Instance == null)
            Instance = new ClassicCardValidator();
        return Instance;
    }

    @Override
    public ArrayList<Color> getValidColors(){
        ArrayList<Color> validColors = new ArrayList<>();
        validColors.add(getDiscardedColor());
        validColors.add(Color.WILD);
        return validColors;
    }

    @Override
    public ArrayList<Symbol> getValidSymbols() {
        ArrayList<Symbol> validSymbols = new ArrayList<>();
        validSymbols.add(getDiscardedSymbol());
        validSymbols.add(Symbol.WILD_COLOR);
        validSymbols.add(Symbol.WILD_DRAW_FOUR);
        return validSymbols;
    }

    @Override
    public ArrayList<Card> getValidCards(AbstractList<Card> givenCards){
        ArrayList<Card> validCards = new ArrayList<>();
        ArrayList<Color> colors = getValidColors();
        ArrayList<Symbol> symbols = getValidSymbols();

        for(Card card : givenCards){
            if(colors.contains(card.getColor()) || symbols.contains(card.getSymbol()))
                validCards.add(card);
        }

        return validCards;
    }
}
