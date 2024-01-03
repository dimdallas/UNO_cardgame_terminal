package UnoEngine;

public class WildDrawFourCard extends WildCard implements HasColorEffect, HasDrawEffect, HasSkipEffect{
    public WildDrawFourCard() {
        super(Symbol.WILD_DRAW_FOUR);
    }

    @Override
    public Card copy() {
        return new WildDrawFourCard();
    }

    // Returns number of cards for next player to draw
    @Override
    public void applyColorEffect(Color color){
        setColor(color);
    }

    @Override
    public void resetColor() {
        setColor(Color.WILD);
    }

    @Override
    public int cardsToDraw() {
        return 4;
    }

    @Override
    public void resetActiveEffect() {
        super.resetActiveEffect();
        resetColor();
    }
}
