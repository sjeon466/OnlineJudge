import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
class Pair{
  int row;
  int col;
  int islandNum;
  public Pair(int row, int col){
    this.row = row;
    this.col = col;
  }
}
*/

public class BJ_2146 {
  static Scanner sc;
  static int[] dRow = {0,  1,  0, -1};
  static int[] dCol = {1,  0, -1, 0};
  public static void main(){
    sc = new Scanner(System.in);
    int rowSize = sc.nextInt();
    int colSize = rowSize;
    int numMarkedIslands;
    int minDistance;
    int[][] originalGrid = generateGrid(rowSize, colSize);
    //print2DArrayAligned(grid);
    //System.out.println();
    int[][] markedGrid = generateDeepCopy(originalGrid);
    numMarkedIslands = identifyAndMarkIslands(markedGrid);
    minDistance = bfsMinDistance(markedGrid, originalGrid);
    System.out.println(minDistance);
    //System.out.println("Num islands = " + numMarkedIslands + ", min distance = " + minDistance);
    //print2DArrayAligned(grid);
  }

  private static int bfsMinDistance(int[][] markedGrid, int[][] originalGrid) {

    Queue<Pair> bfsQueue = new LinkedList<Pair>();
    int rowSize = originalGrid.length;
    int colSize = originalGrid[0].length;
    boolean[][] visited = new boolean[rowSize][colSize];
    int minDist = Integer.MAX_VALUE;

    //initial setup
    // put all the lands (meaning value is 1 but distance is 0) in the queue
    for(int r=0; r < rowSize; r++){
      for(int c=0; c < colSize; c++){
        if(originalGrid[r][c] == 1){
          visited[r][c] = true;
          bfsQueue.offer(new Pair(r, c));
        }
      }
    }

    while(!bfsQueue.isEmpty()){
      Pair polledPair = bfsQueue.poll();
      int curRow = polledPair.row;
      int curCol = polledPair.col;

      for(int i=0; i < 4; i++){
        int adjRow = curRow + dRow[i];
        int adjCol = curCol + dCol[i];
        //check for valid adjRow & adjCol boundaries
        if(0 <= adjRow  && adjRow < rowSize && 0 <= adjCol && adjCol < colSize){
          if(visited[adjRow][adjCol]) continue;
          if (originalGrid[adjRow][adjCol] == 0){
            originalGrid[adjRow][adjCol] = originalGrid[curRow][curCol] + 1;
            markedGrid[adjRow][adjCol] = markedGrid[curRow][curCol] + 1;
            visited[adjRow][adjCol] = true;
            bfsQueue.offer(new Pair(adjRow, adjCol));
          }
        }
      }
    }

    //find boundary points from marked graph and get dist using original graph.
    for(int r=0; r<rowSize; r++){
      for(int c=0; c<colSize; c++){
        for(int i=0; i<4; i++){
          int adjRow = r + dRow[i];
          int adjCol = c + dCol[i];
          if(0 <= adjRow  && adjRow < rowSize && 0 <= adjCol && adjCol < colSize) {
            if(markedGrid[r][c] != markedGrid[adjRow][adjCol]){
              //boundary
              int dist = originalGrid[r][c] + originalGrid[adjRow][adjCol];
              if(dist < minDist){
                minDist = dist;
              }
            }
          }
        }
      }
    }
    return minDist;
  }

  private static int[][] generateGrid(int rowSize, int colSize) {
    int[][] grid = new int[rowSize][colSize];
    for(int r=0; r< rowSize; r++){
      for(int c=0; c< colSize; c++){
        grid[r][c] = sc.nextInt();
      }
    }
    return grid;
  }













  private static int identifyAndMarkIslands(int[][] grid){

    int rowSize = grid.length;
    int colSize = grid[0].length;
    boolean[][] visited = new boolean[rowSize][colSize];

    int islandCount = 0;
    for(int r=0; r < rowSize; r++){
      for(int c=0; c < colSize; c++){
        // is a land and not visited
        if(grid[r][c] == 1 && visited[r][c] == false){
          dfsMarkIslands(r, c, ++islandCount, grid, visited);
        }
      }
    }
    return islandCount;
  }



/*  private static int calcMinDistance(int numMarkedIslands, int[][] markedGrid, int[][] originalGrid) {
    int minDistance = Integer.MAX_VALUE;

    // calc distance for between all permutations of two islands
    for(int islandA  = 1; islandA <= numMarkedIslands; islandA++){
      int curDist = bfsMinDistance(islandA, markedGrid, originalGrid);
      System.out.println("[island " + islandA + "].minDist = " + curDist);

      if(curDist < minDistance){
        minDistance = curDist;
      }
    }
    return minDistance;
  }*/

  private static void dfsMarkIslands(int visitedRow, int visitedCol, int islandCount, int[][] grid, boolean[][] visited) {
    int rowSize = grid.length;
    int colSize = grid[0].length;

    grid[visitedRow][visitedCol] = islandCount;
    visited[visitedRow][visitedCol] = true;

    // check adjacent spaces
    for(int i=0; i < 4; i++){
      int adjRow = visitedRow + dRow[i];
      int adjCol = visitedCol + dCol[i];
      if(0 <= adjRow && adjRow < rowSize && 0 <= adjCol && adjCol < colSize){
        if(grid[adjRow][adjCol] == 1 && visited[adjRow][adjCol] == false){
          dfsMarkIslands(adjRow, adjCol, islandCount, grid, visited);
        }
      }
    }
  }

  private static void print2DArrayAligned(int[][] grid){
    for(int[] curRow : grid){
      for(int curVal : curRow){
        System.out.printf("%5d", curVal );
      }
      System.out.println();
    }
  }

  private static int[][] generateDeepCopy(int[][] originalGrid) {
    int rowSize = originalGrid.length;
    int colSize = originalGrid[0].length;
    int[][] deepCopy = new int[rowSize][colSize];
    for(int i=0; i<rowSize; i++){
      deepCopy[i] = Arrays.copyOf(originalGrid[i], originalGrid[i].length);
    }
    return deepCopy;
  }

}
