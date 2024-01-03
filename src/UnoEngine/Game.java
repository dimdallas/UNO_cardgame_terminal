package UnoEngine;

public abstract class Game {
    protected PlayerQueue playerQueue;
    protected DrawPile drawPile;
    protected DiscardPile discardPile;
    protected CardDealer cardDealer;

    // CARD MANAGER MAYBE

    protected abstract void setPlayersInGame(int totalPlayers);

    public abstract void play();

    protected boolean gameNotEnded() {
        return !playerQueue.hasPlayerWon();
    }

    protected boolean checkActiveEffect(Card card){
        if(card instanceof EffectCard)
            return ((EffectCard) card).hasActiveEffect();

        return false;
    }

    protected void applyEffect(EffectCard card) {
        if(card instanceof HasReverseEffect) {
            playerQueue.reverseRotation();
        }
        if(card instanceof HasDrawEffect)
        {
            int cardsToDeal = ((HasDrawEffect) card).cardsToDraw();
            cardDealer.dealToPlayer(playerQueue.getNextPlayer(), cardsToDeal);
            System.out.println(playerQueue.getNextPlayer() + " draws " + cardsToDeal + " cards");

        }
        if(card instanceof HasSkipEffect) {
            System.out.println(playerQueue.getNextPlayer() + " is SKIPPED");
            playerQueue.skipPlayer();
        }
        card.setInactiveEffect();
    }

    protected void displayDiscardTop() {
        Card topCard = discardPile.examineTopCard();

        if(topCard != null)
            System.out.println("Discard pile: " + topCard);
        else {
            System.out.println("Discard pile is empty");
        }
    }

    protected void givePenalty(Player currentPlayer){
        System.out.println("Player didn't say UNO, he gets PENALTY");
        System.out.println(currentPlayer + " draws 2 cards");
        cardDealer.dealToPlayer(currentPlayer, 2);
    }

    protected abstract void manageCardEffects();

    protected abstract void managePenalties();

    protected abstract void managePlayerTurn();

}
