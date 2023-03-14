public interface CardSetting {
    void cardAdd(Card card);    // 플레이어와 딜러의 카드 추가
    void clearCard();           // 플레이어와 딜러 카드 리셋
    int getScore();             // 플레이어와 딜러 점수반환
    void printCard();           // 플레이어와 딜러 카드 출력
    void setCardNumber();       // card 객체에서 cardNum 멤버를 객체배열에 저장
}
