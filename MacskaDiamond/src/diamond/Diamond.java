/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diamond;

/**
 *
 * @author Macska
 */

        
        


public class Diamond {

    public static String drawNthRowofNdiamond(int pN, int pR) {
         String row="";
         int j=1;
        
         for (int i=1; i <= pN; i++ ) {
             row = row + (i <= pN-pR ? " ":j++);
         }
         for ( int i=j-2; i >= 1; i-- ) {
             row = row+ (i);
         }
         System.out.println(row);
         return row;
    }

    public static String drawDiamond(int numberofRows) {
        String diamond = "";
        int i;
        for ( i=1; i <= numberofRows;i++) {
            diamond+= drawNthRowofNdiamond(numberofRows, i) + "\n";
        }
        for ( i=i-2; i > 0;i--) {
            diamond+= drawNthRowofNdiamond(numberofRows, i) + "\n";
        }
        return diamond;
    }        
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
