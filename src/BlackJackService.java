import java.util.Collections;

public class BlackJackService {
    CardDeck Deck; // 전체 카드 덱
    Player player = new Player();
    Dealer dealer = new Dealer();
    private int cardPointer = 0; // 배분된 카드와 배분되지않은 카드 구분하는 변수
    public BlackJackService() {
        this.Deck = new CardDeck();
    }
    public void initialize(){ // 모양과 숫자별로 ArrayList 에 저장
        for(String Shape : Deck.Shape)
            for(String Number : Deck.Number){
                Deck.cardAdd(new Card(Shape,Number));
            }
    }
    public void shuffle(){ // 카드섞기
        Deck.cardShuffle();
    }
    public void setCard(){ // 플레이어와 딜러에게 2장씩 카드 배분
        player.cardAdd(Deck.cardDeck.get(++cardPointer));
        player.cardAdd(Deck.cardDeck.get(++cardPointer));
        dealer.cardAdd(Deck.cardDeck.get(++cardPointer));
        dealer.cardAdd(Deck.cardDeck.get(++cardPointer));
    }
    public void fristPrint(){
        player.printCard();
        System.out.println();
        System.out.println("Player Score : "+player.getScore());
        System.out.println();
        dealer.printCard();
        System.out.println();
        System.out.println("Dealer Score : "+dealer.getScore());
    }


}
