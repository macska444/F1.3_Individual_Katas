package poker;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Macska
 */
public class Poker {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String s;
        Scanner sc = new Scanner(System.in);
        System.out.println("Tovább?");
        while (!"ne".equals(sc.nextLine())) {
            Hand myHand = new Hand();
            while (myHand.cards.size() != 5) {
		Random r = new Random();
                int randomSuit = r.nextInt((4 - 1) + 1) + 1;
                int randomRank = r.nextInt((14 - 2) + 1) + 2;
                myHand.AddCard(suitOrder.getSuitNameByValue(randomSuit),rankOrder.getRankNameByValue(randomRank));
            }
            myHand.eval();
            myHand.print();           
            System.out.println("Tovább?");
            
        }
    }
    
}
