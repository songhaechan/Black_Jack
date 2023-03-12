public final class Card{
    private final String cardShape;
    private final String cardNum;

    public Card(String cardShape, String cardNum) {
        this.cardShape = cardShape;
        this.cardNum = cardNum;
    }
    public String getCardShape() {
        return cardShape;
    }
    public String getCardNum() {
        return cardNum;
    }

    @Override
    public String toString() {
        return "CardShape = " + cardShape + " CardNum = " + cardNum;
    }
}
