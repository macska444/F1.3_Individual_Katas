package poker;

public class Lap{
    
    public int szin;
    public int ertek;

    public Lap(int szin, int ertek) {
        this.szin = szin;
        this.ertek = ertek;
    }  

    @Override
    public String toString() {
        return "Lap{" + "szin=" + szin + ", ertek=" + ertek + '}';
    }
    
}
