import java.util.ArrayList;
import java.util.Collections;

public class BlackJackService {
    // 카드모양
    private final String[] Shape = {"Heart", "Diamond", "Clover", "Spade"};
    // 카드 숫자 A는 1or11 J,Q,K 는 10
    private final String[] Number = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
    // ArrayList 로 카드 객체를 저장 (카드를 나눠준뒤 카드를 삭제하기위해 public 으로 선언)
    public ArrayList<Card> CardDeck = new ArrayList<>();

    public BlackJackService() {}

    public void initialize(){
        for(String Shape : Shape)
            for(String Number : Number){
                CardDeck.add(new Card(Shape,Number));
            }
    }
    public void shuffle(){
        Collections.shuffle(CardDeck);
    }



}
