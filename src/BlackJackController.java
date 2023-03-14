import java.util.Scanner;

public class BlackJackController {
    public static void main(String[] args) {
        BlackJackService bjs = new BlackJackService();
        bjs.initialize(); // 카드생성
        bjs.shuffle(); // 카드 섞기
        bjs.setCard(); // 플레이어 2장 딜러 2장 카드 배분

        Scanner scan = new Scanner(System.in);
        boolean control1 = true;
        boolean control2 = true;
        int initControl = 0;
        while(control1){
            if(initControl != 0){
                bjs.clearCard();
                bjs.setCard();
            }
            initControl++;
            System.out.println("<<BlackJack>>");
            System.out.println("1.start game");
            System.out.println("2.Exit");
            System.out.print("Choose your menu:");
            int menu = scan.nextInt();
            if(menu == 1){
                control2 = true;
                bjs.playPrint();
                if(bjs.getPlayerScore() == 21){
                    bjs.resultPrint();
                    System.out.println("Player Win!");
                    break;
                }
            }else{
                System.out.println("Bye");
                control1 = false;
            }
            while(control2){
                System.out.println();
                System.out.println("1.Hit");
                System.out.println("2.Stand");
                System.out.print("Choose your menu:");
                menu = scan.nextInt();
                switch(menu){
                    case 1:
                        bjs.playerHit();
                        if(bjs.getPlayerScore() > 21){
                            bjs.resultPrint();
                            System.out.println("Busted! Player loses."+"\n");
                            control2 = false;
                            break;
                        }else if(bjs.getPlayerScore() == 21){
                            bjs.resultPrint();
                            System.out.println("Player Win!"+"\n");
                            control2 = false;
                            break;
                        }else if(bjs.getPlayerScore() == bjs.getDealerScore()){
                            System.out.println("Draw"+"\n");
                            control2 = false;
                            break;
                        }
                        break;
                    case 2:
                        bjs.playerStand();
                        if(bjs.getPlayerScore() > bjs.getDealerScore()){
                            System.out.println("Player Win!"+"\n");
                            control2 = false;
                            break;
                        }else{
                            if(bjs.getDealerScore() > 21){
                                System.out.println("Player Win!"+"\n");
                                control2 = false;
                                break;
                            }else if(bjs.getPlayerScore() == bjs.getDealerScore()){
                                System.out.println("Draw"+"\n");
                                control2 = false;
                                break;
                            }else{
                                System.out.println("Player Lose"+"\n");
                                control2 = false;
                                break;
                            }
                        }

                }
            }

        }
    }
}
