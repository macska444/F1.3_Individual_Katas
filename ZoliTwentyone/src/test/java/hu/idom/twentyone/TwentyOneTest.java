package hu.idom.twentyone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Test;

public class TwentyOneTest {

    private Player joePlayer = new Player("Joe");

    private List<Player> players = Arrays.asList(new Player("Joe"), new Player("Jane"), new Player("John"));

    @Test(expected = GameCantStartException.class)
    public void gameWithNullPlayer() {
        TwentyOneGame game = new TwentyOneGame(null);
    }

    @Test(expected = GameCantStartException.class)
    public void numberOfPlayerNotEnough() {
        TwentyOneGame game = new TwentyOneGame(Arrays.asList(joePlayer));
    }

    @Test(expected = GameCantStartException.class)
    public void numberOfPlayerToMuch() {
        List<Player> players = Arrays.asList(joePlayer,
                joePlayer,
                joePlayer,
                joePlayer,
                joePlayer,
                joePlayer,
                joePlayer);
        TwentyOneGame game = new TwentyOneGame(players);
    }

    @Test(expected = GameCantStartException.class)
    public void samePlayerName() {
        List<Player> players = Arrays.asList(joePlayer,
                joePlayer,
                joePlayer);
        TwentyOneGame game = new TwentyOneGame(players);
    }

    @Test
    public void playersCardsRemovedFromDeck() {
        TwentyOneGame game = new TwentyOneGame(players);
        int expectedValue = 32 - players.size() * 2;
        assertEquals(expectedValue, game.deck.size());
    }

    @Test
    public void handHasJustTwoAces() {
        List<Card> cards = Arrays.asList(new Card(Rank.ACE), new Card(Rank.ACE));
        TwentyOneGame game = new TwentyOneGame(players);
        boolean acceptedTwoAces = game.isTwoAces(cards);
        assertTrue(acceptedTwoAces);
    }

    @Test
    public void calculateCardValueTwoAces() {
        TwentyOneGame game = new TwentyOneGame(players);
        players.get(0).cards = Arrays.asList(new Card(Rank.ACE), new Card(Rank.ACE));
        int cardsValue = game.calculatePlayerCardsValue(players.get(0));
        assertEquals(21, cardsValue);
    }

    @Test
    public void calculateCardValue21() {
        TwentyOneGame game = new TwentyOneGame(players);
        players.get(0).cards = Arrays.asList(new Card(Rank.ACE), new Card(Rank.TEN));
        int cardsValue = game.calculatePlayerCardsValue(players.get(0));
        assertEquals(21, cardsValue);
    }

    @Test(expected = TooMuchException.class)
    public void calculateCardValueTooMuch() {
        TwentyOneGame game = new TwentyOneGame(players);
        players.get(0).cards = Arrays.asList(new Card(Rank.ACE), new Card(Rank.KING), new Card(Rank.SEVEN));
        game.calculatePlayerCardsValue(players.get(0));
    }

    @Test(expected = TooMuchException.class)
    public void pickCardValueIsTooMuch() {
        TwentyOneGame game = new TwentyOneGame(players);
        players.get(0).cards = new ArrayList<>();
        players.get(0).cards.add(new Card(Rank.TEN));
        players.get(0).cards.add(new Card(Rank.TEN));
        game.pickCard(players.get(0));
    }

    @Test
    public void searchWinner() {
        TwentyOneGame game = new TwentyOneGame(players);
        players.get(0).cards = new ArrayList<>();
        players.get(0).cards.add(new Card(Rank.ACE));
        players.get(0).cards.add(new Card(Rank.ACE));
        players.get(1).cards = new ArrayList<>();
        players.get(1).cards.add(new Card(Rank.TEN));
        players.get(1).cards.add(new Card(Rank.ACE));
        players.get(2).cards = new ArrayList<>();
        players.get(2).cards.add(new Card(Rank.TEN));
        players.get(2).cards.add(new Card(Rank.SEVEN));

        Player winner = game.searchWinner();
        assertEquals("Joe", winner.name);
    }

    @Test
    public void searchWinnerWhenSameCardValue() {
        TwentyOneGame game = new TwentyOneGame(players);
        players.get(0).cards = new ArrayList<>();
        players.get(0).cards.add(new Card(Rank.TEN));
        players.get(0).cards.add(new Card(Rank.TEN));
        players.get(1).cards = new ArrayList<>();
        players.get(1).cards.add(new Card(Rank.NINE));
        players.get(1).cards.add(new Card(Rank.EIGHT));
        players.get(1).cards.add(new Card(Rank.UPPER));
        players.get(2).cards = new ArrayList<>();
        players.get(2).cards.add(new Card(Rank.TEN));
        players.get(2).cards.add(new Card(Rank.SEVEN));

        Player winner = game.searchWinner();
        assertEquals("Joe", winner.name);
    }
}
