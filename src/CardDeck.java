import java.util.ArrayList;
import java.util.Collections;

public class CardDeck{
    // 카드모양
    final String[] Shape = {"Heart", "Diamond", "Clover", "Spade"};
    // 카드 숫자 A는 1or11 J,Q,K 는 10
    final String[] Number = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
    ArrayList<Card> cardDeck = new ArrayList<>();

    public void cardAdd(Card card){ // 덱에 카드 추가
        cardDeck.add(card);
    }
    public void cardShuffle(){ // 카드 섞기
        Collections.shuffle(cardDeck);
    }
}
