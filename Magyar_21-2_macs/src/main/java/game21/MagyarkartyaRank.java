package game21;

public enum MagyarkartyaRank {
    ASZ(11), KIRALY(4), FELSO(3), ALSO(2), X(10), IX(9), VIII(8), VII(7);

    public int value;

    MagyarkartyaRank(Integer value) {
        this.value = value;
    }
}