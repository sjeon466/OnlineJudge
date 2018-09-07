import java.util.Scanner;
import java.util.Set;

public class BJ_2580 {
  static final int gridSize = 9;
  static int[][] grid;
  static boolean[][] containsValCol;
  static boolean[][] containsRowVal;
  static boolean[][] containsiThSmallSquareVal;

  private static int getiThSquare(int r, int c){
    return (r / 3) * 3 + (c / 3);
  }

  public static void main(){
    Scanner sc = new Scanner(System.in);
    grid = new int[gridSize][gridSize];
    containsRowVal = new boolean[gridSize + 1][gridSize + 1];
    containsValCol = new boolean[gridSize + 1][gridSize + 1];
    containsiThSmallSquareVal = new boolean[gridSize + 1][gridSize + 1];

    for(int r = 0; r < gridSize; r++){
      for(int c = 0; c < gridSize; c++){
        int curNum = sc.nextInt();
        if(curNum != 0){
          grid[r][c] = curNum;
          containsRowVal[r][curNum] = true;
          containsValCol[curNum][c] = true;
          containsiThSmallSquareVal[getiThSquare(r,c)][curNum] = true;
        }
      }
    }
    calcSudoku(0);
  }

  private static void calcSudoku(int curRow) {
    // answer grid reached
    if(curRow == gridSize){
      printGrid(grid);
    }

    for(int c = 0; c < gridSize; c++){
      if(grid[curRow][c] == 0){
        // try all the possible numbers
        for(int candidateNum = 1; candidateNum  <= 9; candidateNum++){
          //if(isRowValid(curRow, c, candidateNum) && isColValid(curRow, c, candidateNum) && isSmallSquareValid(curRow, c, candidateNum) ){
          if(!containsValCol[candidateNum][c]
                  && !containsRowVal[curRow][candidateNum] && !containsiThSmallSquareVal[getiThSquare(curRow,c)][candidateNum]){
            grid[curRow][c] = candidateNum;
            calcSudoku(curRow + 1);
            grid[curRow][c] = 0;
          }
        }
      }
    }
  }
/*
  private static boolean isColValid(int curRow, int curCol, int candidateNum) {
*//*    int sum = 45;
    grid[curRow][curCol] = candidateNum;
    for(int r = 0; r < gridSize; r++){
      sum -= grid[r][curCol];
    }
    grid[curRow][curCol] = 0;
    return sum == 0;*//*
  }

  private static boolean isRowValid(int curRow, int curCol, int candidateNumber) {
*//*    int sum = 45;
    grid[curRow][curCol] = candidateNumber;
    for(int curVal : grid[curRow]){
      sum -= curVal;
    }
    grid[curRow][curCol] = 0;
    return sum == 0;*//*
  }

  private static boolean isSmallSquareValid(int curRow, int curCol, int candidateNumber) {
*//*    int rOffset = curRow / 3 * 3;
    int cOffset = curCol / 3 * 3;

    int sum = 45;
    grid[curRow][curCol] = candidateNumber;
    for(int r = 0; r < 3; r++){
      for(int c = 0; c < 3; c++){
        sum -= grid[r+rOffset][c+cOffset];
      }
    }
    grid[curRow][curCol] = 0;
    return sum == 0;*//*
  }*/

  private static void printGrid(int[][] grid) {
    for(int[] curRow : grid){
      for(int curVal : curRow){
        System.out.printf("%5d" , curVal);
      }
      System.out.println();
    }
  }
}
