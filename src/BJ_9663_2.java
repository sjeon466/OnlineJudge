import java.util.Scanner;

public class BJ_9663_2 {
  static boolean[][] grid;
  static int size;
  static boolean[] queenCols;
  static boolean[] queenDiag1;
  static boolean[] queenDiag2;

  public static void main(){
    Scanner sc = new Scanner(System.in);
    size = sc.nextInt();
    grid = new boolean[size][size];
    queenCols = new boolean[size];
    queenDiag1 = new boolean[size * 3];
    queenDiag2 = new boolean[size * 3];
    System.out.println(calcNQueen(0));
  }

  private static int calcNQueen(int curRow){
    if(curRow == size) return 1;

    int ans = 0;
    for(int c = 0; c < size; c++){

      if(check(curRow, c)){
        queenCols[c] = true;
        queenDiag1[curRow + c] = true;
        queenDiag2[curRow - c + size] = true;
        grid[curRow][c] = true;
        ans += calcNQueen(curRow + 1);
        queenCols[c] = false;
        queenDiag1[curRow + c] = false;
        queenDiag2[curRow - c + size] = false;
        grid[curRow][c] = false;
      }

    }
    return ans;
  }

  private static boolean check(int curRow, int c) {
    // same col
    // in the diag1
    // in the diag2
    if(queenCols[c] || queenDiag1[curRow + c] || queenDiag2[curRow - c + size]) return false;
    return true;
  }
}
