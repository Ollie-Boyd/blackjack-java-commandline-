import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayingCardTest {
    PlayingCard playingCard;

    @Before
    public void before(){
        this.playingCard = new PlayingCard(Suit.CLUBS, Rank.FIVE);
    }

    @Test
    public void getSuit(){
        assertEquals(Suit.CLUBS, this.playingCard.getSuit());
    }

    @Test
    public void getRank(){
        assertEquals(Rank.FIVE, this.playingCard.getRank());
    }
}
