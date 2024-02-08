package UnoEngine.CardPiles;

import UnoEngine.Cards.Card;
import UnoEngine.Cards.Color;
import UnoEngine.Cards.CopyableCard;
import UnoEngine.Cards.Symbol;

import java.lang.reflect.InvocationTargetException;
import java.util.Stack;

public abstract class DeckOfCards extends CardPile implements Drawable, CopyableCardStack {

    // INITIALIZED TO 0
    int zeroCards;
    int oneCards;
    int twoCards;
    int threeCards;
    int fourCards;
    int fiveCards;
    int sixCards;
    int sevenCards;
    int eightCards;
    int nineCards;
    int skipCards;
    int reverseCards;
    int drawTwoCards;
    int wildColorCards;
    int wildDrawFourCards;
    int nonColors;
    int realColors;

    public DeckOfCards() {
        initializeValues();
        createCards();
    }

    public abstract void initializeValues();

    public abstract void createCards();

    public int getNumberedCards(){
        return zeroCards +
                oneCards +
                twoCards +
                threeCards +
                fourCards +
                fiveCards +
                sixCards +
                sevenCards +
                eightCards +
                nineCards;
    }

    public int getActionCards(){
        return skipCards + reverseCards + drawTwoCards;
    }

    public int getWildCards(){
        return wildColorCards + wildDrawFourCards;
    }

    public int getTotalCards(){
        return getNumberedCards() + getActionCards() + getWildCards();
    }


    // PROTOTYPE PATTERN
    public void createCardCopies(CopyableCard prototypeCard, int quantity){
        for(int i = 0; i < quantity; i++){
            Card newCard = prototypeCard.copy();
            addTopCard(newCard);
        }
    }

    public void createColoredCopies(Card card, int quantity){
        int perColor = quantity / realColors;
        for (int i = 0 ; i < realColors; i++){
            try {
                createCardCopies(card.getClass()
                        .getDeclaredConstructor(Color.class)
                        .newInstance(Color.getColor(i)), perColor);
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                     NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void createNumberedCopies(Card card, int quantity){
        int perColor = quantity / realColors;

        for (int i = 0 ; i < realColors; i++){
            try {
                createCardCopies(card.getClass()
                        .getDeclaredConstructor(Color.class, Symbol.class)
                        .newInstance(Color.getColor(i), card.getSymbol()), perColor);
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                     NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public Stack<Card> copy() {
        Stack<Card> stackCopy = new Stack<>();
        stackCopy.addAll(this.getCardStack());
        this.removeAllCards();
        return stackCopy;
    }

    @Override
    public Card drawTopCard(){
        return removeTopCard();
    }
}
