//Suleyman Umalatov 135476182

public class Location {
	/** declaring variables */
	private int row = 0, column = 0;
	private double maxValue = 0;
	
	/** method takes reference to array and returns:
	 *  location of the largest value (indexes) and value*/
	public static Location maxLocate(double[][] arr) {
		Location location = new Location();
		
	/** loops through array to find the largest value */
            for(int i = 0; i < arr.length; i++) {
                for(int j=0; j < arr[i].length; j++) {
                    if(location.maxValue < arr[i][j]) {
                        location.maxValue = arr[i][j];
                        location.row = i;
                        location.column = j;
                    }
                }
            }
            return location;
	}
	
	public double displMaxvalue(){
		return maxValue;
	}
	public int displRow(){
		return row;
	}
	public int displColumn(){
		return column;
	}
}
