import java.util.Scanner;

public class BJ_4963 {
  static Scanner sc;
  static int[] dRow = {0,1, 0,-1,1, 1,-1,-1};
  static int[] dCol = {1,0,-1, 0,1,-1,-1, 1};

  public static void main(){
    sc = new Scanner(System.in);

    while(true){
      int colSize = sc.nextInt();
      int rowSize = sc.nextInt();
      if(rowSize == 0 && colSize == 0){
        break;
      }
      System.out.println(solveIslandProblem(rowSize,colSize));
      //solveIslandProblem(rowSize,colSize);
    }
  }

  private static int solveIslandProblem(int rowSize, int colSize) {
    int[][] originalGrid = generateOriginalGrid(rowSize, colSize);
    int[][] groupMarkedGrid = new int[rowSize][colSize];

    // marking the groupMakredGrid with island numbers
    int markingNumber = 0;
    for(int r=0; r<rowSize; r++){
      for(int c=0; c<colSize; c++){
        // do DFS if  the spot is land and not visited
        if(originalGrid[r][c] == 1 && groupMarkedGrid[r][c] == 0){
          dfsMarkGrid(r, c, ++markingNumber, groupMarkedGrid, originalGrid);
        }
      }
    }

    int numOfIslands = countIslands(rowSize, colSize, groupMarkedGrid);
    //print2DArray(groupMarkedGrid);
    //System.out.println("=============================");
    return numOfIslands;
  }

  private static int countIslands(int rowSize, int colSize, int[][] groupMarkedGrid) {
    int numIslands = 0;
    for(int r=0; r<rowSize; r++){
      for(int c=0; c<colSize; c++){
        if(groupMarkedGrid[r][c] > numIslands){
          numIslands = groupMarkedGrid[r][c];
        }
      }
    }
    return numIslands;
  }

  private static void dfsMarkGrid(int visitedRow, int visitedCol, int markingNumber, int[][] groupMarkedGrid, int[][] originalGrid) {
    groupMarkedGrid[visitedRow][visitedCol] = markingNumber;
    int rowSize = originalGrid.length;
    int colSize = originalGrid[0].length;

    //check adjacent lands
    for(int i=0; i<8; i++){
      int adjRow = visitedRow + dRow[i];
      int adjCol = visitedCol + dCol[i];
      //check validity of the adj row and adj col
      if(0 <= adjRow && adjRow < rowSize && 0 <= adjCol && adjCol < colSize){
        if(originalGrid[adjRow][adjCol] == 1 && groupMarkedGrid[adjRow][adjCol] != markingNumber){
          dfsMarkGrid(adjRow,adjCol, markingNumber, groupMarkedGrid, originalGrid);
        }
      }
    }
  }

  private static int[][] generateOriginalGrid(int rowSize, int colSize) {
    int[][] originalGrid = new int[rowSize][colSize];
    sc.nextLine();
    for(int r=0; r< rowSize;r++){
      String curRow = sc.nextLine();
      curRow = curRow.replaceAll(" ", "");
      for(int c=0; c< colSize; c++){
        originalGrid[r][c] = curRow.charAt(c) - '0';
      }
    }
    return originalGrid;
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
