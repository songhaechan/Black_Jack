public class BlackJackAssembler {
    BlackJackGame game;
    public void createAndWire(){
        Player player = new Player();
        Dealer dealer = new Dealer();
        CardDeck deck = new CardDeck();
        BlackJackPrinter printer = new BlackJackPrinter(player,dealer,deck);
        BlackJackMenuLocator locator = new BlackJackMenuLocator(player,dealer,printer,deck);
        game = new BlackJackGame(player, dealer,locator,printer,deck);
    }
}
