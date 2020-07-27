import java.lang.reflect.Array;
import java.util.ArrayList;

public class Dealer {
    private ArrayList<Player> playerList;
    private ArrayList<PlayingCard> dealerHand;


    public Dealer(){
        this.playerList = new ArrayList<Player>();
        this.dealerHand = new ArrayList<PlayingCard>();
    }

    public void addPlayer(Player player){
        this.playerList.add(player);
    }

    public int playerArrayLength(){
        return this.playerList.size();
    }

    public ArrayList<Player> getPlayerList() {
        return playerList;
    }

    public ArrayList<Player> getNonBustPlayerList() {
        ArrayList<Player> nonBustPlayers = new ArrayList<Player>();
        for (Player player : playerList){
            if (!player.isBust()){
                nonBustPlayers.add(player);
            }
        }
        return nonBustPlayers;
    }

    public void dealCard(Player  player, Deck deck){
        PlayingCard card = deck.dealCard();
        player.addCardToHand(card);
    }

    public void dealSelfCard(Deck deck){
        PlayingCard card =  deck.dealCard();
        this.dealerHand.add(card);
    }

    public ArrayList<PlayingCard> showHand(){
        return this.dealerHand;
    }

    public void dealToEachValidPlayer(Deck deck){
        for (Player player : this.playerList){
            if (!player.isBust()){
                this.dealCard(player, deck);
            }
        }
    }

    public void initialDeal(Deck deck){
        int cardsInHands = 0;
        while (cardsInHands < 2){
            this.dealToEachValidPlayer(deck);
            cardsInHands+= 1;
        }
        this.dealSelfCard(deck);
    }

    public int calculateHandValue(ArrayList<PlayingCard> hand) {
        int totalValue = 0;
        ArrayList<PlayingCard> aces = new ArrayList<PlayingCard>();

        for (PlayingCard card : hand) {
            int cardValue = card.getRank().getValue();

            if (cardValue == 11) {
                aces.add(card);
            } else {
                totalValue += cardValue;
            }
        }

        for (PlayingCard ace : aces) {
            if ((totalValue + 11)>21){
                totalValue += 1;
            } else {
                totalValue += 11;
            }
        }
        return totalValue;
    }

    public String handAsString(){
       String hand = "";
       for (PlayingCard card : this.dealerHand){
           hand += card.getRank().getRankString();
           hand += card.getSuit().getSuitString();
           hand += " ";
       }
       return hand;
    }

    public String checkForLoser(Player player){
        if (calculateHandValue(player.showHand()) > 21) {
            player.goBust();
            return ("Sorry " + player.getName() + " you're bust!");
        }
        return "";
    }


    public void checkForFinalWinLose(Player player) {
        int dealerValue = this.calculateHandValue(this.showHand());
        int playerValue = this.calculateHandValue(player.showHand());
        String playerName = player.getName();
        if (dealerValue>playerValue){
            System.out.println("Sorry, "+playerName+" better luck next time");
        }  else if (dealerValue == playerValue) {
            System.out.println("It's a draw, "+playerName);
        } else {
            System.out.println("You won "+playerName);
        }
    }

    public void resetDeck() {
        this.dealerHand.clear();
    }
}
