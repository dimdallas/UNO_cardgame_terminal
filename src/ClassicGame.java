import UnoEngine.*;

public class ClassicGame extends Game {
    public ClassicGame() {
        playerQueue = PlayerQueue.getInstance();

        discardPile = DiscardPile.getInstance();
        drawPile = DrawPile.getInstance();

//        cardDealer = new CardDealer(new ClassicDeckOfCards(), 7);
        cardDealer = new CardDealer(new DemoDeckOfCards(), 5);
    }

    @Override
    public void setPlayersInGame(int totalPlayers) {
        playerQueue.setTotalPlayers(totalPlayers);
        playerQueue.registerPlayer("Jim");
        playerQueue.registerPlayer("Nick");
        playerQueue.registerPlayer("Mike");
        playerQueue.registerPlayer("John");
    }

    @Override
    public void play() {
        setPlayersInGame(4);
        cardDealer.dealStartingCards(playerQueue.getPlayers());
        cardDealer.deckToDrawPile();

        int i=0;

        while (gameNotEnded()){
            System.out.println("-----------"+ (i++) +"-----------");
            if(drawPile.isEmpty())
                cardDealer.discardedToDraw();
            System.out.println("Cards remaining in DrawPile: " + drawPile.countCards());

            displayDiscardTop();

            manageCardEffects();

            managePenalties();

            managePlayerTurn();
        }

        System.out.println("Player " + playerQueue.getCurrentPlayer() + " has won");
    }

    @Override
    protected void managePenalties() {
        Player currentPlayer = playerQueue.getNextPlayer();

        if(currentPlayer.forgotToSayUNO()){
            givePenalty(currentPlayer);
        }
    }

    @Override
    protected void managePlayerTurn() {
        playerQueue.setNextPlayer();
        System.out.println("Current player: " + playerQueue.getCurrentPlayer()
                +", cards remaining: " + playerQueue.getCurrentPlayer().remainingCards());

        playerQueue.playTurn();
    }

    @Override
    protected void manageCardEffects() {
        Card inspectedCard = discardPile.examineTopCard();
        if(checkActiveEffect(inspectedCard))
            applyEffect((EffectCard) inspectedCard);
    }
}
