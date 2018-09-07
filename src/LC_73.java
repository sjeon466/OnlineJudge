import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Arrays;

public class LC_73 {
  public static void main(){

    LC_73 l = new LC_73();

    int[][] grid = generateGrid();
    //l.printGrid(grid);

    l.setZeroes(grid);

   // l.printGrid(grid);

  }

  private void printGrid(int[][] grid) {
    for(int[] curRow : grid){
      for(int curVal : curRow){
        System.out.printf("%4d", curVal);
      }
      System.out.println();
    }
    System.out.println();
  }

  private static int[][] generateGrid() {
    Scanner sc = new Scanner(System.in);
    int rowSize = sc.nextInt();
    int colSize = sc.nextInt();
    int[][] grid = new int[rowSize][colSize];
    for(int r = 0; r < rowSize; r++){
      for(int c = 0; c < colSize; c++){
        grid[r][c] = sc.nextInt();
      }
    }
    return grid;
  }

  public void setZeroes(int[][] matrix) {
    if(matrix == null || matrix.length == 0) return;

    boolean firstRowZero = false;
    boolean firstColZero = false;

    int rowSize = matrix.length;
    int colSize = matrix[0].length;

    for(int r = 0 ; r < rowSize; r++){
      for(int c = 0; c < colSize; c++){
        if(matrix[r][c] == 0){
          if(r == 0) firstRowZero = true;
          if(c == 0) firstColZero = true;

          // marking zero
          matrix[r][0] = 0;
          matrix[0][c] = 0;
        }
      }
    }


    // refer to the marking to make zeros
    for(int r = 1; r < rowSize; r++){
      for(int c = 1; c < colSize; c++){
        if(matrix[r][0] == 0 || matrix[0][c] == 0){
          matrix[r][c] = 0;
        }
      }
    }

    // take care of reference row and col
    if(firstColZero){
      for(int r = 0; r < rowSize; r++){
        matrix[r][0] = 0;
      }
    }

    if(firstRowZero){
      for(int c = 0; c < colSize; c++){
        matrix[0][c] = 0;
      }

    }





  }

  public void setZeroes2(int[][] matrix) {

    List<Integer> rowList = new ArrayList<>();
    List<Integer> colList = new ArrayList<>();

    for (int r = 0; r < matrix.length; r++) {
      for (int c = 0; c < matrix[0].length; c++) {
        if (matrix[r][c] == 0) {
          addToColTargets(r, rowList);
          addToRowTargets(c, colList);
        }
      }
    }

    for (int i = 0; i < rowList.size(); i++) {
      makeRowZeros(rowList.get(i), matrix);
    }

    for (int i = 0; i < colList.size(); i++) {
      makeColZeros(colList.get(i), matrix);
    }
  }

  private void addToColTargets(int colVal, List<Integer> colList){
    colList.add(colVal);
  }

  private void addToRowTargets(int colVal, List<Integer> rowList){
    rowList.add(colVal);
  }

  private void makeColZeros(int colVal , int[][] grid){
    int rowSize = grid.length;
    for(int r = 0; r < rowSize; r++){
      grid[r][colVal] = 0;
    }
  }

  private void makeRowZeros(int rowVal, int[][] grid){
    int[] targetRow = grid[rowVal];
    Arrays.fill(targetRow , 0 );
  }
}
