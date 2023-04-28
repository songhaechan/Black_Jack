public class BlackJack {
    public static void main(String[] args) {
        BlackJackAssembler assembler = new BlackJackAssembler();
        assembler.createAndWire();
        assembler.game.start();
    }
}