import java.util.Scanner;

  public class BJ_9663 {
  static boolean[][] board;
  static int size;
  public static void main(){
    Scanner sc = new Scanner(System.in);
    size = sc.nextInt();
    board = new boolean[size][size];
    System.out.println(findNQueenSolution(0));
  }

  private static int findNQueenSolution (int curRow){
    if(curRow == size){
      return 1;
    }
    int ans = 0;
    for(int c = 0; c < size; c++){
      board[curRow][c] = true;
      ans += findNQueenSolution(curRow + 1);
      board[curRow][c] = false;
    }
    return ans;
  }

  public boolean check(int curR, int curC){
    for(int c = 0; c < board.length; c++){
      for(int r = 0; r < curR; r++){
        //check up till curR-th row.

        // checking same row is not needed
        // checking same col
        // checking same forward diag
        // checking same backward diag
        // for each previous queen   //same row
        if(board[c][r] == true && ( c == curC || (curC + c ) == (curR + r) || (c + r) == (curC + curR) ) )
          return false;
      }
    }


    //  checking row
    for(int c = 0; c < size; c++){
      if(c != curC && board[curR][c] ) return false;
    }
    // checking col
    for(int r = 0; r < size; r++){
      if(r != curR && board[r][curC]) return false;
    }
    // checing  / diag ( sum of r and c are the same )
    int sum = curC + curR;
    for(int r = 0; r < size; r++){
      int nC = sum - r;
      if(0 <= nC && nC < size){
        if(board[r][nC] == true) return false;
      }
    }
    return true;
  }
}
