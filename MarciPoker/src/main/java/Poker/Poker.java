package Poker;

import java.util.ArrayList;
import java.util.Comparator;

public class Poker {
    private static Poker poker = new Poker();
    public static void main(String[] args){
        ArrayList<Lap> kez = new ArrayList<Lap>();
        for (int i = 0; i < 5; i++) {
            kez.add(new Lap((int)(Math.random() * 4), (int) (Math.random() * 13)));
        }
        kez.sort(new Comparatorok());
        for (Lap lap : kez) {
            System.out.println(lap.szin + ":" + lap.ertek);
        }
        System.out.println(poker.kiertekel(kez));    
    }
    public String kiertekel(ArrayList<Lap> kez){
        if (egySzinVizsgalat(kez)) {
            if (sorVizsgalat(kez)) {
                if (kez.get(4).ertek==0) {
                    System.out.println("Rojálflös");
                    return "Rojálflös";
                }
                System.out.println("Színsor "+ kez.get(0).ertek);
                return "Színsor "+ kez.get(0).ertek;
            }
            System.out.println("Flös");
            return "Flös";
        }else{
            if (pokerVizsgalat(kez)) {
                System.out.println("Poker");
                return "Poker";
            }
            if (fullVizsgalat(kez)) {
                System.out.println("Full");
                return "Full";
            }
            if (sorVizsgalat(kez)) {
                System.out.println("Sor");
                return "Sor";
            }
            if (drillVizsgalat(kez)) {
                System.out.println("Drill");
                return "Drill";
            }
            int[] vanPar = parVizsgalat(kez);
            if (vanPar[0] != -1 && vanPar[1] != -1) {
                System.out.println("Két pár");
                return "Két pár " + vanPar[0];
            }
            if (vanPar[0] != -1) {
                System.out.println("Egy pár");
                return "Egy pár " + vanPar[0];
            }
        }
        return "Legmagasabb lap "+ kez.get(0).ertek;
    }
    public boolean egySzinVizsgalat(ArrayList<Lap> kez) {
        for (Lap lap : kez) {
            if (kez.get(0).szin != lap.szin) {
                return false;
            }
        }
        return true;
    }
    public boolean sorVizsgalat(ArrayList<Lap> kez) {
        for (int i = 0; i < 4; i++) {
            if (kez.get(i).ertek == kez.get(i+1).ertek+1 || (kez.get(0).ertek ==13 && kez.get(4).ertek==0)) {
                if (i==3) return true;
            }else{
                return false;
            }
        }
        return false;
    }
    public boolean pokerVizsgalat(ArrayList<Lap> kez) {
        for (int i = 0; i <= 2; i++) {
            if (kez.get(i).ertek == kez.get(i+1).ertek) {
                if (i==2) return true;
            }else{
                for (int j = 1; j <= 3; j++) {
                    if (kez.get(j).ertek == kez.get(j+1).ertek) {
                        if (j==3) return true;
                    }else break;
                }
                break;
            }
        }
        return false;
    }
    public int[] parVizsgalat(ArrayList<Lap> kez) {
        int[] parDb = new int[2];
        parDb[0] = -1;
        parDb[1] = -1;
        for (int i = 0; i < 4; i++) {
            if (kez.get(i).ertek == kez.get(i + 1).ertek) {
                if (parDb[0] == -1) {
                    parDb[0] = kez.get(i).ertek;
                } else if (parDb[1] == -1) {
                    parDb[1] = kez.get(i).ertek;
                }
                i++;
            }
        }
        return parDb;        
    }
    public boolean fullVizsgalat(ArrayList<Lap> kez) {
        for (int i = 0; i < 3; i++) {
            if (kez.get(i).ertek == kez.get(i+1).ertek && kez.get(i).ertek == kez.get(i+2).ertek) {
                switch (i){
                    case 0: if(kez.get(3).ertek == kez.get(4).ertek) return true;
                    case 1: if(kez.get(0).ertek == kez.get(4).ertek) return true;
                    case 2: if(kez.get(0).ertek == kez.get(1).ertek) return true;
                }
            }
        }
        return false;
    }    
    public boolean drillVizsgalat(ArrayList<Lap> kez) {
        for (int i = 0; i < 3; i++) {
            if (kez.get(i).ertek == kez.get(i+1).ertek && kez.get(i).ertek == kez.get(i+2).ertek) {
                return true;
            }
        }
        return false;        
    }
}
