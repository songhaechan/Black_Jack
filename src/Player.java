import java.util.ArrayList;

public class Player extends BlackJackPlayer {
    @Override
    public void printCard() {
        System.out.print("Player's Cards : " + getCards() + "\n");
    }

    public Player(){};
}

