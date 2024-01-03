package UnoEngine;

import java.util.ArrayList;

public class CardsInHandArrayList extends CardsInHand {
    public CardsInHandArrayList() {
        cardList = new ArrayList<>();
        cardValidator = ClassicCardValidator.getInstance();
    }
}
