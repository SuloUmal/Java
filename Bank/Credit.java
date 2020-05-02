import java.util.Formatter;
import java.util.Date;
import java.util.Scanner;
@SuppressWarnings("unused")
public class Credit extends Account{
private double creditAmount=0;
private Date creditIssueDate;
private int creditLength = 0;
public void takeLoan() {
	Scanner input = new Scanner(System.in);
	
    System.out.println("1 - 4.95% for 5 years");
    System.out.println("2 - 3.95% for 4 years");
    System.out.println("3 - 2.95% for 2 years");
    System.out.println("4 - 1.95% for 1 years");
    System.out.println("5 - 0.95% for 6 months and below");
    int option = input.nextInt();
    
    switch(option){
    	case 1:
    		setAnnualInterestRate(4.95);
    		setCreditLength(5*12);
    		break;
    	case 2:
    		setAnnualInterestRate(3.95);
    		setCreditLength(4*12);
    		break;
    	case 3:
    		setAnnualInterestRate(2.95);
    		setCreditLength(2*12);
    		break;
    	case 4:
    		setAnnualInterestRate(1.95);
    		setCreditLength(1*12);
    		break;
    	case 5:
    		setAnnualInterestRate(0.95);
    		System.out.print("For how many months you would like to take credit? ");
    		setCreditLength(input.nextInt());
    		break;
    	default:
    		System.out.print("Wrong input");
    		break;
    }
    System.out.print("Enter loan amount: ");
    setCreditAmount(input.nextDouble());
   
}
public double getCreditAmount(){
    return creditAmount;
  }
public void setCreditAmount(double loanAmount){
	  creditAmount = loanAmount;
}
public void setCreditLength(int forMonths) {
	creditLength = forMonths;
}
public int getCreditLength(){
    return creditLength;
  }
public Credit(){
	creditIssueDate = new Date();
	takeLoan();
  }
public double getMonthlyInterest(){
    return creditAmount * getMonthlyInterestRate();
  }  
public void loanDetails() {
	System.out.print("Loan amount: " + getCreditAmount() + "\n");
	System.out.print("Months to pay: " + getCreditLength() + "\n");
	System.out.printf("Monthly payment:  %.2f  \n",getMonthlyInterest()+ creditAmount/getCreditLength() );
	System.out.print("Annual rate: "+  getAnnualInterestRate() + "\n\n");
}
public void drawLoanTable() {
	 
      
     System.out.println(
			" -----------------------------------------------------------\n" +
			"|                                                           |\n" +
			"|    Month               Paid                 Due           |\n" +
			"|                                                           |\n" +
			" -----------------------------------------------------------");
     for(int i = 0; i <= getCreditLength(); i++) {
     System.out.printf("      %d                    %.3f                    %.3f\n", i , (getMonthlyInterest()+ creditAmount/getCreditLength())*i , ((getMonthlyInterest()+ creditAmount/getCreditLength())*getCreditLength()) - (getMonthlyInterest()+ creditAmount/getCreditLength())*i);}
};
}
