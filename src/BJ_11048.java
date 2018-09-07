import java.util.Scanner;

public class BJ_11048 {
  Scanner sc = new Scanner(System.in);

  public static void main(){
    BJ_11048 l = new BJ_11048();
    int[][] grid = l.generateGrid();
    //System.out.println(l.solveMazeCandy_BottomUp(grid));
    int[][] d = new int[grid.length][grid[0].length];

    System.out.println(l.solveMazeCandy_TopDown(grid, grid.length - 1, grid[0].length - 1, d));
  }

  private int solveMazeCandy_TopDown(int[][] grid, int curR , int curC, int[][] d){
    if(curR == 1 || curC == 1){
      return grid[curR][curC];
    }

    int rowSize = grid.length - 1;
    int colSize = grid[0].length - 1;

    return d[curR][curC] = Math.max( solveMazeCandy_TopDown(grid, curR - 1, curC, d),
            solveMazeCandy_TopDown(grid, curR, curC - 1, d));
  }

  private int solveMazeCandy_BottomUp(int[][] grid) {
    if(grid == null)return 0;

    int rowSize = grid.length - 1;
    int colSize = grid[0].length - 1;

    int[][] d = new int[rowSize + 1][colSize + 1];

    for(int r = 1; r <= rowSize; r++){
      for(int c = 1; c <= colSize; c++){
        d[r][c] = grid[r][c] + Math.max( d[r-1][c], d[r][c-1]);
      }
    }
    return d[rowSize][colSize];
  }

  private int[][] generateGrid(){
    int rowSize = sc.nextInt();
    int colSize = sc.nextInt();

    int[][] grid = new int[rowSize + 1][colSize + 1];

    for(int r = 1; r <= rowSize; r++){
      for(int c = 1; c <= colSize; c++){
        grid[r][c] = sc.nextInt();
      }
    }
    return grid;
  }
}
