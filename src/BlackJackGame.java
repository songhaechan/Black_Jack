import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BlackJackGame {
    private final CardDeck deck; // 전체 카드 덱
    private final Player player;
    private final Dealer dealer;
    private final BlackJackMenuLocator locator;
    private final BlackJackPrinter printer;
    public static boolean firstMenuControl = true; // 메뉴 입력 컨트롤 필드
    public static boolean secondMenuControl = true; // 메뉴 입력 컨트롤 필드
    private int menu = 0; // 메뉴 입력받는 필드

    //생성자
    public BlackJackGame(Player player, Dealer dealer, BlackJackMenuLocator locator, BlackJackPrinter printer, CardDeck deck) {
        this.player = player;
        this.dealer = dealer;
        this.locator = locator;
        this.printer = printer;
        this.deck = deck;
    }

    private void setMenu(int menu) {
        this.menu = menu;
    }
    private int getMenu() { return menu;}

    /**
     * 메뉴 제어
     */
    public void start() {
        while (firstMenuControl) {
            entranceMenu();
            while (secondMenuControl) {
                hitStandMenu();
            }
        }
    }

    /**
     * BlackJackView 에 표시할 첫 화면
     * 1 입력 시 점수 출력 (scorePrint)
     * 1.1 첫 번째 턴에 플레이어 21점 획득시 승리결과화면 출력 (resultPrint)
     * 2 입력 시 종료
     */
    public void entranceMenu() {
        cardSetting();
        printer.entranceView();
        setMenu(getMenuFromPlayer());
        locator.executeMainMenu(getMenu());
    }

    /**
     * BlackJackView 에 표시할 두 번째 화면
     * Hit 과 Stand 에대한 메뉴 입력대기
     * Hit : 플레이어가 카드 한 장을 더 받는다.
     * Stand : 플레이어가 카드를 더 이상 받지않고 게임을 끝낸다.
     */
    public void hitStandMenu() {
        printer.hitStandView();
        setMenu(getMenuFromPlayer());
        locator.executeHitStandMenu(getMenu());
    }

    /**
     * 카드 세팅 메서드
     * 카드 초기화, 카드 생성, 카드 섞기, 카드 2장씩 배분
     */
    public void cardSetting() {
        //카드 초기화
        deck.resetCardPointer();
        player.clearCard();
        dealer.clearCard();

        // 카드생성
        deck.createCards();

        // 카드 섞기
        deck.cardShuffle();

        // 플레이어와 딜러에게 2장씩 카드 배분
        for (int i = 0; i < 2; i++) {
            player.cardAdd(deck.getOneCard());
            dealer.cardAdd(deck.getOneCard());
        }
    }

    /**
     * Player 로 부터 BufferedReader 로 메뉴입력
     */
    public int getMenuFromPlayer() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int i = 0;
        try {
            String s = br.readLine();
            i = Integer.parseInt(s);
        } catch (IOException e) {
            System.out.println("읽어들일 자원이 없습니다.");
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("숫자를 입력해주세요.");
            e.printStackTrace();
        }
        return i;
    }

}
