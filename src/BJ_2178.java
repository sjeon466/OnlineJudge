import java.util.*;

/*class Pair{
  int row;
  int col;
  public Pair(int row, int col){
    this.row = row;
    this.col = col;
  }
}*/

public class BJ_2178 {
  static Scanner sc;
  static int[] dRow =    {0,   0,  1, -1};
  static int[] dColumn = {1,  -1 , 0,  0};

  public static void main(){
    sc = new Scanner(System.in);
    int rowSize = sc.nextInt();
    int colSize = sc.nextInt();

    System.out.println(solveMazeProblem(rowSize, colSize));
  }

  private static int solveMazeProblem(int rowSize, int colSize) {
    int[][] originalGrid = new int[rowSize][colSize];
    originalGrid = generateGrid(originalGrid);
    //print2DArray(originalGrid);
    //System.out.println("===================================");
    int shortestPathMath = bfsSearchShortestPath(1, 1, rowSize, colSize, originalGrid);
    //print2DArray(originalGrid);
    return shortestPathMath;
  }

  private static int[][] generateGrid(int[][] originalGrid) {
    int rowSize = originalGrid.length;
    int colSize = originalGrid[0].length;
    sc.nextLine();
    for(int r=0; r<rowSize; r++){
      String curRow = sc.nextLine();
      for(int c=0; c<colSize; c++){
        originalGrid[r][c] = curRow.charAt(c) - '0';
      }
    }
    return originalGrid;
  }

  private static int bfsSearchShortestPath( int visitedRow, int visitedCol, int rowSize, int colSize, int[][] originalGrid) {
    int[][] visitedGrid = new int[rowSize][colSize];
/*    int[][] visitedGrid = new int [rowSize][colSize];
    for(int r=0; r<rowSize; r++){
      for(int c=0; c<colSize; c++){
        visitedGrid[r][c] = originalGrid[r][c];
      }
    }*/

    Queue<Pair> bfsQueue = new LinkedList<Pair>();
    bfsQueue.offer(new Pair(0,0));
    visitedGrid[0][0] = 1;
    while(!bfsQueue.isEmpty()){
      Pair poppedPair = bfsQueue.poll();

      int curRow = poppedPair.row;
      int curCol = poppedPair.col;
      // check adjacent spots
      for(int i=0; i<4; i++){
        int adjRow = curRow + dRow[i];
        int adjCol = curCol + dColumn[i];

        // check adjacent boundaries
        if(0 <= adjRow && adjRow < rowSize && 0 <= adjCol && adjCol < colSize){
          // check if wall && not visited            //if the to-be-Marked distance is LESS than the adjacent spot's distance
          if(originalGrid[adjRow][adjCol] != 0 && visitedGrid[adjRow][adjCol] == 0/*distanceMarking < originalGrid[adjRow][adjCol]*/){
            //overwrite adjacent spot's distance with the new marking distance
            visitedGrid[adjRow][adjCol] = 1;
            originalGrid[adjRow][adjCol] = originalGrid[curRow][curCol] + 1;
            bfsQueue.offer(new Pair(adjRow, adjCol));
          }
        }
      }
    }
    return originalGrid[rowSize-1][colSize-1];
  }


  private static void print2DArray(int[][] grid){
    for(int[] curRow : grid){
      for(int curVal : curRow){
        System.out.print(curVal + "  ");
      }
      System.out.println();
    }
  }
}
