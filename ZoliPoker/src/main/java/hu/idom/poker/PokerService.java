package hu.idom.poker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author szarvas
 */
public class PokerService {
    
    private List<Card> cardList;

    public PokerService(Card card1, Card card2, Card card3, Card card4, Card card5) {
        cardList = new ArrayList<>();
        cardList.add(card1);
        cardList.add(card2);
        cardList.add(card3);
        cardList.add(card4);
        cardList.add(card5);
        
        sort();
    }
    
    public void sort(){
        Collections.sort(cardList);
    }
    
    public int kiertekelo(){
        double retVal = 0;
        if (getRoyalFlush()){
            retVal = Math.pow(2, 9);
        } else if (getSzinSor()){
            retVal = Math.pow(2, 8);
        } else if (getPoker()){
            retVal = Math.pow(2, 7);
        } else if (getFullHouse()){
            retVal = Math.pow(2, 6);
        } else if (getFlush()){
            retVal = Math.pow(2, 5);
        } else if (getSor()){
            retVal = Math.pow(2, 4);
        } else if (getDrill()){
            retVal = Math.pow(2, 3);
        } else if (getPar() == 2){
            retVal = Math.pow(2, 2);
        } else if (getPar() == 1){
            retVal = 2;
        }
        return (int) Math.round(retVal);
    }
    
    public int getPar(){
        int retVal = 0;
        Card elozoCard = null;
        for (Card card : cardList) {
            if (elozoCard != null && elozoCard.getErtek() == card.getErtek()){
                retVal++;
                elozoCard = null;
            }else{
                elozoCard = card;
            }
        }
        return retVal;
    }
    
    public boolean getDrill(){
        List<Card> list = getAzonosErtek(3);
        if (list.size() == 3){
            print("drill", list);
        }
        return list.size() == 3;
    }
    
    private List<Card> getAzonosErtek(int darab){
        List<Card> list = new ArrayList<>();
        Card elozoCard = null;
        for (Card card : cardList) {
            if (elozoCard != null && elozoCard.getErtek() == card.getErtek()){
                if (list.isEmpty()){
                    list.add(elozoCard);
                }
                list.add(card);
            }else if (list.size() < darab){
                list.clear();
            }
            elozoCard = card;
        }
        return list;
        /*if (list.size() == darab){
            return list;
        }else{
            return new ArrayList<>();
        }*/
    }
    
    public boolean getSor(){
        int darab = 5;
        List<Card> list = getSor(darab);
        if (list.size() >= darab){
            print("sor", list);
        }
        return list.size() >= darab;
    }
    
    public boolean getSzinSor(){
        int darab = 5;
        List<Card> list = getSor(darab);
        boolean szinSor = true;
        if (list.size() >= darab){
            Card.SZIN szin = list.get(0).getSzin();
            for (Card card : list) {
                if (!szin.equals(card.getSzin())){
                    szinSor = false;
                }
            }
        }
        if (szinSor && list.size() >= darab){
            print("szinsor", list);
        }
        return szinSor && list.size() >= darab;
    }
    
    public boolean getFlush(){
        Card.SZIN szin = cardList.get(0).getSzin();
        boolean retVal = true;
        for (Card card : cardList) {
            if (!card.getSzin().equals(szin)){
                retVal = false;
                break;
            }
        }
        return retVal;
    }
    
    public boolean getPoker(){
        List<Card> pokerList = getAzonosErtek(4);
        if (pokerList.size() == 4){
            print("poker", pokerList);
            return true;
        }else{
            return false;
        }
    }
    
    public boolean getFullHouse(){
        if (getPar() == 2 && getDrill()){
            return true;
        }else{
            return false;
        }
    }
    
    public boolean getRoyalFlush(){
        if (getSzinSor() && cardList.get(0).getErtek() == 10){
            print("royalflush", cardList);
            return true;
        }else{
            return false;
        }
    }
    
    private List<Card> getSor(int darab){
        Card elozoCard = cardList.get(0);
        List<Card> sorList = new ArrayList<>();
        for (Card card : cardList) {
            if ((elozoCard.getErtek() + 1) == card.getErtek()){
                if (sorList.isEmpty()){
                    sorList.add(elozoCard);
                }
                sorList.add(card);
            }else if (sorList.size() < darab){
                sorList.clear();
            }else{
                break;
            }
            elozoCard = card;
        }
        return sorList;
    }
    
    private void print(String s, List<Card> cardList){
        //String s = "royalflush: ";
        s += ": ";
        for (Card card : cardList) {
            s += card.toString() + ", ";
        }
        System.out.println(s);
    }
    
    public List<Card> getCardList() {
        return cardList;
    }

    public void setCardList(List<Card> cardList) {
        this.cardList = cardList;
    }
    
    
}
