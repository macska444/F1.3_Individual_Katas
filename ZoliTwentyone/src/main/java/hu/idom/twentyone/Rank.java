package hu.idom.twentyone;

public enum Rank {
    UNDER(2),
    UPPER(3),
    KING(4),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    ACE(11);

    private int value;

    private Rank(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
