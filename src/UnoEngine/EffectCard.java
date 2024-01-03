package UnoEngine;

public abstract class EffectCard extends Card {
    private boolean activeEffect;

    protected EffectCard(Color color, Symbol symbol) {
        super(color, symbol);
        activeEffect = true;
    }

    public boolean hasActiveEffect() {
        return activeEffect;
    }

    public void setInactiveEffect() {
        activeEffect = false;
    }
    public void resetActiveEffect() {
        activeEffect = true;
    }
}
