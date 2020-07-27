import java.util.ArrayList;

public class Player {

    private String name;
    private ArrayList<PlayingCard> hand;
    private Boolean bust;
    private int wallet;


    public Player(String name, int startingBalance){
        this.name = name;
        this.hand = new ArrayList<PlayingCard>();
        this.wallet = startingBalance;
        this.bust = false;
    }

    public void addCardToHand(PlayingCard playingCard){
        this.hand.add(playingCard);
    }

    public int handCount(){
        return this.hand.size();
    }

    public String getName() {
        return name;
    }

    public Boolean isBust(){
        return this.bust;
    }

    public ArrayList<PlayingCard> showHand(){
        return this.hand;
    }

    public void goBust(){
        this.bust = true;
    }

    public String handAsString(){
        String hand = "";
        for (PlayingCard card : this.hand){
            hand += card.getRank().getRankString();
            hand += card.getSuit().getSuitString();
            hand += " ";
        }
        return hand;
    }


    public void resetBust() {
        this.bust = false;
    }

    public void resetHand() {
        this.hand.clear();
    }
}
