package UnoEngine.PlayerUtilities;

import java.util.ArrayList;

public final class CardsInHandArrayList extends CardsInHand {
    public CardsInHandArrayList() {
        cardList = new ArrayList<>();
        cardValidator = ClassicCardValidator.getInstance();
    }
}
