import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardDeck {
    private final String[] shapes = {"Heart", "Diamond", "Clover", "Spade"};
    private final String[] numbers = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
    private final int[] score = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10};
    private int cardPointer = 0; // 배분된 카드의 수
    private List<Card> cardDeck = new ArrayList<>();
    public CardDeck(){}


    /**
     * 카드생성
     */
    public void createCards() {
        for (String s : shapes) {
            for (int j = 0; j < numbers.length; j++) {
                Card tmpCard = new Card(s);
                tmpCard.setScore(score[j]);
                tmpCard.setNumber(numbers[j]);
                cardDeck.add(tmpCard);
            }
        }
    }

    /**
     * 점수 계산
     */
    public int getScore(BlackJackPlayer bp) {
        List<Card> cards = bp.getCards();
        final int SCORE_OF_A = 1;
        final int SMALL_A_SCORE = 1;
        final int BIG_A_SCORE = 11;
        final int WINING_SCORE = 21;
        int scoreSum = 0;
        for (Card card : cards) {
            int tmp = card.getScore();
            if (tmp != SCORE_OF_A) {
                scoreSum += tmp;
                continue;
            }
            if (scoreSum + BIG_A_SCORE > WINING_SCORE) {
                scoreSum += SMALL_A_SCORE;
            }
            if (scoreSum + BIG_A_SCORE == WINING_SCORE) {
                scoreSum += BIG_A_SCORE;
            }
            if (scoreSum + SMALL_A_SCORE < WINING_SCORE) {
                scoreSum += SMALL_A_SCORE;
            }
        }
        return scoreSum;
    }

    // 카드 하나 반환
    public Card getOneCard(){
        return cardDeck.get(cardPointer++);
    }

    // 카드 초기화
    public void resetCardPointer(){
        cardPointer = 0;
    }

    /**
     * 카드 Shuffle
     */
    public void cardShuffle() {
        Collections.shuffle(cardDeck);
    }
}
