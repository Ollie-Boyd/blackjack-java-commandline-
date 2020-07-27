import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public class DealerTest {
    Dealer dealer;
    Player player;
    Deck deck;


    @Before
    public void before(){
        this.dealer = new Dealer();
        this.player = new Player("Harry", 20);
        this.deck = new Deck();
        this.deck.fillDeck();
    }


    @Test
    public void addPlayerToPlayerArray(){
        Player player = new Player("Alex", 20);
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

    @Test
    public void canCalculateHandValue(){
        PlayingCard testPlayingCard1 = new PlayingCard(Suit.HEARTS, Rank.ACE);
        PlayingCard testPlayingCard2 = new PlayingCard(Suit.CLUBS, Rank.SIX);
        PlayingCard testPlayingCard3 = new PlayingCard(Suit.HEARTS, Rank.ACE);
        PlayingCard testPlayingCard4 = new PlayingCard(Suit.SPADES, Rank.SIX);
        ArrayList<PlayingCard> hand = new ArrayList<PlayingCard>();
        hand.add(testPlayingCard1);
        hand.add(testPlayingCard2);
        hand.add(testPlayingCard3);
        hand.add(testPlayingCard4);
        assertEquals(14, dealer.calculateHandValue(hand));
    }


    @Test
    public void canCalculateHandValueNoAces(){
        PlayingCard testPlayingCard1 = new PlayingCard(Suit.HEARTS, Rank.TWO);
        PlayingCard testPlayingCard2 = new PlayingCard(Suit.CLUBS, Rank.THREE);
        PlayingCard testPlayingCard3 = new PlayingCard(Suit.HEARTS, Rank.TWO);
        PlayingCard testPlayingCard4 = new PlayingCard(Suit.SPADES, Rank.QUEEN);
        ArrayList<PlayingCard> hand = new ArrayList<PlayingCard>();
        hand.add(testPlayingCard1);
        hand.add(testPlayingCard2);
        hand.add(testPlayingCard3);
        hand.add(testPlayingCard4);
        assertEquals(17, dealer.calculateHandValue(hand));
    }

    @Test
    public void canCalculateHandValueAllAces(){
        PlayingCard testPlayingCard1 = new PlayingCard(Suit.HEARTS, Rank.ACE);
        PlayingCard testPlayingCard2 = new PlayingCard(Suit.CLUBS, Rank.ACE);
        PlayingCard testPlayingCard3 = new PlayingCard(Suit.HEARTS, Rank.ACE);
        PlayingCard testPlayingCard4 = new PlayingCard(Suit.SPADES, Rank.ACE);
        ArrayList<PlayingCard> hand = new ArrayList<PlayingCard>();
        hand.add(testPlayingCard1);
        hand.add(testPlayingCard2);
        hand.add(testPlayingCard3);
        hand.add(testPlayingCard4);
        assertEquals(14, dealer.calculateHandValue(hand));
    }





}
