//Suleyman Umalatov 135476182
public class Tax{
  static final int SINGLE_FILER = 0;
  static final int MARRIED_JOUNTLY_OR_QUALIFYING_WINDOW = 1;
  static final int MARRIED_SEPARATELY = 2;
  static final int HEAD_OF_HOUSEHOLD = 3;

  private int filingStatus;
  private int[][] brackets; 
  private double[] rates;
  private double taxableIncome;

  public int getFilingStatus(){
    return filingStatus;
  }
  public void setFilingStatus(int statusCode){
    filingStatus = statusCode;
  }

  public int[][] getBrackets(){
    return brackets;
  }
  public void setBrackets(int[][] range) {
 		brackets = new int[range.length][range[0].length];
 		for (int i = 0; i < range.length; i++) {
 			for (int j = 0; j < range[i].length; j++){
        brackets[i][j] = range[i][j];
       }	
 		}
 	}

  public double[] getRates(){
    return rates;
  }
  public void setRates(double[] rate){
    rates = new double[rate.length];
    for (int i = 0; i < rates.length; i++){
			rates[i] = rate[i];
	  }
  };

  public double getTaxableIncome(){
    return taxableIncome;
  }
  public void setTaxableIncome(double taxIncome){
    taxableIncome = taxIncome;
  }
  public double getTax() {
		double tax = 0, incomeTaxed = 0;
		double income = taxableIncome; 
		if (rates.length >= 2) {
			for (int i = rates.length - 2; i >= 0; i--) {
				if (income > brackets[filingStatus][i]) {
 					tax += (incomeTaxed = income - brackets[filingStatus][i]) 
 								* rates[i + 1];
					income -= incomeTaxed;
 				}
			} 
		}
		return tax += brackets[filingStatus][0] * rates[0];
	}


  Tax(){
    filingStatus = 0;
    brackets = null;
    rates = null;
    taxableIncome = 0;
  }
    
  Tax(int status,int[][] range,double[] rate, double taxIncome){
    setFilingStatus(filingStatus);
 		setBrackets(brackets);
 		setRates(rates);
  	setTaxableIncome(taxableIncome);
  }
}