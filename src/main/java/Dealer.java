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

    public void dealCard(Player  player, Deck deck){
        PlayingCard card = deck.dealCard();
        player.addCardToHand(card);
    }

    public void dealSelfCard(Deck deck){
        PlayingCard card =  deck.dealCard();
        dealerHand.add(card);
    }

    public ArrayList<PlayingCard> showHand(){
        return this.dealerHand;
    }

    public void initialDeal()


}
