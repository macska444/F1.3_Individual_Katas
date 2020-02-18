package hu.idom.twentyone;

import java.util.ArrayList;
import java.util.List;

public class Player {

    public String name;
    public List<Card> cards;
    public int cardValue;
    public boolean isTwoAces;

    public Player(String name) {
        this.name = name;
        cards = new ArrayList<>();
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    @Override
    public String toString() {
        return name + ": " + cardValue;
    }

    
}
