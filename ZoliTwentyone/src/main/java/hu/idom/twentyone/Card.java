package hu.idom.twentyone;

public class Card {

    public Rank rank;

    public Card(Rank rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "" + rank.getValue();
    }

}
