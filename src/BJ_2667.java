import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pair{
  int row;
  int col;
  public Pair(int row, int col){
    this.row = row;
    this.col = col;
  }
}

public class BJ_2667 {
  public static final int[] dRow = {0,0,1,-1};
  public static final int[] dCol = {1,-1,0,0};
  static Scanner sc;
  static int len;

  public static void main(){
    sc = new Scanner(System.in);
    len = sc.nextInt();
    int[][] originalGrid = generateGrid(len);
    //print2DArray(grid);
    solveApartmentProblem(originalGrid);
  }

  private static void solveApartmentProblem(int[][] originalGrid) {
    int len = originalGrid.length;
    int groupCount=0;
    int[][] groupsGrid = new int[len][len];
    for(int r=0; r<len; r++){
      for(int c=0; c<len; c++){
        // legit coordinate, but not visited
        // this finds all the separated 'islands' of blocks
        if(originalGrid[r][c] == 1 && groupsGrid[r][c] == 0 ){
          bfsFindAndMarkBlocks(r,c,++groupCount,groupsGrid, originalGrid);
        }
      }
    }

    int[] sortedGroupElementCount = countGroupElements(groupCount , groupsGrid,originalGrid);
    Arrays.sort(sortedGroupElementCount);
    //System.out.println(Arrays.toString(sortedGroupElementCount));
    //print2DArray(groupsGrid);

    System.out.println(groupCount);
    for(int i=0; i<sortedGroupElementCount.length; i++){
      System.out.println(sortedGroupElementCount[i]);
    }
  }

  private static int[] countGroupElements(int groupCount, int[][] groupsGrid, int[][] originalGrid) {
    int[] groupElementsCount = new int[groupCount];
    for(int r=0; r<len; r++){
      for(int c=0; c<len; c++){
        if(groupsGrid[r][c] != 0){
          groupElementsCount[groupsGrid[r][c]-1] += 1;
        }
      }
    }
    return  groupElementsCount;
  }

  private static void bfsFindAndMarkBlocks(int r, int c, int groupCountNumber, int[][] groupsGrid, int[][] originalGrid) {
    Queue<Pair> bfsQueue = new LinkedList<Pair>();
    bfsQueue.offer(new Pair(r,c));
    groupsGrid[r][c] = groupCountNumber;

    while(!bfsQueue.isEmpty()){
      Pair poppedPair = bfsQueue.poll();
      int curRow = poppedPair.row;
      int curCol = poppedPair.col;

      //checking all for adjacent block
      for(int i=0; i<4; i++){
        // checking for edges
        int adjRow = curRow + dRow[i];
        int adjCol = curCol + dCol[i];

        // boundary check for the adj block
        if(0 <= adjRow && adjRow < len && 0 <= adjCol && adjCol < len ){
          if(originalGrid[adjRow][adjCol] == 1 && groupsGrid[adjRow][adjCol] == 0 ){
            // Valid adj block found, add to Queue
            bfsQueue.offer(new Pair(adjRow, adjCol));
            groupsGrid[adjRow][adjCol] = groupCountNumber;
          }
        }
      }
    }
  }

  private static int[][] generateGrid(int lengthOfSide) {
    int[][] grid = new int[lengthOfSide][lengthOfSide];
    sc.nextLine();
    for(int r=0; r<lengthOfSide; r++){
      String curRow = sc.nextLine();
      for(int c=0; c<lengthOfSide; c++){
        int val = curRow.charAt(c) - '0';
        grid[r][c] = val;
      }
    }
    return grid;
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
