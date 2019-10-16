package com.company;

public enum CardSign {
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    JACK(11),
    QEEN(12),
    KING(13),
    ACE(14);

    private int sorszam = 0;
    CardSign(int i) {
        sorszam = i;
    }

    public int getSorszam() {
        return sorszam;
    }
}
