import java.util.Scanner;

class dropDisk{
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    Boolean win = false;
    Boolean yelloUser = true;
    int choice;
    char[][] arr = new char[6][7];
    do{
      drawBoard(arr);
      yelloUser = concoleOutput(yelloUser);
      choice = receiveNum(input, arr,yelloUser);
      arr = drop(arr, choice, yelloUser);
      win = win(arr, yelloUser);
      //win = true;
    }while(!win);
    input.close();
  }

  public static char[][] drop(char[][] arr, int num, Boolean yelloUser){
    for(int i = 5; i >= 0; i--){
      if(arr[i][num] == 0) {
      if(yelloUser)
       arr[i][num] = 'Y';
       else
       arr[i][num] = 'R';
       i = 0;
      }
    }
    return arr;
  }
   public static Boolean concoleOutput(Boolean yelloUser){
     System.out.println("---------------");
     System.out.print("Drow a ");
     if(yelloUser)
       System.out.print("red ");
     else System.out.print("yellow ");
     yelloUser = !yelloUser;
     System.out.print("disk at column (0-6): ");
    return yelloUser;
   }

  public static void drawBoard(char[][] array){
    for (int i = 0; i < 6; i++){
      for(int j = 0; j < 7; j++){
        System.out.print("|");
        if(array[i][j] == 0) System.out.print(" ");
        else System.out.print(array[i][j]);
        if(j==6)System.out.print("|");
      }
      System.out.println();
    }
  }
  public static int receiveNum(Scanner input, char[][] arr, Boolean yelloUser){
      int num;
      do{
        num = input.nextInt();
        if(arr[0][num] != 0){
          System.out.println("Choose other number. This column is full.");
          System.out.print("Drow a ");
           if(yelloUser)
          System.out.print("yellow ");
          else System.out.print("red ");
          System.out.print("disk at column (0-6): ");
        }     
      } while(num > 6 || num < 0 || arr[0][num] != 0);
    return num;
  }

  public static Boolean win(char[][] arr, Boolean yelloUser){
    Boolean won = false;
    char compare;
    if(yelloUser)
      compare = 'Y';
      else  compare = 'R';
    int count = 0;
    for (int r = 5; r >= 0; r--) { 
        for (int c = 0; c <= 6; c++) { 
            if (arr[r][c] == 0)
                continue;
            if (c + 3 <= 6 &&
                compare == arr[r][c] &&
                compare == arr[r][c+1] && 
                compare == arr[r][c+2] &&
                compare == arr[r][c+3])
                won = true;
            if (r - 3 >= 0) {
                if (compare == arr[r][c] &&
                    compare == arr[r-1][c] &&
                    compare == arr[r-2][c] &&
                    compare == arr[r-3][c])
                    won = true;
                if (c + 3 <= 6 &&
                    compare == arr[r][c] && 
                    compare == arr[r-1][c+1] && 
                    compare == arr[r-2][c+2] &&
                    compare == arr[r-3][c+3])
                    won = true;
                if (c - 3 >= 0 &&
                    compare == arr[r][c] && 
                    compare == arr[r-1][c-1] && 
                    compare == arr[r-2][c-2] &&
                    compare == arr[r-3][c-3])
                    won = true;
            }
        }
    }
    if(won){
    drawBoard(arr);
    System.out.println("---------------");
    System.out.print("The ");
    if(yelloUser)
      System.out.print("yellow ");
      else System.out.print("red ");
    System.out.print("player won!");
    }
    return won;
  }
}