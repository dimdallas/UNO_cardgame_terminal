package UnoEngine.PlayerUtilities;

import UnoEngine.CardPiles.DiscardPile;
import UnoEngine.CardPiles.DrawPile;
import UnoEngine.Cards.Card;
import UnoEngine.Cards.Color;
import UnoEngine.Cards.HasColorEffect;
import UnoEngine.Cards.WildCard;

import java.util.AbstractList;
import java.util.Scanner;

public class Player {
    private final String name;
    private final CardsInHand cardsInHand;

    private final DrawPile drawPile;
    private final DiscardPile discardPile;

    private final Scanner playerScanner;
    private boolean toldUno;

    public Player(String name) {
        this.name = name;
        this.cardsInHand = new CardsInHandArrayList();

        drawPile = DrawPile.getInstance();
        discardPile = DiscardPile.getInstance();

        playerScanner = new Scanner(System.in);
        toldUno = false;
    }

    public boolean cardsFinished() {
        return cardsInHand.noCardsRemaining();
    }

    public void playTurn() {
        boolean replay = tryPlayCard(cardsInHand.getValidCardsInHand(), true);

        // if draw card, replay
        if(replay){
            tryPlayCard(cardsInHand.getValidCardsInHand(), false);
        }
    }

    private boolean tryPlayCard(AbstractList<Card> validCards, boolean canRedraw) {
        sortCardsInHand();
        System.out.println("Cards in hand");
        displayCards(cardsInHand.getCards());

        // display Valid cards, Draw and Uno
        displayOptions(validCards, canRedraw);

        return selectOption(validCards, canRedraw);
    }

    private void sortCardsInHand() {
        cardsInHand.sortCards();
    }

    private boolean readyForUno(AbstractList<Card> cards) {
        return cardsInHand.cardsRemaining() == 2 && !cards.isEmpty() && !toldUno;
    }

    private int displayCards(AbstractList<Card> cards){
        if(cards.isEmpty()){
            System.out.println("Not available cards");
            return 0;
        }

        int index;

        for (index=0; index < cards.size(); index++) {
            System.out.println(index + ". " + cards.get(index));
        }

        return index;
    }

    private void displayOptions(AbstractList<Card> cards, boolean canDraw){
        System.out.println("Valid options:");

        int lastIndex = displayCards(cards);
        if(canDraw)
            System.out.println(lastIndex++ +". Draw from pile");
        if(readyForUno(cards))
            System.out.println(lastIndex +". Say UNO");
    }

    private boolean selectOption(AbstractList<Card> validCards, boolean canDraw) {
        if(validCards.isEmpty() && !canDraw){
            System.out.println("PASS");
            return false;
        }
        int drawOption = validCards.size();

        while (true) {
            int index = playerScanner.nextInt();

            if (index < drawOption) {
                playCard(validCards.get(index));
                break;
            } else if (canDraw && index == drawOption) {
                drawCard();
                return true;
            } else {
                if (readyForUno(validCards)) {
                    System.out.println("UNO");
                    toldUno = true;
                    displayOptions(validCards, false);
                    selectOption(validCards, false);
                    break;
                }
                else
                    System.out.println("Not a valid option");
            }
        }

        return false;
    }

    private void drawCard() {
        addCardInHand(drawPile.drawTopCard());
        toldUno = false;
    }

    public void addCardInHand(Card card){
//        cardList.add(card);
        cardsInHand.addCard(card);
    }

    private void playCard(Card card) {
//        cardList.remove(card);
        cardsInHand.removeCard(card);

//        if(card.getColor() == Color.WILD){
        if(card instanceof WildCard){
            printColors();
            applyColorEffect((HasColorEffect) card);
        }

        discardPile.discardCard(card);
    }

    private void applyColorEffect(HasColorEffect card){
        int userInput;
        do {
            userInput = playerScanner.nextInt();
            if(userInput > Color.getRealColors().length){
                System.out.println("Invalid color selection");
            }
        }while (userInput >= Color.getRealColors().length);

        Color selectedColor = Color.getColor(userInput);
        card.applyColorEffect(selectedColor);
    }

    private void printColors(){
        System.out.println("Valid Colors: ");

        Color[] colors = Color.getRealColors();
        int index = 0;
        for (Color color : colors){
            System.out.println(index + ". " + color);
            index++;
        }
    }

    public boolean forgotToSayUNO(){
        return cardsInHand.cardsRemaining() == 1 && !toldUno;
    }

    public int remainingCards(){
        return cardsInHand.cardsRemaining();
    }

    @Override
    public String toString() {
        return name;
    }
}
