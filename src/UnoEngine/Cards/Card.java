package UnoEngine.Cards;


public abstract class Card implements CopyableCard {
    protected Color color;
    protected final Symbol symbol;

    protected Card(Color color, Symbol symbol) {
        this.color = color;
        this.symbol = symbol;
    }

    public Color getColor(){
        return color;
    }

    protected void setColor(Color color) {
        this.color = color;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    @Override
    public String toString() {
        return color.getAnsiColor() + color + " " + symbol + Color.ANSI_RESET;
    }
}
