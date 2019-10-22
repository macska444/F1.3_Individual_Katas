package hu.idom.poker;

/**
 *
 * @author szarvas
 */
public class Card implements Comparable{
    
    private SZIN szin;
    
    private int ertek;

    @Override
    public int compareTo(Object o) {
        Card card = (Card) o;
        return new Integer(this.ertek).compareTo(card.ertek);
        //return this.ertek - card.ertek;
    }

    public enum SZIN{
        PIKK,
        KOR,
        KARO,
        TREFF
    }
    
    public Card(SZIN szin, int ertek) {
        this.szin = szin;
        this.ertek = ertek;
    }
    
    public int getErtek() {
        return ertek;
    }

    public void setErtek(int ertek) {
        this.ertek = ertek;
    }

    public SZIN getSzin() {
        return szin;
    }

    public void setSzin(SZIN szin) {
        this.szin = szin;
    }

    @Override
    public String toString() {
        return this.getSzin().toString() + " " + this.getErtek();
    }
    
    
}
