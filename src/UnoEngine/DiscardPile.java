package UnoEngine;

import java.util.Stack;

public class DiscardPile extends CardPile implements CopyableDrawablePile{

    // SINGLETON PATTERN
    private static DiscardPile Instance;

    public static DiscardPile getInstance() {
        if(Instance == null){
            Instance = new DiscardPile();
        }
        return Instance;
    }

    private DiscardPile() {
        super();
    }

    public Card examineTopCard(){
        return getTopCard();
    }
    public void discardCard(Card card) {
        addTopCard(card);
    }

    @Override
    public Stack<Card> copy() {
        Stack<Card> stackCopy = new Stack<>();
        stackCopy.addAll(this.getCardStack());
        this.removeAllCards();
        return stackCopy;
    }

    @Override
    public Card drawTopCard() {
        return removeTopCard();
    }

    public void resetEffects() {
        for(Card card : getCardStack()){
            if(card instanceof EffectCard){
                ((EffectCard) card).resetActiveEffect();
            }
        }
    }
}
