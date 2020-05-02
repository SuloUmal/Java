public class ReverseThread extends Thread{
  int counter;

  public ReverseThread(int num){
    super(String.valueOf(num));
    counter = num;
  }

  public void run() {  
    counter++;
    if(counter < 52){
        ReverseThread t = new ReverseThread(counter);
        t.start();
      try{
        t.join();
      } catch(Exception ex){ 
        System.out.println("Exception: " + ex); 
      }; 
      System.out.println("Hello from Thread! " + (Thread.currentThread().getName())); 
    }
  };
            
  public static void main(String args[]) {
    ReverseThread t_start = new ReverseThread(1);
    t_start.start();
  }
}