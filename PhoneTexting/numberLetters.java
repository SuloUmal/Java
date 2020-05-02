import java.util.Scanner;
import java.lang.StringBuilder;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException; 
import java.io.File;
class numberLetters {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int number, check;
    StringBuilder str = new StringBuilder("*******\n");
    char[][] array = {{'A', 'B','C'}, {'D', 'E','F'},{'G', 'H','I'},{'J', 'K','L'},{'M', 'N','O'},{'P', 'R','S'},{'T', 'U','V'},{'W', 'X','Y'}};
    Boolean flag;
    do{
      flag = true;
      System.out.println("Type the number: ");
      number = input.nextInt();
      for(int i = 10; i < 100000000 && flag; i*=10){
        check = number % i /(i/10);
        if (check == 1 || check == 0){
          flag = false;
          System.out.println("Number should have 1 or 0");
          System.out.println("Lenght of the number should be 7");
        }
      }
    } while(!flag);
    try{
    FileOutputStream fout= new FileOutputStream(new File("out.txt"));
    for(int a = 0; a < 3 ; a++){
      str.setCharAt(0, array[(number%10000000/1000000)-2][a]);
        for(int b = 0; b < 3 ; b++){
        str.setCharAt(1, array[(number%1000000/100000)-2][b]);
          for(int c = 0; c < 3 ; c++){
            str.setCharAt(2, array[(number%100000/10000)-2][c]);
            for(int d = 0; d < 3 ; d++){
            str.setCharAt(3, array[(number%10000/1000)-2][d]);
              for(int e = 0; e < 3 ; e++){
                str.setCharAt(4, array[(number%1000/100)-2][e]);
                for(int f = 0; f < 3 ; f++){
                  str.setCharAt(5, array[(number%100/10)-2][f]);
                  for(int g = 0; g < 3 ; g++){
                    str.setCharAt(6, array[(number%10)-2][g]);
                    byte bytes[]=str.toString().getBytes();
                    fout.write(bytes);
                  }
                } 
              }
            }
          }
        }
    }
    fout.close();
  }catch(Exception err){System.out.println(err);}
  input.close();
  }
}