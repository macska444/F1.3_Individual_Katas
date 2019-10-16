package com.company;

public class Card implements Comparable<Card> {
    private CardSign cardSign;
    private Color color;

    public CardSign getCardSign() {
        return cardSign;
    }

    public void setCardSign(CardSign cardSign) {
        this.cardSign = cardSign;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Card(CardSign cardSign, Color color) {
        this.cardSign = cardSign;
        this.color = color;
    }

    @Override
    public int compareTo(Card o) {
        return new Integer(this.cardSign.getSorszam()).compareTo(o.cardSign.getSorszam());
    }
}
