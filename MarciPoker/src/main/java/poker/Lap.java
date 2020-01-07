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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.szin;
        hash = 59 * hash + this.ertek;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Lap other = (Lap) obj;
        if (this.szin != other.szin) {
            return false;
        }
        if (this.ertek != other.ertek) {
            return false;
        }
        return true;
    }
    
    
    
}
