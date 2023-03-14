import java.util.Collections;

public class BlackJackService {
    CardDeck Deck; // 전체 카드 덱
    Player player = new Player();
    Dealer dealer = new Dealer();
    private int cardPointer = 0; // 배분된 카드와 배분되지않은 카드 구분하는 변수
    public BlackJackService() {
        this.Deck = new CardDeck();
    }
    public void initialize(){ // 카드생성
        for(String Shape : Deck.Shape)
            for(String Number : Deck.Number){
                Deck.cardAdd(new Card(Shape,Number));
            }
    }
    public void shuffle(){ // 카드섞기
        Deck.cardShuffle();
    } // 카드섞기

    public void clearCard(){
        player.clearCard();
        dealer.clearCard();
    }

    public void setCard(){ // 플레이어와 딜러에게 2장씩 카드 배분
        player.clearCard();
        dealer.clearCard();
        for(int i=0; i<2; i++){
            player.cardAdd(Deck.cardDeck.get(++cardPointer));
            dealer.cardAdd(Deck.cardDeck.get(++cardPointer));
        }
    }
    public void playPrint(){ // 딜러와플레이어의 플레이중에 카드와점수를 공개
        player.printCard();
        System.out.println("Player Score : "+getPlayerScore());
        dealer.printCard();
    }
    public void resultPrint(){ // 딜러와플레이어의 모든 카드와점수 마지막에 공개
        System.out.println("---------result-----------");
        player.printCard();
        System.out.println("Player Score : "+getPlayerScore());
        System.out.println(dealer.getDealerCards());
        System.out.println("Dealer Score : "+getDealerScore());
    }
    public void playerHit(){ // 딜러에게 카드를 한 장 더 받는다.
        player.cardAdd(Deck.cardDeck.get(++cardPointer));
        playPrint();
    }

    public void playerStand(){ // 딜러에게 카드를 받지않고 끝낸다.
        int check = getDealerScore();
        while(check < 17){ // 딜러는 16점 이하에서만 카드를 더 받는다.
            dealer.cardAdd(Deck.cardDeck.get(++cardPointer));
            check = getDealerScore();
        }
        resultPrint();
    }
    public int getPlayerScore(){ return player.getScore(); }
    public int getDealerScore(){ return dealer.getScore(); }

}
