import java.util.Scanner;

public final class BJ_Utils2 {
  private static BJ_Utils2 bjUtils2 = null;
  private BJ_Utils2(){
    throw new AssertionError("Suppress default constructor for non-instantiability.");
  }

  public static BJ_Utils2 getinstance(){
    if(bjUtils2 == null){
      bjUtils2 = new BJ_Utils2();
    }
    return bjUtils2;
  }

  public static void print2DArrayAligned(int[][] matrix){
    for(int[] curRow : matrix){
      for(int curVal : curRow){
        System.out.printf("%5d", curVal);
      }
      System.out.println();
    }
  }

  public static int[][] generateGrid(int dimension, Scanner sc) {
    int rowSize, colSize;
    rowSize = colSize = dimension;
    int[][] grid = new int[rowSize][colSize];
    for(int r=0; r < rowSize; r++){
      for(int c=0; c < colSize; c++){
        grid[r][c] = sc.nextInt();
      }
    }
    return grid;
  }
}
