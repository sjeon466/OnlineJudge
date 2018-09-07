import java.util.Scanner;

public class LC_711 {
  static int[] dr = new int[]{ 0,0,-1,1};
  static int[] dc = new int[]{-1,1, 0,0};

  public static void main() {
    LC_711 l = new LC_711();
    int[][] grid = generateGrid();
    System.out.println("Number is islands = " +  l.numDistinctIslands2(grid));
  }

  private static int[][] generateGrid() {
    /*11100
      10001
      01001
      01110*/
    Scanner sc = new Scanner(System.in);

    int size = sc.nextInt();
    //sc.nextLine();
    int[][] grid = new int[size][size];

    for(int r = 0; r < size; r++){
      for(int c = 0; c < size; c++){
        //String curLine = sc.nextLine();
        //System.out.println("curLine:" + curLine);
        grid[r][c] = sc.nextInt();
      }
    }
    return grid;
  }

  private void print2dGrid(int[][] grid){
    System.out.println("Island Marking:");

    for(int[] curRow : grid){
      for(int curVal : curRow){
        //System.out.printf("%5d", curVal);
        System.out.printf("%4d", curVal);
      }
      System.out.println();
    }
    //System.out.println();
  }

  public int numDistinctIslands2(int[][] grid) {
    if(grid == null || grid.length == 0 || grid[0].length == 0 ) return 0;
    int size = grid.length;
    boolean[][] visited = new boolean[size][size];
    int islandMarking = 0;

    for(int r = 0; r < size; r++){
      for(int c = 0; c < size; c++){
        if(grid[r][c] == 0){
          visited[r][c] = true;
          continue;
        }else if(grid[r][c] == 1 && visited[r][c] == false){
          visitIsland(r,c , ++islandMarking, visited , grid);
        }
      }
    }
    print2dGrid(grid);
    return islandMarking;
  }

  private void visitIsland(int r, int c, int islandMarking, boolean[][] visited, int[][] grid) {
    int size = grid.length;
    // check for bounds
    if( !(0 <= r && r < size) || !(0 <= c && c < size) ) return;

    // if already visited ( because same visited island)
    // if water,    return
    if(visited[r][c] || grid[r][c] == 0) return;

    visited[r][c] = true;
    grid[r][c] = islandMarking;
    //try all four directions
    for(int i = 0 ; i < 4; i++){
      int nr = r + dr[i];
      int nc = c + dc[i];

      if( ( (0 <= nr && nr < size) && (0 <= nc && nc < size)) && !(visited[nr][nc] && grid[nr][nc] != 0)){
        visitIsland(nr, nc, islandMarking, visited, grid);
      }
    }
  }
}
