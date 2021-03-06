package hu.idom.twentyone;

import java.util.ArrayList;
import java.util.List;

public class TwentyOneGame {

    private final List<Player> players;
    public List<Card> deck;

    private static final int WINNING_POINT = 21;
    private static final int MINIMUM_NUMBER_OF_PLAYERS = 2;
    private static final int MAXIMUM_NUMBER_OF_PLAYERS = 6;

    public TwentyOneGame(List<Player> players) {
        validatePlayers(players);
        this.players = players;
        initGame(players);
    }

    private void validatePlayers(List<Player> players) throws GameCantStartException {
        if (players == null) {
            throw new GameCantStartException();
        }
        validateNumberOfPlayers(players);
        validatePlayerName(players);
    }

    private void validateNumberOfPlayers(List<Player> players) throws GameCantStartException {
        if (players.size() < MINIMUM_NUMBER_OF_PLAYERS || players.size() > MAXIMUM_NUMBER_OF_PLAYERS) {
            throw new GameCantStartException();
        }
    }

    private void validatePlayerName(List<Player> players) throws GameCantStartException {
        boolean hasSameName = false;
        for (int i = 0; i < players.size(); i++) {
            for (int j = 0; j < players.size(); j++) {
                if (j != i && players.get(i).name.equals(players.get(j).name)) {
                    hasSameName = true;
                }
            }
        }
        if (hasSameName) {
            throw new GameCantStartException();
        }
    }

    private void initGame(List<Player> players) {
        createDeck();
        for (Player player : players) {
            pickCard(player);
            pickCard(player);
        }
    }

    private void createDeck() {
        deck = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            for (Rank rank : Rank.values()) {
                deck.add(new Card(rank));
            }
        }
    }

    public void pickCard(Player player) {
        validateExistingPlayer(player);
        Card card = pickCardFromDeck();
        addCardToPlayerAndCalculate(player, card);
    }

    private void validateExistingPlayer(Player player) throws NoSuchPlayerException {
        boolean existingPlayer = false;
        for (Player playerInList : players) {
            if (playerInList.name.equals(player.name)){
                existingPlayer = true;
            }
        }
        if (!existingPlayer){
            throw  new NoSuchPlayerException();
        }
    }

    private Card pickCardFromDeck() {
        int random = Double.valueOf(Math.random() * deck.size()).intValue();
        Card card = deck.get(random);
        deck.remove(random);
        return card;
    }

    private void addCardToPlayerAndCalculate(Player player, Card card) {
        player.addCard(card);
        calculatePlayerCardsValue(player);
        validateTooMuchCardValue(player);
    }

    private void validateTooMuchCardValue(Player player) {
        if (player.cardValue > WINNING_POINT) {
            players.remove(player);
            if (players.size() < 1){
                throw new EmptyPlayersException();
            }
            throw new TooMuchException();
        }
    }

    protected void calculatePlayerCardsValue(Player player) {
        int sumValue = 0;
        for (Card cardValue : player.cards) {
            sumValue += cardValue.rank.getValue();
        }
        if (sumValue == 22 && isTwoAces(player.cards)) {
            player.isTwoAces = true;
            sumValue = WINNING_POINT;
        }
        player.cardValue = sumValue;
    }

    protected boolean isTwoAces(List<Card> cards) {
        int numberOfAces = 0;
        for (Card card : cards) {
            if (card.rank.getValue() == Rank.ACE.getValue()) {
                numberOfAces++;
            }
        }
        return numberOfAces == 2 && cards.size() == 2;
    }

    public Player searchWinner() {
        Player winnerPlayer = players.get(0);
        for (Player player : players) {
            if (player.cardValue > winnerPlayer.cardValue) {
                winnerPlayer = player;
            } else if (player.cardValue == winnerPlayer.cardValue && !player.name.equals(winnerPlayer.name)) {
                if (player.isTwoAces) {
                    winnerPlayer = player;
                } else if (player.cards.size() < winnerPlayer.cards.size()) {
                    winnerPlayer = player;
                }
            }
        }
        return winnerPlayer;
    }
}
