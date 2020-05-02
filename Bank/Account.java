import java.util.*;

class Account{
  private int id = 0;
  private double balance = 0;
  private double annyalInterestRate = 0;
  private Date dateCreated;
  private Credit credit;
  public Account(){
    dateCreated = new Date();
  };
  public Account(int ID, double Balance){
    id = ID;
    balance = Balance;
  }
  public int getID(){
    return id;
  }
  public void setID(int ID){
    id = ID;
  }
  public double getBalance(){
    return balance;
  }
  public void setBalance(double Balance){
    balance = Balance;
  }
  public void setAnnualInterestRate(double rate){
	    annyalInterestRate = rate;
	  }
  public double getAnnualInterestRate(){
    return annyalInterestRate;
  }
  public Date getDate(){
    return dateCreated;
  }
  public double getMonthlyInterestRate(){
    return (annyalInterestRate / 100) / 12 ;
  }
  public double getMonthlyInterest(){
    return balance * getMonthlyInterestRate();
  }
  public void withdraw(double amount){
	  if(amount > balance ) System.out.println("Not enough money on the account");
		else 
    balance -= amount;
  }
  public void deposit(double amount){
	if(amount <= 0 ) System.out.println("The deposit should be positive");
	else 
    balance += amount;
  }
public void openCreditMenu() {
Scanner input = new Scanner(System.in);
	int option;
	do {
    System.out.println("1 - Open credit");
    System.out.println("2 - Credit details");
    System.out.println("3 - Montly payments schedual");
    System.out.println("4 - Exit");
    
    option = input.nextInt();
    switch(option){
    case 1:
    	if (credit== null)
    	credit = new Credit();
    	else System.out.println("No active loan");
    	break;
    case 2:
    	if(credit != null) {
    	credit.loanDetails();	
    	} else System.out.println("No active loan");
    	break;
    case 3:
    	if(credit != null) {
        	credit.drawLoanTable();	
        	} else System.out.println("No active loan");
        	break;
    case 4:
    	 System.out.println("Main menu");
    	 break;
    default: 
    	System.out.println("Wrong input");
    	break;
    }
	}while(option != 4);
	input.close();
		}
}