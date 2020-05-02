public class Task2 {
	public static final ArrayProcessor max = array -> {
		double maxNum = array[0];
		for(int i=1;i < array.length;i++){
		    if(array[i] > maxNum){
		    	maxNum = array[i];
			}
		  }
		  return maxNum;
		};
	
	public static final ArrayProcessor min = array -> {
		double minNum = array[0];
		for(int i=1;i < array.length;i++){
		    if(array[i] < minNum){
		    	minNum = array[i];
			}
		  }
		  return minNum;
		};
	public static final ArrayProcessor sum = array -> {
		double sumNum =0;
		for(double i: array)
			sumNum += i;
		  return sumNum;
		};	
	public static final ArrayProcessor avg = array -> sum.apply(array) / array.length;	
	
	public static ArrayProcessor counter( double value ) {
        return array -> {
            int count = 0;
            for(double i: array)
            	if(i == value) count++;
            return count;
        };
    }
	
	public static void main(String[] args){
		//lambda expression with return
		double[] arr = {1, 2, 3, 4, 5, 23, 14, 54, 9 , 1};
		
		System.out.println("Max : " + max.apply(arr) );
		System.out.println("Min : " + min.apply(arr) );
		System.out.println("Sum : " + sum.apply(arr) );
		System.out.println("Average : " + avg.apply(arr) );
		System.out.println("Count num 1 : " + counter(1).apply(arr) );
		System.out.println("Count num 2 : " + counter(2).apply(arr) );
		}
		
	
}
