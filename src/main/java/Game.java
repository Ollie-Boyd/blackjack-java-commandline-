import java.util.Scanner;

public class Game {

    Scanner in = new Scanner(System.in);

    public void gameLoop(Player player, Dealer dealer, Deck deck){
        System.out.println("");
        System.out.println(player.getName()+"'s hand: " + player.handAsString() + "(" + dealer.calculateHandValue(player.showHand()) + ") ");
        System.out.println(player.getName()+", will you stand or hit? 's' for stand or 'h' for hit");
        String decision = in.nextLine();
        if (!decision.equals("s") && !decision.equals("h")){
            gameLoop(player, dealer, deck);
        } else if (decision.equals("h")){
            dealer.dealCard(player, deck);
            System.out.println(player.getName()+"'s hand: " + player.handAsString() + "(" + dealer.calculateHandValue(player.showHand()) + ") " + dealer.checkForLoser(player));
            dealer.checkForLoser(player);
            if (!player.isBust()){
                gameLoop(player, dealer, deck);
            }
        }
    }
}
