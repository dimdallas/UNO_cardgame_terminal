package UnoEngine.GameUtilities;

import UnoEngine.PlayerUtilities.Player;

import java.util.ArrayList;

public class PlayerQueue {
    private static PlayerQueue Instance;
    ArrayList<Player> players;
    private boolean playerWithNoCards;

//    private int rotation;  //1 = clockWise, -1 counterClockWise
    private Rotation rotation;  //1 = clockWise, -1 counterClockWise
    private int currentPlayer;

    public static PlayerQueue getInstance() {
        if(Instance == null){
            Instance = new PlayerQueue();
        }
        return Instance;
    }

    private PlayerQueue() {
        playerWithNoCards = false;
        rotation = Rotation.CLOCKWISE;
//        rotation = 1;
        currentPlayer = -1;
    }

    public void setTotalPlayers(int totalPlayers){
        players = new ArrayList<>(totalPlayers);
    }

    public void registerPlayer(String playerName){
        players.add(new Player(playerName));
    }

    public boolean hasPlayerWon() {
        return playerWithNoCards;
    }

    public void playTurn() {
        Player currPlayer = getCurrentPlayer();
        currPlayer.playTurn();
        playerWithNoCards = currPlayer.cardsFinished();
    }

    public void reverseRotation() {
        if(rotation == Rotation.CLOCKWISE)
            rotation = Rotation.COUNTER_CLOCKWISE;
        else
            rotation = Rotation.CLOCKWISE;
//        rotation = -rotation;
    }
    public void skipPlayer() {
        setNextPlayer();
    }

    public void setNextPlayer() {
        currentPlayer = getNextPlayerIndex();
    }

    public Player getCurrentPlayer(){
        return players.get(currentPlayer);
    }
    public Player getNextPlayer(){
        return players.get(getNextPlayerIndex());
    }

    public int getNextPlayerIndex(){
        int nextPlayer = currentPlayer + rotation.getValue();

        if(nextPlayer == players.size()) nextPlayer = 0;
        if(nextPlayer == -1) nextPlayer += players.size();
        return nextPlayer;
    }

    public Object[] getPlayers() {
        return players.toArray();
    }
}
