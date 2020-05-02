//Suleyman Umalatov 135476182

import java.lang.Math; 
public class Task2{
	public static void main(String[] args) {
		/** random number in range 1 to 6 */
	    int dice1 = (int) (Math.random() * 6) + 1;
	    int dice2 = (int) (Math.random() * 6) + 1;
	    int sum = dice1+dice2;
	    System.out.print("You rolled "+dice1+" + "+dice2+" = "+sum);
	    
	    /** switch statement
	     *  checks the first roll of dice
	     *  if 2, 3 or 12 gives lose message
	     *  if 7 or 11 gives win message
	     *  in other cases establishes a point */
	    switch (sum) {
	    	case 2:
	    	case 3:
	    	case 12:
	    		System.out.print("\nBetter Luck Next Time, You lose");
	    		break;
	    	case 7:
	    	case 11:
	    		System.out.print("\nCongratulations, You win");
	    		break;
	    	default:
	    		System.out.print("\nPoint is set to " + sum);
	    		do{
	    			dice1 = (int) (Math.random() * 6) + 1;
	    		    dice2 = (int) (Math.random() * 6) + 1;
	    		    System.out.print("\nYou rolled "+dice1+" + "+dice2+" = "+(dice1+dice2));
	    		    if(dice1+dice2 == 7) System.out.print("\nBetter Luck Next Time, You lose");
	    		    if(dice1+dice2 == sum) System.out.print("\nCongratulations, You win");

	    		} while(dice1+dice2 != 7 && dice1+dice2 != sum);
	    		break;
	    }
	}
}