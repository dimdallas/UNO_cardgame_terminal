package UnoEngine.Cards;

public enum Symbol {
    ZERO, ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, SKIP, REVERSE, DRAW_TWO, WILD_COLOR, WILD_DRAW_FOUR;

    public static Symbol getSymbol(int value){
        return Symbol.values()[value];
    }
    public static Symbol[] getNumbers(){
        return new Symbol[]{ZERO, ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE};
    }

    public static Symbol[] getActions(){
        return new Symbol[]{SKIP, REVERSE, DRAW_TWO};
    }

    public static Symbol[] getWilds(){
        return new Symbol[]{WILD_COLOR, WILD_DRAW_FOUR};
    }
}
