import java.util.Scanner;

public class BJ_1520 {
  static Scanner sc = new Scanner(System.in);
  static int[] dr = new int[]{0,0,-1,1};
  static int[] dc = new int[]{-1,1,0,0};

  public static void main(){
    int rowSize = sc.nextInt();
    int colSize = sc.nextInt();
    int[][] grid = new int[rowSize][colSize];
    int[][] memoi = new int[rowSize][colSize];
    for(int r = 0; r < rowSize; r++){
      for(int c = 0; c < colSize; c++){
        grid[r][c] = sc.nextInt();
        memoi[r][c] = -1;
      }
    }
    System.out.println(solve(grid, memoi, 0,0, rowSize, colSize));
  }



  private static int solve(int[][] grid, int[][] memoi, int curR, int curC, int rowSize, int colSize){
    if(curR == rowSize - 1 && curC == colSize - 1){
      return 1;
    }
    // check for out of bounds
    if( !(0 <= curC && curC < colSize) && !(0 <= curR && curR < rowSize)){
      return 0;
    }

    if(memoi[curR][curC] >= 0){
      return memoi[curR][curC];
    }

    // nothing to do for the valid cell.

    int curSum = 0;

    // call recursively for the valid adjacent cells
    for(int i = 0; i < 4; i++){
      int nR = dr[i] + curR;
      int nC = dc[i] + curC;

      if((0 <= nC && nC < colSize) && (0 <= nR && nR < rowSize) &&
              grid[nR][nC] < grid[curR][curC]){
        curSum += solve(grid, memoi,nR, nC, rowSize, colSize);
      }
    }

    memoi[curR][curC] = curSum;
    return curSum;
  }
}
