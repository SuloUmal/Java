import java.util.Arrays;
import java.util.Scanner;
//Umalatov Suleyman
class Main {

public static void main(String[] args) {
	//acc stores index of found Account object
	//find is used to search for needed object
	//i to figure out if the first object initialized or not
	int acc = 0, find = 0, i = 0;
	Account currentArray[] = new Account[1];

    Scanner input = new Scanner(System.in);
    int option =0;
    do{
    	//Main menu
      System.out.println("1 - Create account");
      System.out.println("2 - Enter account");
      System.out.println("3 - Exit the program");
      if(input.hasNextInt()) 
      {
      option = input.nextInt();
      }
      switch(option){
      case 1:
    	  
    	  if(i != 0) {
    	  currentArray = increaseArray(currentArray);
    	  }else {
    		  currentArray[0] = new Account();
    		  i++;
    	  }
    	  //Created account's details
    	  System.out.println("\nNew account has been created");
    	  System.out.println(" AccountID: " + currentArray[currentArray.length -1].getID());
    	  System.out.println(" Balance: " + currentArray[currentArray.length -1].getBalance());
    	  System.out.println(" Creation date: " + currentArray[currentArray.length -1].getDate() + "\n");
    	  break;
      case 2:
    	  System.out.println("Enter account ID: ");
    	  
    	  boolean found = false;//if the object found => it turns "true"
    	  find = input.nextInt();
	      System.out.println();
	      //search loop for Account object
    	  for (int j = 0; j < currentArray.length; j++) {
    		  if (currentArray[j].getID() == find) {
    			  found = true; 
    			  acc = j; 			 
    		  } }  
    		  if (found) {
    			  do{
    				  	//Account menu
    	    	        System.out.println("1 - Display account");
    	    	        System.out.println("2 - Deposit");
    	    	        System.out.println("3 - Withdraw");
    	    	        System.out.println("4 - Change ID");
    	    	        System.out.println("5 - Credit menu");
    	    	        System.out.println("6 - Exit from account");
    	    	        
    	    	        System.out.print("Your choice is: ");
    	    	        option = input.nextInt();
    	    	        System.out.println();
    	    	        
    	    	        if(option == 1) {
    	    	        	System.out.println("AccountID: " + currentArray[acc].getID() + " Balance: " + currentArray[acc].getBalance() + " Creation date: " + currentArray[acc].getDate());
    	    	        	System.out.println();
    	    	        }
    	    	        if(option == 2) {
    	    	        	currentArray[acc].deposit(input.nextDouble());
    	    	        }
    	    	        if(option == 3) {
    	    	        	double a = input.nextDouble();
    	    	        	if(a > currentArray[acc].getBalance()) {
    	    	        	System.out.println("Not enough money on the account\n");
    	    	        } else {
    	    	        	currentArray[acc].withdraw(a);
    	    	        }}
    	    	        if(option == 4) {
    	    	        	System.out.print("Type the new ID: ");
    	    	        	currentArray[acc].setID(input.nextInt());
    	    	        }
    	    	        if (option == 5)currentArray[acc].openCreditMenu();
    	    	        if(option == 6) {
    	    	          System.out.println("Main menu");
    	    	        }
    	    	      } while(option != 6);
    		  }	 else {   System.out.println("Account not found");}
    	    		  
    	  break;
      case 4:
        System.out.println("Bye");
        break;
      default: 
      	System.out.println("Wrong input");
      	break;
      }
     
    } while(option != 4);
    input.close();
  }
  public static Account[] increaseArray(Account[] list){  
	  Account tempArray[] = Arrays.copyOf(list, list.length+1);
	  tempArray[tempArray.length - 1 ] = new Account();
	  for (int j = 0 ; j  < tempArray.length - 1 ; j++) {
		  if (tempArray[j].getID() == tempArray[tempArray.length - 1].getID())
			  
			  tempArray[tempArray.length - 1 ].setID(tempArray.length - 1);
	  }

	         return tempArray;
	 }  
 }
