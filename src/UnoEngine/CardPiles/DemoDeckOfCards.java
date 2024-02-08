package UnoEngine.CardPiles;

import UnoEngine.Cards.*;

public class DemoDeckOfCards extends DeckOfCards {
    @Override
    public void initializeValues() {
        zeroCards = 4;
        oneCards = 4;
        twoCards = 4;
        threeCards = 4;
        skipCards = 4;
        reverseCards = 4;
        drawTwoCards = 4;
        wildColorCards = 2;
        wildDrawFourCards = 2;

        nonColors = Color.getNonColors().length;
        realColors = Color.getRealColors().length;
    }

    @Override
    public void createCards() {
        createNumberedCopies(new NumberedCard(Color.WILD, Symbol.ZERO), zeroCards);
        createNumberedCopies(new NumberedCard(Color.WILD, Symbol.ONE), oneCards);
        createNumberedCopies(new NumberedCard(Color.WILD, Symbol.TWO), twoCards);
        createNumberedCopies(new NumberedCard(Color.WILD, Symbol.THREE), threeCards);
        createColoredCopies(new SkipActionCard(Color.WILD), skipCards);
        createColoredCopies(new ReverseActionCard(Color.WILD), reverseCards);
        createColoredCopies(new DrawTwoActionCard(Color.WILD), drawTwoCards);
        createCardCopies(new WildColorCard(), wildColorCards);
        createCardCopies(new WildDrawFourCard(), wildDrawFourCards);
    }
}
