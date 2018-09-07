import java.util.Arrays;
import java.util.Scanner;

public class BJ_1780 {
  private static Scanner sc = new Scanner(System.in);
  //private static int negOneCount = 0;
  //private static int zeroCount = 0;
  //private static int oneCount = 0;

  /**
   *  Array to store the counts of negZero, 0 , and 1
   *    where, 0th index == negZero count
   *           1st index == zero count
   *           2nd index == one count
   */
  private static int[] countArr = new int[3];

  public static void main(){
    int gridSize = sc.nextInt();

    System.out.println(Arrays.toString(countArr));
    int[][] grid = BJ_Utils2.generateGrid(gridSize ,sc);
    BJ_Utils2.print2DArrayAligned(grid);
    processGrid(grid, 0 , 0, grid.length);

    System.out.println(Arrays.toString(countArr));
  }

  private static void processGrid(int[][] grid, int rowLeftTop, int colLeftTop, int gridSize){
    // grid is uniform
    if(checkUniformity(grid, rowLeftTop, colLeftTop, gridSize)){
      System.out.println("Uniform at ( "+ rowLeftTop + " , " + colLeftTop +" )" +
              " with val = " + grid[rowLeftTop][colLeftTop] + ", size = " + gridSize );
      countArr[(grid[rowLeftTop][colLeftTop] + 1) ] += 1;
    }else{
      int newSize = gridSize / 3;
      System.out.println("gridsize is " + gridSize + ", newSize is  " +  newSize);
      for(int r = 0; r < 3; r ++){
        for(int c = 0; c < 3; c ++){
          processGrid(grid,    rowLeftTop + r * newSize ,
                  colLeftTop+ c * newSize, newSize);
        }
      }
    }
  }

  private static boolean checkUniformity(int[][] grid, int rowLeftTop, int colLeftTop, int size){
    System.out.println("rowLeftTop : " + rowLeftTop + ", colLeftTop : " + colLeftTop);
    int refVal = grid[rowLeftTop][colLeftTop];

    for(int r=0; r < rowLeftTop + size; r++){
      for(int c=0; c < colLeftTop + size; c++){
        if(grid[r][c] != refVal){
          return false;
        }
      }
    }
    return true;
  }
}
