import java.util.*;
public class Task2 {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Map<String, String> hm = new HashMap<String, String>();
		hm.put("AFGHANISTAN","KABUL");
		hm.put("ALBANIA", "TIRANA");
		hm.put("ALGERIA","ALGIERS");
		hm.put("ANDORRA","ANDORRA LA VELLA");
		hm.put("ANGOLA","LUANDA");
		hm.put("ANTIGUA & BARBUDA","SAINT JOHN\'S");
		hm.put("ARGENTINA","BUENOS AIRES");
		hm.put("ARMENIA","YEREVAN");
		hm.put("AUSTRALIA","CANBERRA");
		hm.put("AUSTRIA","VIENNA");
		hm.put("AZERBAIJAN","BAKU");
		hm.put("BAHAMAS, THE","NASSAU");
		hm.put("BAHRAIN","MANAMA");
		hm.put("BANGLADESH","DHAKA");
		hm.put("BARBADOS","BRIDGETOWN");
		hm.put("BELARUS","MINSK");
		hm.put("BELGIUM","BRUSSELS");
		hm.put("BELIZE","BELMOPAN");
		hm.put("BENIN","PORTO-NOVO");
		hm.put("BHUTAN","THIMPHU");
		hm.put("BOLIVIA","SUCRE");
		hm.put("BOSNIA & HERZEGOVINA","SARAJEVO");
		hm.put("BOTSWANA","GABORONE");
		hm.put("BRAZIL","BRASILIA");
		hm.put("BRUNEI","BANDAR SERI BEGAWAN");
		Scanner input = new Scanner(System.in);
		StringBuilder sb;
		System.out.println("List of countries:");
		for (String itr : hm.keySet()) {
	       System.out.print(itr + "\n");
	        }
		String prompt;
	    do {
	    sb = new StringBuilder();
		System.out.print("\nEnter the country from this list (N if you want to exit): ");
		prompt = input.nextLine();
		if((!prompt.equals("N")) && (!prompt.equals("n"))){
			
		try {
		sb.append("The capital for "); 
		sb.append(prompt.toUpperCase().charAt(0));
		sb.append(prompt.toLowerCase().subSequence(1, prompt.length())); 
		sb.append(" is " + hm.get(prompt.toUpperCase()).charAt(0));
		sb.append(hm.get(prompt.toUpperCase()).toLowerCase().subSequence(1, hm.get(prompt.toUpperCase()).length()) + "\n");
		System.out.print(sb);
		 }catch(Exception e) {System.out.print("Country not found. Try again.\n");};
		}}while(!prompt.equals("N") && !prompt.equals("n"));
	    System.out.println("Bye");
	}
}
