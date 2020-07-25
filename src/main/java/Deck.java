import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    private ArrayList<PlayingCard> cards;

    public Deck(){
        this.cards = new ArrayList<PlayingCard>();
    }

    public int getCardCount(){
        return this.cards.size();
    }


    public ArrayList<PlayingCard> fillDeck() {
        for (Suit cardSuit : Suit.values()){
            for (Rank cardRank : Rank.values()){
                PlayingCard playingCard = new PlayingCard(cardSuit, cardRank);
                this.cards.add(playingCard);
            }
        }
        shuffleDeck();
        return cards;
    }

    public void shuffleDeck(){
        Collections.shuffle(cards);
    }

    public PlayingCard dealCard(){
        return this.cards.remove(0);
    }
}
