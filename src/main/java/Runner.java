import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Dealer dealer = new Dealer();
        Deck deck = new Deck();
        Game game = new Game();
        deck.fillDeck();
        deck.fillDeck();
        deck.fillDeck();

        System.out.println("Welcome to blackjack, how many players are there?");
        int numberPlayers = in.nextInt();
        in.nextLine(); //needed to consume the newline from nextInt() (nextInt only consumes the int)

        int playersCreated = 0;
        while (playersCreated<numberPlayers) {
            System.out.println("");
            int currentPlayer = playersCreated+1;
            System.out.println("Player " + currentPlayer +" name?");
            String name = in.nextLine();
            Player newPlayer = new Player(name, 100);
            dealer.addPlayer(newPlayer);
            System.out.println("Welcome " + newPlayer.getName());
            playersCreated += 1;
        }


        while (dealer.playerArrayLength()>1){

            System.out.println("Get ready!");
            System.out.println("");
            dealer.initialDeal(deck);

            System.out.println("Dealer's hand: " + dealer.handAsString() + "\uD83C\uDCA0" );

            for (Player player : dealer.getPlayerList()){
                System.out.println(player.getName()+"'s hand: " + player.handAsString() + "(" + dealer.calculateHandValue(player.showHand()) + ") " + dealer.checkForLoser(player));
                dealer.checkForLoser(player);
            }

            for (Player player : dealer.getNonBustPlayerList()){
                game.gameLoop(player, dealer, deck);
            }

            dealer.dealSelfCard(deck);
            System.out.println("OK, let's see the dealer's hidden card: " + dealer.handAsString() + " ("+ dealer.calculateHandValue(dealer.showHand()) +")");

            while (dealer.calculateHandValue(dealer.showHand())<17){
                dealer.dealSelfCard(deck);
                System.out.println(dealer.handAsString() + " ("+ dealer.calculateHandValue(dealer.showHand()) +")");
                if (dealer.calculateHandValue(dealer.showHand())>21){
                    System.out.println("Dealer's bust!");
                }
            }

            for (Player player : dealer.getNonBustPlayerList()){
                dealer.checkForFinalWinLose(player);
            }

            for (Player player : dealer.getPlayerList()){
                player.resetBust();
                player.resetHand();
            }
            dealer.resetDeck();

            //check if deck nearing empty,
        }

    }
}
