//Suleyman Umalatov 135476182

import java.util.Scanner;
public class Task1{
	public static void main(String[] args) {
	    Scanner input = new Scanner(System.in);
	    
	    System.out.print("Enter the number of rows and columns in the array: ");
	    int row = input.nextInt();
	    int column = input.nextInt();
	    /** declaring 2d array */
	    double [][]arr = new double[row][column];
	    
	    /** filling in array with user's input */
	    System.out.println("\nEnter the array: ");
	    for(int i=0; i<row;i++){            
           for(int j=0; j<column;j++){
        	   arr[i][j] = input.nextDouble();
           }
        }
		
		/** creating object location and passing array to the method maxLocate */
		Location location = new Location();
		location = Location.maxLocate(arr);
		System.out.print("The largest value is " + location.displMaxvalue() + "\n");
		System.out.print("The location of the largest value is " + "["+location.displRow()+"]"+ "[" + location.displColumn()+"]");
	    input.close();
	}
}
