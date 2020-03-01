package magyar21;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DeckTest {

    @Test
    public void generateDeckTest() {
        Deck myDeck = new Deck(1);
        Integer expectedCard = 10;
        assertEquals(expectedCard, myDeck.deck.get(20));
        int expectedNumOfCards = 4 * HunCardRanks.values().length;
        assertEquals(expectedNumOfCards, myDeck.deck.size());
    }

    @Test
    public void getNextCardTest() {
        Deck myDeck = new Deck(1);
        Integer nextCard = myDeck.getNextCard();
        System.out.println("Következő kártya: " + nextCard);
        int WholeDeckSize = 4 * HunCardRanks.values().length;
        assertEquals(WholeDeckSize - 1, myDeck.deck.size());
    }

    @Test
    public void getNext2CardsTest() {
        Deck myDeck = new Deck(1);
        Integer nextCard = myDeck.getNextCard();
        System.out.println("Következő kártya: " + nextCard);
        nextCard = myDeck.getNextCard();
        System.out.println("Következő kártya: " + nextCard);
        int WholeDeckSize = 4 * HunCardRanks.values().length;
        assertEquals(WholeDeckSize - 2, myDeck.deck.size());
    }

    @Test(expected = NoMoreCardInDeck.class)
    public void NoMoreCardInTheDeckTest() {
        Deck myDeck = new Deck(3);
        int WholeDeckSize = 3 * 4 * HunCardRanks.values().length;
        for (int i = 0; i < WholeDeckSize + 1; i++) {
            Integer nextCard = myDeck.getNextCard();
            System.out.println(i + 1 + ". kártya: " + nextCard + " deck mérete: " + myDeck.deck.size());
        }
    }

}