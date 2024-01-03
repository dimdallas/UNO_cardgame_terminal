package UnoEngine;

public class WildColorCard extends WildCard implements HasColorEffect{
    public WildColorCard() {
        super(Symbol.WILD_COLOR);
    }

    @Override
    public Card copy() {
        return new WildColorCard();
    }

    @Override
    public void applyColorEffect(Color color){
        setColor(color);
    }

    @Override
    public void resetColor() {
        setColor(Color.WILD);
    }

    @Override
    public void resetActiveEffect() {
        super.resetActiveEffect();
        resetColor();
    }
}
