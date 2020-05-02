public class Adding extends Thread{  
int a[][], b[][];
int start, end;

public Adding( int [][]a, int[][] b, int start, int end){

this.a = a;
this.b = b;
this.start = start;
this.end = end;
}

public void run() {
	 int[][] sum = new int[a.length -1][a[a.length-1].length-1];
     for(int i = start; i < end - 1; i++){
       for(int j = start; j <end - 1; j++){
        sum[i][j] = a[i][j] + b[i][j];
       }
     }
}

public static void main(String args[]) {
    int num = 2000;   
    int matrix1[][] = new int[num][num];
    int matrix2[][] = new int[num][num];
    //fill array from 1 to 2000
    for(int i = 0; i < 2000; i++){
      for(int j = 0; j < 2000; j++){
        matrix1[i][j] = j;
        matrix2[i][j] = j;
      }
    }
    parallelAddMatrix(matrix1, matrix2);
    sequentialAddMatrix(matrix1, matrix2);
}
     public static void parallelAddMatrix(int[][] a, int[][] b){
    	 long start, end;
    	 
    	
    	 Thread t1 = new Thread(new Adding(a, b, 0, a.length / 4));
    	 Thread t2 = new Thread(new Adding(a, b, a.length / 4, a.length /2));
    	 Thread t3 = new Thread(new Adding(a, b, a.length / 2, a.length * 3/ 4));
    	 Thread t4 = new Thread(new Adding(a, b,a.length * 3/ 4 , a.length ));

    	 try{
    	 start = System.nanoTime();	
    	 t1.start();
    	 t1.join();
    	 t2.start();
    	 t2.join();
    	 t3.start();
    	 t3.join();
    	 t4.start();
    	 t4.join();
    	 end = System.nanoTime();

    	 System.out.println("Parallel: " + (end - start) + " nanoseconds");
    	 }
    	 catch(Exception ex){
    	   System.out.print(ex);
    	 }
    
    }
     public static void sequentialAddMatrix(int[][] a, int[][] b){
    	 long start, end;
    	 start = System.nanoTime();	
    	 int[][] sum = new int[a.length -1][a[a.length-1].length-1];
         for(int i = 0; i < a.length-1; i++){
           for(int j = 0; j < a[a.length-1].length-1; j++){
            sum[i][j] = a[i][j] + b[i][j];
           }
         }
    	 end = System.nanoTime();

    	 System.out.println("Sequential: " + (end - start) + " nanoseconds");
    	 
    }

}