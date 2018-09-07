import java.util.Scanner;

public class BJ_2873 {
  private static Scanner sc = new Scanner(System.in);
  public static void main(){
    int rowSize = sc.nextInt();
    int colSize = sc.nextInt();
    int[][] grid = generateGrid(rowSize, colSize);

    StringBuilder sbForward = new StringBuilder();
    StringBuilder sbBackward = new StringBuilder();

    // all spots are possible
    if(!(rowSize % 2 == 0 && colSize % 2 == 0)){
      //if rowSize is odd
      if(rowSize % 2 == 1){
        // look ahead to the end of the current row if end spot is reached.
        for(int r=0; r<rowSize; r++){
          for(int c=0; c<colSize; c++){
            //while not reached at the last row
            while(r != rowSize - 1){
              for(int i=0; i < colSize; i++){
                sbForward.append("R");
              }
              sbForward.append("D");
              for(int i=0; i < rowSize; r++){
                sbForward.append("L");
              }
              sbForward.append("D");
            }
            // append the last Rs
            for(int i=0; i < rowSize; r++){
              sbForward.append("R");
            }
          }
        }

      }else{
        //if colSize is odd

      }
    }else{
      // special case, must omit one spot.

      //find smallest spot
      Spot smallestSpot = findSmallestSpot(grid);

    }
  }

  private static Spot findSmallestSpot(int[][] grid){
    int smallestVal = grid[0][0];
    int rowSize = grid.length;
    int colSize = grid[0].length;
    Spot smallestSpot = new Spot(0,0);
    for(int r=0; r< rowSize; r++){
      if(r % 2 == 0) continue;
      for(int c=0; c<colSize; c++){
        if(c % 2 == 0) continue;
        if(grid[r][c] < smallestVal){
          smallestSpot = new Spot(r,c);
        }
      }
    }
    return smallestSpot;
  }

  private static int[][] generateGrid(int rowSize, int colSize) {
    int[][] grid = new int[rowSize][colSize];
    for(int r = 0; r < rowSize; r++){
      for(int c =0 ; c < colSize; c++){
        grid[r][c] = sc.nextInt();
      }
    }
    return grid;
  }

  private static void printGridAligned(int[][] grid){
    for(int[] curRow : grid){
      for(int curVal : curRow){
        System.out.printf("%5d", curVal);
      }
      System.out.println();
    }
  }
}

class Spot{
  private int row;
  private int col;

  public Spot(int row, int col){
    this.row = row;
    this.col = col;
  }
  public int getRow(){
    return row;
  }
  public int getCol(){
    return col;
  }
}
