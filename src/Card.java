public final class Card {
    private String shape;
    private String number;
    private int score;

    public Card(String shape) {
        this.shape = shape;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "CardShape = " + shape + " CardNum = " + number;
    }
}
