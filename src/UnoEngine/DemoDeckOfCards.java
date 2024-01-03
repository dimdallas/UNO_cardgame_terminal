package UnoEngine;

public class DemoDeckOfCards extends ClassicDeckOfCards {
    @Override
    public void initializeValues() {
        zeroCards = 4;
        oneCards = 4;
        twoCards = 4;
        threeCards = 4;
        fourCards = 4;
        fiveCards = 4;
        sixCards = 4;
        sevenCards = 4;
        eightCards = 4;
        nineCards = 4;
        skipCards = 4;
        reverseCards = 4;
        drawTwoCards = 4;
        wildColorCards = 2;
        wildDrawFourCards = 2;

        nonColors = Color.getNonColors().length;
        realColors = Color.getRealColors().length;
    }
}
