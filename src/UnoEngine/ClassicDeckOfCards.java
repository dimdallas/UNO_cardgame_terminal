package UnoEngine;

import java.lang.reflect.InvocationTargetException;
import java.util.Stack;

public class ClassicDeckOfCards extends DeckOfCards{
    @Override
    public void initializeValues() {
        zeroCards = 4;
        oneCards = 8;
        twoCards = 8;
        threeCards = 8;
        fourCards = 8;
        fiveCards = 8;
        sixCards = 8;
        sevenCards = 8;
        eightCards = 8;
        nineCards = 8;
        skipCards = 8;
        reverseCards = 8;
        drawTwoCards = 8;
        wildColorCards = 4;
        wildDrawFourCards = 4;

        nonColors = Color.getNonColors().length;
        realColors = Color.getRealColors().length;
    }

    @Override
    public void createCards() {
        createNumberedCards(new NumberedCard(Color.WILD, Symbol.ZERO), zeroCards);
        createNumberedCards(new NumberedCard(Color.WILD, Symbol.ONE), oneCards);
        createNumberedCards(new NumberedCard(Color.WILD, Symbol.TWO), twoCards);
        createNumberedCards(new NumberedCard(Color.WILD, Symbol.THREE), threeCards);
        createNumberedCards(new NumberedCard(Color.WILD, Symbol.FOUR), fourCards);
        createNumberedCards(new NumberedCard(Color.WILD, Symbol.FIVE), fiveCards);
        createNumberedCards(new NumberedCard(Color.WILD, Symbol.SIX), sixCards);
        createNumberedCards(new NumberedCard(Color.WILD, Symbol.SEVEN), sevenCards);
        createNumberedCards(new NumberedCard(Color.WILD, Symbol.EIGHT), eightCards);
        createNumberedCards(new NumberedCard(Color.WILD, Symbol.NINE), nineCards);
        createColoredCards(new SkipActionCard(Color.WILD), skipCards);
        createColoredCards(new ReverseActionCard(Color.WILD), reverseCards);
        createColoredCards(new DrawTwoActionCard(Color.WILD), drawTwoCards);
        createCardCopies(new WildColorCard(), wildColorCards);
        createCardCopies(new WildDrawFourCard(), wildDrawFourCards);
    }
}
