import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DeckTest {

        Deck deck;

        @Before
        public void before(){
            deck = new Deck();
        }

        @Test
        public void deckStartsEmpty(){
            assertEquals(0, deck.getCardCount());
        }

        @Test
        public void canFillDeck(){
            this.deck.fillDeck();
            assertEquals(52, deck.getCardCount());
        }

        @Test
        public void canDealCard(){
            this.deck.fillDeck();
            PlayingCard testPlayingCard = new PlayingCard(Suit.HEARTS, Rank.SIX);
            assertEquals(testPlayingCard.getClass().getName(), deck.dealCard().getClass().getName());
        }

        @Test
        public void dealingRemovesCard(){
            this.deck.fillDeck();
            this.deck.dealCard();
            assertEquals(51, this.deck.getCardCount());
        }
}