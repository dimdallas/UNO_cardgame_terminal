package UnoEngine.Cards;

public class NumberedCard extends Card {
    public NumberedCard(Color color, Symbol symbol) {
        super(color, symbol);
    }

    @Override
    public Card copy() {
        return new NumberedCard(this.color, this.symbol);
    }
}
