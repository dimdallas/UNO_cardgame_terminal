package UnoEngine.GameUtilities;

public enum Rotation {
    CLOCKWISE(1), COUNTER_CLOCKWISE(-1);

    private final int value;

    Rotation(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
