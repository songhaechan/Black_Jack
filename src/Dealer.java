import java.util.ArrayList;

public class Dealer extends BlackJackPlayer {

    @Override
    public void printCard() {
        System.out.print("Dealer's Cards: " + "[" + getCards().get(0) + ", Card was hidden ]" + "\n");
    }

    public Dealer(){};
}
