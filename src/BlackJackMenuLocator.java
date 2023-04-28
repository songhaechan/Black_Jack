public class BlackJackMenuLocator {
    private final CardDeck deck;
    private final Player player;
    private final Dealer dealer;
    private BlackJackPrinter printer;
    private final int WINING_SCORE = 21; // 21점 = 승리
    //생성자
    public BlackJackMenuLocator(Player player, Dealer dealer, BlackJackPrinter printer,CardDeck deck) {
        this.player = player;
        this.dealer = dealer;
        this.printer = printer;
        this.deck = deck;
    }

    public void executeMainMenu(int menu) {
        if (menu == 1) {
            BlackJackGame.secondMenuControl = true;
            printer.scorePrint();
        }
        if (deck.getScore(player) == WINING_SCORE) {
            printer.resultPrint();
            System.out.println("Player Win!");
        }
        if(menu != 1){
            System.out.println("Bye");
            BlackJackGame.firstMenuControl = false;
        }
    }
    public void executeHitStandMenu(int menu){
        if (menu == 1) {
            printer.hit();
        }
        if (menu == 2) {
            printer.stand();
        }
    }

}
