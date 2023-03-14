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
    } // 카드섞기

    public void setCard(){ // 플레이어와 딜러에게 2장씩 카드 배분
        player.cardAdd(Deck.cardDeck.get(++cardPointer));
        player.cardAdd(Deck.cardDeck.get(++cardPointer));
        dealer.cardAdd(Deck.cardDeck.get(++cardPointer));
        dealer.cardAdd(Deck.cardDeck.get(++cardPointer));
    }
    public int playerScore(){ return player.getScore(); }
    public int dealerScore(){ return dealer.getScore(); }
    public void Print(){ // 딜러와 플레이어의 카드,점수 출력
        player.printCard();
        System.out.println("Player Score : "+playerScore());
        dealer.printCard();
    }
    public void playerHit(){
        player.cardAdd(Deck.cardDeck.get(++cardPointer));
        Print();
    }

    public void playerStand(){
        int check = dealerScore();
        while(check < 17){
            dealer.cardAdd(Deck.cardDeck.get(++cardPointer));
            check = dealerScore();
        }
        player.printCard();
        System.out.println("Player Score : "+playerScore());
        dealer.printCardAll();
    }

}
