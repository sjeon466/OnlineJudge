import java.util.Scanner;

public class LC_695 {
  public static void main(){
    Scanner sc = new Scanner(System.in);

    int[][] grid = generateGrid();
    LC_695 l = new LC_695();
    System.out.println(l.maxAreaOfIsland(grid));
  }

  private static int[][] generateGrid() {
    int[][] grid = new int[][]{
            new int[]{0,0,1,0,0,0,0,1,0,0,0,0,0},
            new int[]{0,0,0,0,0,0,0,1,1,1,0,0,0},
            new int[]{0,1,1,0,1,0,0,0,0,0,0,0,0},
            new int[]{0,1,0,0,1,1,0,0,1,0,1,0,0},
            new int[]{0,1,0,0,1,1,0,0,1,1,1,0,0},
            new int[]{0,0,0,0,0,0,0,0,0,0,1,0,0},
            new int[]{0,0,0,0,0,0,0,1,1,1,0,0,0},
            new int[]{0,0,0,0,0,0,0,1,1,0,0,0,0},
    };
    return grid;
  }

  public int maxAreaOfIsland(int[][] grid) {
    if(grid == null) return 0;
    int rowSize = grid.length;
    int colSize = rowSize == 0 ? 0 : grid[0].length;

    int maxArea = 0;
    for(int r=0; r < rowSize; r++){
      for(int c=0; c < colSize; c++){
        if(grid[r][c] == 1)
        maxArea = Math.max(maxArea, dfs_countLandArea(grid, r, c));
      }
    }
    return maxArea;
  }

  private int dfs_countLandArea(int[][] grid, int r, int c) {
    int rowSize = grid.length, colSize = grid[0].length;
    if(r < 0 || r >= rowSize || c < 0 || c >= colSize || grid[r][c] == 0) return 0;
    grid[r][c] = 0;
    return 1 + dfs_countLandArea(grid, r + 1, c) +
            dfs_countLandArea(grid, r , c + 1) +
                    dfs_countLandArea(grid, r - 1, c) +
                      dfs_countLandArea(grid, r, c - 1);
  }

}
