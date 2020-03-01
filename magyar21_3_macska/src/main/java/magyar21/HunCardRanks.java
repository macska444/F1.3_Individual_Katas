package magyar21;

public enum HunCardRanks {
    ASZ(11), KIRALY(4), FELSO(3), ALSO(2), X(10), IX(9), VIII(8), VII(7);


    private Integer value;

    HunCardRanks(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public static boolean hasCard(Integer value) {
        for (HunCardRanks hunCardRank : HunCardRanks.values()) {
            if (value == hunCardRank.value)
                return true;
        }
        return false;
    }
}
