import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Player implements CardSetting{
    private final ArrayList<Card> playerCards = new ArrayList<Card>();// 플레이어의 카드
    String[] cardNum;
    @Override
    public void setCardNumber(){
        int size = playerCards.size();
        cardNum = new String[size];
        for(int i=0; i<size; i++){
            cardNum[i] = playerCards.get(i).getCardNum();
        }
    }

    public int getScore(){
        int score = 0;
        setCardNumber();
        for (int i=0; i<playerCards.size(); i++){
            if (cardNum[i].equals("J") || cardNum[i].equals("Q")
                    || cardNum[i].equals("K"))
                score += 10;
            if(cardNum[i].equals("1"))
                score += 1;
            if(cardNum[i].equals("2"))
                score += 2;
            if(cardNum[i].equals("3"))
                score += 3;
            if(cardNum[i].equals("4"))
                score += 4;
            if(cardNum[i].equals("5"))
                score += 5;
            if(cardNum[i].equals("6"))
                score += 6;
            if(cardNum[i].equals("7"))
                score += 7;
            if(cardNum[i].equals("8"))
                score += 8;
            if(cardNum[i].equals("9"))
                score += 9;
            if(cardNum[i].equals("10"))
                score += 10;
            if(cardNum[i].equals("A")){
                if(score+11>21)
                    score += 1;
                else
                    score += 11;
            }
        }
        return score;
    }

    @Override
    public void cardAdd(Card card){
        playerCards.add(card);
    }

    @Override
    public void printCard(){
        System.out.print("Player: "+playerCards);
    }


}

