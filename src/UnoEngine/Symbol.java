package UnoEngine;

public enum Symbol {
    ZERO, ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, SKIP, REVERSE, DRAW_TWO, WILD_COLOR, WILD_DRAW_FOUR;

    public static Symbol getSymbol(int value){
        return Symbol.values()[value];
    }
}
