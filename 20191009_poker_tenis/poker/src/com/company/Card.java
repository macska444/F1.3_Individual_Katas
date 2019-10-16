package com.company;

public class Card implements Comparable<Card> {
    private Jel jel;
    private Color color;

    public Jel getJel() {
        return jel;
    }

    public void setJel(Jel jel) {
        this.jel = jel;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Card(Jel jel, Color color) {
        this.jel = jel;
        this.color = color;
    }

    @Override
    public int compareTo(Card o) {
        return new Integer(this.jel.getSorszam()).compareTo(o.jel.getSorszam());
    }
}
