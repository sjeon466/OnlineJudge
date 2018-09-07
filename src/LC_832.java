import java.util.Scanner;

public class LC_832{

  public static void main(){

    LC_832 l = new LC_832();
    Scanner sc = new Scanner(System.in);
    int rowSize = sc.nextInt(), colSize= sc.nextInt();

    int[][] grid = new int[rowSize][colSize];

    for(int r = 0; r < rowSize; r++){
      for(int c = 0 ; c < colSize; c++){
        grid[r][c] = sc.nextInt();
      }
    }
    l.print2DGrid(l.flipAndInvertImage(grid));
  }

  public int[][] flipAndInvertImage(int[][] grid) {
    if(grid == null || grid[0] == null) return null;
    boolean isOddCol = (grid.length % 2 == 1);

    for(int[] curRow : grid){
      for(int r = 0; r < curRow.length / 2; r++){
        //check either side
        if( (curRow[r] ^ curRow[ curRow.length - r]) == 0){
          //change both
          curRow[r] ^= 1; curRow[ curRow.length - r] ^= 1;
        }
      }
      if(isOddCol){
         curRow[ curRow.length / 2] ^= 1;
      }
    }
    return grid;
  }

  public void print2DGrid(int[][] grid){
    for(int[] curRow : grid){
      for(int curVal : curRow){
        System.out.printf("%4f", curVal);
      }
      System.out.println();
    }
  }
}
