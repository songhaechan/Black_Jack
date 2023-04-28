import java.util.ArrayList;
import java.util.List;

public abstract class BlackJackPlayer {
    private final List<Card> cards = new ArrayList<Card>();

    // 플레이어와 딜러 카드 출력
    public abstract void printCard();

    // 플레이어와 딜러 카드 리셋
    public void clearCard() {
        cards.clear();
    }

    // 플레이어와 딜러의 카드 추가
    public void cardAdd(Card card) {
        cards.add(card);
    }

    public List<Card> getCards() {
        return cards;
    }
}
