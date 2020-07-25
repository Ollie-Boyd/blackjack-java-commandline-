import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerTest {

    private Player player;
    private PlayingCard playingCard;

    @Before
    public void before(){
        this.player = new Player("Harrison");
        this.playingCard = new PlayingCard(Suit.HEARTS, Rank.ACE);
    }

    @Test
    public void getName() {
        assertEquals("Harrison", this.player.getName());
    }

    @Test
    public void handCount() {
        player.addCardToHand(playingCard);
        assertEquals(1, player.handCount());
    }

    @Test
    public void canShowHand(){
        player.addCardToHand(playingCard);
        player.addCardToHand(playingCard);
        assertEquals(2, player.showHand().size());
    }


}
