package UnoEngine.Cards;

public enum Color {
    RED("\u001B[31m"),
    YELLOW("\u001B[33m"),
    GREEN("\u001B[32m"),
    BLUE("\u001B[34m"),
    WILD("\u001B[30m");

    private final String ansiColor;

    public String getAnsiColor(){
        return ansiColor;
    }

    Color(String ansiColor) {
        this.ansiColor = ansiColor;
    }

    public static Color[] getRealColors() { return new Color[]{RED, YELLOW, GREEN, BLUE};}
    public static Color[] getNonColors() { return new Color[]{WILD};}

    public static Color getColor(int value){
        return Color.values()[value];
    }
    public static final String ANSI_RESET = "\u001B[0m";
}
