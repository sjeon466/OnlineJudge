import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BJ_1987 {

  static final int[] dr = {-1,1,0,0};
  static final int[] dc = {0,0,1,-1};
  static Set<Character> visitedChars = new HashSet<>();

  public static void main(){
    Scanner sc = new Scanner(System.in);
    int rowSize = sc.nextInt();
    int colSize = sc.nextInt();
    //char[][] grid = new char[rowSize][colSize];
    String[] board = new String[rowSize];
    sc.nextLine();
    for(int r = 0; r < rowSize; r++){
      //System.out.println(sc.nextLine());
      //grid[r] =  sc.nextLine().toCharArray();
      board[r] =sc.nextLine();
      // = curRow;
    }
    boolean[] check = new boolean[26];

    //visitedChars.add(grid[0][0]);
    check[board[0].charAt(0) - 'A'] = true;
    System.out.println(go(board, check, 0 ,0 ));
  }

  private static int go(String[] board, boolean[] check, int curR, int curC) {
    int ans = 0;
    for(int k = 0; k < 4; k++){
      int newR = curR + dr[k];
      int newC = curC + dc[k];
      if((0 <= newR && newR < board.length) || (0 <= newC && newC < board[0].length())){
        if(!check[board[newR].charAt(newR) - 'A']){
          check[board[newR].charAt(newR) - 'A'] = true;
          int next = go(board, check, newR, newC);
          if( ans < next){
            ans = next;
          }
          check[board[newR].charAt(newC) - 'A'] = false;
        }
      }
    }
    return ans + 1;
  }

  /*private static int go2(int curR, int curC, char[][] grid, int rowSize, int colSize) {
    // if out of bounds  or already visited, go back

    //trying
    int totalMaxMoves = 1;
    for(int i = 0 ; i < 4; i++){
      int newR = curR + dr[i];
      int newC = curC + dc[i];

      int curMaxMoves = 1;

      // out of bounds check

      if( !(0 <= newR && newR < rowSize) || !(0 <= newC && newC < colSize)) continue;

      if( !visitedChars.contains(grid[newR][newC])){
        visitedChars.add(grid[newR][newC]);
        curMaxMoves += go(newR, newC, grid, rowSize, colSize);
        visitedChars.remove(grid[newR][newC]);
        totalMaxMoves =  Math.max(totalMaxMoves, curMaxMoves);
      }
    }
    return totalMaxMoves;
  }*/


}
