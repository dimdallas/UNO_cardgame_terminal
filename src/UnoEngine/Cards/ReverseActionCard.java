package UnoEngine.Cards;

public class ReverseActionCard extends ActionCard implements HasReverseEffect{
    public ReverseActionCard(Color color) {
        super(color, Symbol.REVERSE);
    }

    @Override
    public Card copy() {
        return new ReverseActionCard(this.color);
    }
}
