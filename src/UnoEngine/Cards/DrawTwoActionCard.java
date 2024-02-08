package UnoEngine.Cards;

public class DrawTwoActionCard extends ActionCard implements HasSkipEffect, HasDrawEffect{
    public DrawTwoActionCard(Color color) {
        super(color, Symbol.DRAW_TWO);
    }

    @Override
    public Card copy() {
        return new DrawTwoActionCard(this.color);
    }

    @Override
    public int cardsToDraw() {
        return 2;
    }
}
