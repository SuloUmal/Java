import java.util.Scanner;
//Suleyman Umalatov 135476182
class Main {
  public static void main(String[] args) {
    Tax y01 = new Tax();
    Tax y09 = new Tax();
    Scanner input = new Scanner(System.in);
     int [][]arr = {
      {27050, 65550, 136750, 297350},
      {45200, 109250, 166500, 297350},
      {22600, 54625, 83250, 148675},
      {36250, 93650, 151650, 297350}
    };
    int [][]arr2 = {
      {8350, 33950, 82250, 171550, 372950},
      {16700, 67900, 137050, 208850, 372250},
      {8350, 33950, 68525, 104425, 186475},
      {11950, 45500, 117450, 190200, 372950}
    };
    double[] rate1 = {0.15, 0.275, 0.305, 0.355, 0.391};
    double[] rate2 = {0.10, 0.15, 0.25, 0.28, 0.33, 0.35};
    y01.setRates(rate1);
    y09.setRates(rate2);
    y01.setBrackets(arr);
    y09.setBrackets(arr2);
    //menu
    int option;
    do{
    System.out.println("1 - Compute personal income Tax");
    System.out.println("2 - Print the tax tables for taxable incomes (with range)");
    System.out.println("3 - Exit");
    System.out.print("Your choice is: ");
    option = input.nextInt();
    switch(option) {
  case 1:
    System.out.println("\n0 - single filer");
    System.out.println("1 - married jointly or qualifying widow(er)");
    System.out.println("2 - married separately");
    System.out.println("3 - head of household");

    System.out.print("Enter the filing status: ");
    y09.setFilingStatus(input.nextInt());

    System.out.print("Enter the Taxable Income: $");
    y09.setTaxableIncome(input.nextInt()); 

    System.out.println("Tax is: $" + String.format("%.2f\n", y09.getTax()));
    break;
  case 2:
    System.out.print("Enter the amount From: $");
    double start = input.nextDouble();
    System.out.print("Enter the amount To: $");
    double end = input.nextDouble();
    
    System.out.println("2001 tax tables income from $" + start + " to $"+end+"\n"+
			"---------------------------------------------------------------------\n" +
			"Taxable       Single      Married Joint       Married        Head of\n" +
			"Income                    or Qualifying       Separate       a House\n" +
			"                          Widow(er)\n" +
			"---------------------------------------------------------------------");
      
      for(double i = start; i <= end; i += 1000){
      y01.setTaxableIncome(i);
			System.out.printf("%-13.0f", i);
			y01.setFilingStatus(Tax.SINGLE_FILER);
			System.out.printf("%8.2f", y01.getTax());
			y01.setFilingStatus(Tax.MARRIED_JOUNTLY_OR_QUALIFYING_WINDOW);
			System.out.printf("%15.2f", y01.getTax());
			y01.setFilingStatus(Tax.MARRIED_SEPARATELY);
			System.out.printf("%18.2f", y01.getTax());
			y01.setFilingStatus(Tax.HEAD_OF_HOUSEHOLD);
			System.out.printf("%15.2f\n", y01.getTax());
      }

      System.out.println("\n2009 tax tables income from $" + start + " to $"+end+"\n"+
      "---------------------------------------------------------------------\n" +
			"Taxable       Single      Married Joint       Married        Head of\n" +
			"Income                    or Qualifying       Separate       a House\n" +
			"                          Widow(er)\n" +
			"---------------------------------------------------------------------");
      for(double i = start; i <= end; i += 1000){
      y09.setTaxableIncome(i);
			System.out.printf("%-13.0f", i);
			y09.setFilingStatus(Tax.SINGLE_FILER);
			System.out.printf("%8.2f", y09.getTax());
			y09.setFilingStatus(Tax.MARRIED_JOUNTLY_OR_QUALIFYING_WINDOW);
			System.out.printf("%15.2f", y09.getTax());
			y09.setFilingStatus(Tax.MARRIED_SEPARATELY);
			System.out.printf("%18.2f", y09.getTax());
			y09.setFilingStatus(Tax.HEAD_OF_HOUSEHOLD);
			System.out.printf("%15.2f\n", y09.getTax());
      }
      System.out.println();
    break;
  case 3:
    System.out.println("Bye");
    break;
}}while (option != 3);
  }

}