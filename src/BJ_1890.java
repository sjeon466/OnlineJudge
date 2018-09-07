import java.util.Scanner;

public class BJ_1890 {
  static Scanner sc = new Scanner(System.in);
  public static void main(){
    int[][] grid = generateGrid();
    System.out.println(solveJump(grid));
  }

  private static long solveJump(int[][] grid) {
    int size = grid.length;
    long[][] d = new long[size][size];
    d[1][1] = 1;

    for (int r = 1; r < grid.length; r++) {
      for (int c = 1; c < grid[0].length; c++) {
        if (grid[r][c] == 0) continue;
        int curJump = grid[r][c];
        if (checkBoundary(r + curJump, c, grid)) {
          // do two jumps if possible
          d[r + curJump][c] += d[r][c];
        }
        if (checkBoundary(r, c + curJump, grid)) {
          // do two jumps if possible
          d[r][c + curJump] += d[r][c];
        }
      }
    }
    return d[size - 1][size - 1];
  }

  private static boolean checkBoundary(int r, int c, int[][] grid){
    return (0 <= r && r < grid.length && 0 <= c && c < grid[0].length);
  }

  private static int[][] generateGrid(){
    int size = sc.nextInt();
    // int rowSize = sc.nextInt();
    // int colSize = sc.nextInt();
    int[][] grid = new int[size + 1][size + 1];
    for(int r = 1; r <= size; r++){
      for(int c = 1; c <= size; c++){
        grid[r][c] = sc.nextInt();
      }
    }
    return grid;
  }
}