import java.util.*;

/*class Pair{
  int row;
  int col;
  public Pair(int row, int col){
    this.row = row;
    this.col = col;
  }
}*/

public class BJ_7576 {
  static Scanner sc;
  static int[] dCol = {0,  0, 1, -1};
  static int[] dRow = {1, -1, 0,  0};

  public static void main(){
    sc = new Scanner(System.in);
    int colSize = sc.nextInt();
    int rowSize = sc.nextInt();
    System.out.println(solveTomatoProblem(colSize,rowSize));
  }

  private static int solveTomatoProblem(int colSize, int rowSize) {
    int[][] originalGrid = generateGrid(colSize, rowSize);
    print2DArrayAligned(originalGrid);

    int earliestDay = bfsTomato(colSize,rowSize,originalGrid);
    System.out.println("========================");
    print2DArrayAligned(originalGrid);
    return earliestDay;
  }

  private static int bfsTomato(int colSize, int rowSize, int[][] originalGrid) {
    boolean[][] visitedGrid = new boolean[rowSize][colSize];
    Queue<Pair> bfsQueue = new LinkedList<Pair>();
    //find the initial rotton tomatos and add them to queue;
    for (int r = 0; r < rowSize; r++) {
      for (int c = 0; c < colSize; c++) {
        if (originalGrid[r][c] == 1) {
          bfsQueue.offer(new Pair(r, c));
          visitedGrid[r][c] = true;
        }
      }
    }

        while(!bfsQueue.isEmpty()){
      Pair polledPair = bfsQueue.poll();
      int curRow = polledPair.row;
      int curCol = polledPair.col;
      visitedGrid[curRow][curCol] = true;

      //check adjacent tomatos
      for(int i=0; i<4; i++){
        int adjRow = curRow + dRow[i];
        int adjCol = curCol + dCol[i];

        //check for valid adjRow & andCol boundaries
        if(0 <= adjRow && adjRow < rowSize && 0 <= adjCol && adjCol < colSize){
          //check if the adj spot is Not Wall and Not visited
          if(originalGrid[adjRow][adjCol] != -1 && visitedGrid[adjRow][adjCol] == false){
            // make it rotton!
            originalGrid[adjRow][adjCol] = originalGrid[curRow][curCol] + 1;
            visitedGrid[adjRow][adjCol] = true;
            bfsQueue.offer(new Pair(adjRow, adjCol));
          }
        }
      }
    }
    return findLargestDay(originalGrid);
  }

  private static int findLargestDay(int[][] originalGrid) {
    if(originalGrid == null || originalGrid.length == 0 || originalGrid[0].length == 0){
      return -1;
    }

    int rowSize = originalGrid.length;
    int colSize = originalGrid[0].length;
    int maxVal = originalGrid[0][0];

    for(int r=0; r<rowSize; r++){
      for(int c=0; c<colSize; c++){
        if(originalGrid[r][c] > maxVal) maxVal = originalGrid[r][c];
        if(originalGrid[r][c] == 0) return -1;
      }
    }
    return maxVal - 1;
  }

  private static int[][] generateGrid(int colSize, int rowSize) {
    int[][] grid = new int[rowSize][colSize];
    for(int r=0; r<rowSize; r++){
      for(int c=0; c<colSize; c++){
        grid[r][c] = sc.nextInt();
      }
    }
    return grid;
  }

  private static void print2DArrayAligned(int[][] grid){
    for(int[] curRow : grid){
      for(int curVal : curRow){
        System.out.printf("%5d", curVal);
      }
      System.out.println();
    }
  }
}
