package UnoEngine.CardPiles;

import UnoEngine.Cards.*;

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
        createNumberedCopies(new NumberedCard(Color.WILD, Symbol.ZERO), zeroCards);
        createNumberedCopies(new NumberedCard(Color.WILD, Symbol.ONE), oneCards);
        createNumberedCopies(new NumberedCard(Color.WILD, Symbol.TWO), twoCards);
        createNumberedCopies(new NumberedCard(Color.WILD, Symbol.THREE), threeCards);
        createNumberedCopies(new NumberedCard(Color.WILD, Symbol.FOUR), fourCards);
        createNumberedCopies(new NumberedCard(Color.WILD, Symbol.FIVE), fiveCards);
        createNumberedCopies(new NumberedCard(Color.WILD, Symbol.SIX), sixCards);
        createNumberedCopies(new NumberedCard(Color.WILD, Symbol.SEVEN), sevenCards);
        createNumberedCopies(new NumberedCard(Color.WILD, Symbol.EIGHT), eightCards);
        createNumberedCopies(new NumberedCard(Color.WILD, Symbol.NINE), nineCards);
        createColoredCopies(new SkipActionCard(Color.WILD), skipCards);
        createColoredCopies(new ReverseActionCard(Color.WILD), reverseCards);
        createColoredCopies(new DrawTwoActionCard(Color.WILD), drawTwoCards);
        createCardCopies(new WildColorCard(), wildColorCards);
        createCardCopies(new WildDrawFourCard(), wildDrawFourCards);
    }
}
