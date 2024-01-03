package UnoEngine;

public class SkipActionCard extends ActionCard implements HasSkipEffect{
    public SkipActionCard(Color color) {
        super(color, Symbol.SKIP);
    }

    @Override
    public Card copy() {
        return new SkipActionCard(this.color);
    }
}
