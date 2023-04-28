public class BlackJackPrinter {
    private final Player player;
    private final Dealer dealer;
    private final CardDeck deck; // 전체 카드 덱
    private final int WINING_SCORE = 21; // 21점 = 승리
    private final int DEALER_LIMIT_SCORE = 17; // 17점 이상이면 딜러는 카드를 받지못한다.
    //생성자
    public BlackJackPrinter(Player player, Dealer dealer,CardDeck deck) {
        this.player = player;
        this.dealer = dealer;
        this.deck = deck;
    }

    /**
     * 게임 종료시 결과 프린트
     */
    public void resultPrint() {
        System.out.println("---------result-----------");
        player.printCard();
        System.out.println("Player Score : " + getPlayerScore());
        System.out.println(dealer.getCards());
        System.out.println("Dealer Score : " + getDealerScore());
    }

    /**
     * 게임 중 점수 프린트
     */
    public void scorePrint() {
        player.printCard();
        System.out.println("Player Score : " + getPlayerScore());
        dealer.printCard();
    }

    /**
     * Hit 선택 시 프린트
     */
    public void hit() {
        player.cardAdd(deck.getOneCard());
        scorePrint();

        if (getPlayerScore() > WINING_SCORE) {
            resultPrint();
            System.out.println("Busted! Player loses." + "\n");
            BlackJackGame.secondMenuControl = false;
        }
        if (getPlayerScore() == WINING_SCORE) {
            resultPrint();
            System.out.println("Player Win!" + "\n");
            BlackJackGame.secondMenuControl = false;
        }
        if (getPlayerScore() == getDealerScore()) {
            System.out.println("Draw" + "\n");
            BlackJackGame.secondMenuControl = false;
        }
    }

    /**
     * Stand 선택 시 프린트
     */
    public void stand() {
        int check = getDealerScore();
        while (check < DEALER_LIMIT_SCORE) { // 딜러는 16점 이하에서만 카드를 더 받는다.
            dealer.cardAdd(deck.getOneCard());
            check = getDealerScore();
        }
        resultPrint();

        //조건문으로 점수 검사
        if (getPlayerScore() > getDealerScore()) {
            System.out.println("Player Win!" + "\n");
            BlackJackGame.secondMenuControl = false;
        }
        if (getPlayerScore() < getDealerScore() && getDealerScore() <= WINING_SCORE) {
            System.out.println("Player Lose" + "\n");
            BlackJackGame.secondMenuControl = false;
        }
        if (getDealerScore() > WINING_SCORE) {
            System.out.println("Player Win!" + "\n");
            BlackJackGame.secondMenuControl = false;
        }
        if (getPlayerScore() == getDealerScore()) {
            System.out.println("Draw" + "\n");
            BlackJackGame.secondMenuControl = false;
        }
    }

    // 점수 getter
    public int getPlayerScore() {
        return deck.getScore(player);
    }
    public int getDealerScore() {
        return deck.getScore(dealer);
    }

    /**
     * entranceMenu 에대한 View
     */
    public void entranceView() {
        System.out.println("<<BlackJack>>");
        System.out.println("1.start game");
        System.out.println("2.Exit");
        System.out.print("Choose your menu:");
    }
    /**
     * hitStandMenu 에대한 View
     */
    public void hitStandView(){
        System.out.println();
        System.out.println("1.Hit");
        System.out.println("2.Stand");
        System.out.print("Choose your menu:");
    }
}
