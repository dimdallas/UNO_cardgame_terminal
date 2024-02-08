import UnoEngine.CardPiles.DemoDeckOfCards;
import UnoEngine.GameUtilities.CardDealer;

public class DemoGame extends ClassicGame {

    public DemoGame() {
        cardDealer = new CardDealer(new DemoDeckOfCards(), 4);
    }

    @Override
    public void setPlayersInGame(int totalPlayers) {
        playerQueue.setTotalPlayers(totalPlayers);
        playerQueue.registerPlayer("Jim");
        playerQueue.registerPlayer("Nick");
        playerQueue.registerPlayer("Mike");
        playerQueue.registerPlayer("John");
    }
}
