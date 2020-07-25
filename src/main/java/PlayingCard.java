public class PlayingCard {

    private Suit suit;
    private Rank rank;

    public PlayingCard(Suit suit, Rank rank){
        this.suit = suit;
        this.rank = rank;
    }
    public Suit getSuit(){
        return this.suit;
    }

    public Rank getRank(){
        return this.rank;
    }
}
