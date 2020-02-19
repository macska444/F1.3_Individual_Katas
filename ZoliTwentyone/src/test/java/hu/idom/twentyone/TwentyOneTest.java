package hu.idom.twentyone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class TwentyOneTest {

    private Player joePlayer = new Player("Joe");

    private List<Player> players;// = Arrays.asList(new Player("Joe"), new Player("Jane"), new Player("John"));

    private TwentyOneGame game;
    
    @Before
    public void setUp(){
        players = new ArrayList<>();
        players.add(new Player("Joe"));
        players.add(new Player("Jane"));
        players.add(new Player("John"));
        game = new TwentyOneGame(players);
    }
    
    @Test(expected = GameCantStartException.class)
    public void gameWithNullPlayer() {
        game = new TwentyOneGame(null);
    }

    @Test(expected = GameCantStartException.class)
    public void numberOfPlayerNotEnough() {
        game = new TwentyOneGame(Arrays.asList(joePlayer));
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
        game = new TwentyOneGame(players);
    }

    @Test(expected = GameCantStartException.class)
    public void samePlayerName() {
        List<Player> players = Arrays.asList(joePlayer,
                joePlayer,
                joePlayer);
        game = new TwentyOneGame(players);
    }

    @Test
    public void playersCardsRemovedFromDeck() {
        int expectedValue = 32 - players.size() * 2;
        assertEquals(expectedValue, game.deck.size());
    }

    @Test
    public void handHasJustTwoAces() {
        List<Card> cards = Arrays.asList(new Card(Rank.ACE), new Card(Rank.ACE));
        boolean acceptedTwoAces = game.isTwoAces(cards);
        assertTrue(acceptedTwoAces);
    }

    @Test
    public void calculateCardValueTwoAces() {
        setPlayerCards(players.get(0), Rank.ACE, Rank.ACE);
        assertEquals(21, players.get(0).cardValue);
    }

    @Test
    public void calculateCardValue21() {
        players.get(0).cards = Arrays.asList(new Card(Rank.ACE), new Card(Rank.TEN));
        game.calculatePlayerCardsValue(players.get(0));
        assertEquals(21, players.get(0).cardValue);
    }

    @Test(expected = TooMuchException.class)
    public void pickCardValueIsTooMuch() {
        setPlayerCards(players.get(0), Rank.TEN, Rank.TEN);
        game.pickCard(players.get(0));
    }

    @Test
    public void searchWinner() {
        setPlayerCards(players.get(0), Rank.ACE, Rank.ACE);
        setPlayerCards(players.get(1), Rank.TEN, Rank.ACE);
        setPlayerCards(players.get(2), Rank.TEN, Rank.SEVEN);

        Player winner = game.searchWinner();
        assertEquals("Joe", winner.name);
    }

    @Test(expected = NoSuchPlayerException.class)
    public void playerRemovedAndPickCard() {
        setPlayerCards(players.get(0), Rank.ACE, Rank.NINE);
        setPlayerCards(players.get(1), Rank.TEN, Rank.TEN);
        setPlayerCards(players.get(2), Rank.TEN, Rank.NINE);
        Player player0 = players.get(0);
        try{
            game.pickCard(players.get(0));
        }catch (TooMuchException ex) {}
        
        try{
            game.pickCard(player0);
        }catch (TooMuchException ex) {}
    }
    
    @Test(expected = EmptyPlayersException.class)
    public void playerRemovedAndEmptyPlayerList() {
        setPlayerCards(players.get(0), Rank.ACE, Rank.NINE);
        setPlayerCards(players.get(1), Rank.TEN, Rank.TEN);
        setPlayerCards(players.get(2), Rank.TEN, Rank.TEN);
        Iterator<Player> it = players.iterator();
        try{
            game.pickCard(players.get(0));
        }catch (TooMuchException ex) {}
        try{
            game.pickCard(players.get(0));
        }catch (TooMuchException ex) {}
        try{
            game.pickCard(players.get(0));
        }catch (TooMuchException ex) {}
    }
    
    @Test
    public void searchWinnerWhenSameCardValue() {
        setPlayerCards(players.get(0), Rank.TEN, Rank.TEN);
        setPlayerCards(players.get(1), Rank.NINE, Rank.EIGHT, Rank.UPPER);
        setPlayerCards(players.get(2), Rank.TEN, Rank.SEVEN);

        Player winner = game.searchWinner();
        assertEquals("Joe", winner.name);
    }
    
    private void setPlayerCards(Player player, Rank... ranks){
        player.cards = new ArrayList<>();
        for (Rank rank : ranks) {
            player.cards.add(new Card(rank));
        }
        game.calculatePlayerCardsValue(player);
    }
}
