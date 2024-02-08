import UnoEngine.GameUtilities.Game;
public class GameDriver {
    public static void main(String[] args) {
//        Game test = new ClassicGame();
        Game test = new DemoGame();
        test.setPlayersInGame(4);
        test.play();
    }
}
