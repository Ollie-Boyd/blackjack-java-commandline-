import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public class DealerTest {
    Dealer dealer;
    Player player;
    Deck deck;


    @Before
    public void before(){
        this.dealer = new Dealer();
        this.player = new Player("Harry");
        this.deck = new Deck();
        this.deck.fillDeck();
    }


    @Test
    public void addPlayerToPlayerArray(){
        Player player = new Player("Alex");
        this.dealer.addPlayer(player);
        assertEquals(1, dealer.playerArrayLength());
    }

    @Test
    public void canDealCardToPlayer(){
        this.dealer.dealCard(player, deck);
        assertEquals(1, this.player.handCount());
    }

    @Test
    public void handStartsEmpty(){
        assertEquals(0, this.dealer.showHand().size());
    }

    @Test
    public void canDealCardToSelf(){
        this.dealer.dealSelfCard(deck);
        assertEquals(1, this.dealer.showHand().size());
    }



}
