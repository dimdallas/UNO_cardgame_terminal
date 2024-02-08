package UnoEngine.Cards;

public abstract class WildCard extends EffectCard {
    protected WildCard(Symbol symbol) {
        super(Color.WILD, symbol);
    }
}
