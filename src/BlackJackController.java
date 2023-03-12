public class BlackJackController {
    public static void main(String[] args) {
        BlackJackService blackJackService = new BlackJackService();
        blackJackService.initialize(); // 카드생성
        blackJackService.shuffle(); // 카드 섞기
    }
}
