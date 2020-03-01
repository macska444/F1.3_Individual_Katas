package magyar21;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DeckTest {

    @Test
    public void generateDeckTest() {
        Deck myDeck = new Deck();
        Integer expectedCard = 10;
        assertEquals(expectedCard, myDeck.deck.get(20));
        int expectedNumOfCards = 4 * HunCardRanks.values().length;
        assertEquals(expectedNumOfCards, myDeck.deck.size());
    }

    @Test
    public void getNextCard() {
        Deck myDeck = new Deck();
        Integer nextCard = myDeck.getNextCard();
        System.out.println("Következő kártya: " + nextCard);
        int WholeDeckSize = 4 * HunCardRanks.values().length;
        assertEquals(WholeDeckSize - 1, myDeck.deck.size());
    }

    @Test
    public void getNext2Cards() {
        Deck myDeck = new Deck();
        Integer nextCard = myDeck.getNextCard();
        System.out.println("Következő kártya: " + nextCard);
        nextCard = myDeck.getNextCard();
        System.out.println("Következő kártya: " + nextCard);
        int WholeDeckSize = 4 * HunCardRanks.values().length;
        assertEquals(WholeDeckSize - 2, myDeck.deck.size());
    }

}