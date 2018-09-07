import java.util.Scanner;

enum StarStatus{
  STAR,
  BLANK
}

public class BJ_2447 {
  private static Scanner sc = new Scanner(System.in);
  private static char[][] grid;
  public static void main(){
    int size = sc.nextInt();
    grid = new char[size][size];
    solve(0, 0 ,size, StarStatus.STAR);
    printGridAligned(grid);
  }
  private static void solve(int r, int c, int size, StarStatus status) {
    if(status == StarStatus.BLANK){
      for(int i=r; i < r + size; i++){
        for(int j=c; j < c + size; j++){
          grid[i][j] = ' ';
        }
      }
    } else{
      if(size == 1){
        grid[r][c] = '*';
      } else{
        int newSize = size / 3;
        for(int i=0; i < 3; i++){
          for(int j=0; j < 3; j++){
            StarStatus curStat;
            if(i == 1 && j == 1){
              curStat = StarStatus.BLANK;
            }else{
              curStat = StarStatus.STAR;
            }
            solve(r + newSize * i, c + newSize * j, newSize, curStat);
          }
        }
      }
    }
  }

  private static void printGridAligned(char[][] grid){
    for(char[] curRow : grid){
      for(char curVal : curRow){
        System.out.printf("%1c", curVal);
      }
      System.out.println();
    }
  }
}
