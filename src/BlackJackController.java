import java.util.Scanner;

public class BlackJackController {
    public static void main(String[] args) {
        BlackJackService bjs = new BlackJackService();
        bjs.initialize(); // 카드생성
        bjs.shuffle(); // 카드 섞기
        bjs.setCard(); // 플레이어 2장 딜러 2장 카드 배분
        System.out.println("<<BlackJack>>");
        System.out.println("1.start game");
        System.out.println("2.Exit");
        Scanner scan = new Scanner(System.in);
        while(true){
            int menu = scan.nextInt();
            switch(menu){
                case 1:
                    bjs.fristPrint();
                    break;
                case 2:

            }

        }
    }
}
