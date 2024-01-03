package UnoEngine;

public enum Rotation {
    CLOCKWISE(1), COUNTER_CLOCKWISE(-1);

    private int value;

    Rotation(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
