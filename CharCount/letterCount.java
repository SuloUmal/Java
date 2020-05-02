import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException; 
import java.io.File;
class letterCount{
  public static void main(String[] args) throws IOException{
    Scanner type = new Scanner(System.in);
    String str;
    System.out.print("Enter file name: ");
    str = type.nextLine();
    File file = new File(str);
    int[] countUpper = new int[26];
    int[] countLower = new int[26];
     try(FileInputStream input = new FileInputStream(file)) {

        int data = input.read();
        while(data != -1){
            if(data >= 65 && data <= 90) countUpper[(int)data - 'A']++;
            
            if(data >= 97 && data <= 122) countLower[(int)data - 'a']++;
            data = input.read();
        }
    }
  for(int i=0; i<26; i++){
    System.out.println("Number of "+ (char)(65+i) +"'s: " + countUpper[i]);
    System.out.println("Number of "+ (char)(97+i)+"'s: "  + countLower[i]);
  }
  type.close();
  }
}