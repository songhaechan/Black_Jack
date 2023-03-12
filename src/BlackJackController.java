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
        System.out.print("Choose your menu:");
        Scanner scan = new Scanner(System.in);
        boolean control = true;
        while(control){
            int menu = scan.nextInt();
            if(menu == 1){
                bjs.Print();
                if(bjs.playerScore() == 21){
                    System.out.println("Player Win!");
                    System.exit(0);
                }
            }else{
                System.out.println("Bye");
                control = false;
            }
            while(true){
                System.out.println();
                System.out.println("1.Hit");
                System.out.println("2.Stand");
                System.out.print("Choose your menu:");
                menu = scan.nextInt();
                switch(menu){
                    case 1:
                        bjs.playerHit();
                        if(bjs.playerScore() > 21){
                            bjs.dealer.printCardAll();
                            System.out.println();
                            System.out.println("Busted! Player loses.");
                            System.exit(0);
                        }else if(bjs.playerScore() == 21){
                            bjs.dealer.printCardAll();
                            System.out.println("Player Win!");
                            System.exit(0);
                        }else if(bjs.playerScore() == bjs.dealerScore()){
                            System.out.println("Draw");
                        }
                        break;
                    case 2:
                        bjs.playerStand();
                        if(bjs.playerScore() > bjs.dealerScore()){
                            System.out.println("Player Win!");
                            System.exit(0);
                        }else{
                            if(bjs.dealerScore() > 21){
                                System.out.println("Player Win!");
                                System.exit(0);
                            }else if(bjs.playerScore() == bjs.dealerScore()){
                                System.out.println("Draw");
                                System.exit(0);
                            }else{
                                System.out.println("Player Lose");
                                System.exit(0);
                            }
                        }
                        break;

                }
            }

        }
    }
}
