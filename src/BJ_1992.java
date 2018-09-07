import java.util.Scanner;

public class BJ_1992 {
  private static Scanner sc = new Scanner(System.in);
  private static int[][] grid;
  public static void main(){
    int size = sc.nextInt();
    grid = generateGrid(size);
    printGridAligned(grid);

    //System.out.print("(");
    solve(0, 0, size);
    //System.out.print(")");
  }

  private static void solve(int r, int c, int size) {
    if(same(r,c,size)){
      //System.out.printf("$d", grid[r][c]);
      System.out.print(grid[r][c]);
    }else{
      System.out.printf("(");
      int newSize = size / 2;
      for(int i=0; i < 2; i++){
        for(int j=0; j < 2; j++){
          solve(r + newSize * i, c + newSize * j, newSize);
        }
      }
      System.out.printf(")");
    }
  }

  private static int[][] generateGrid(int size) {
    int[][] grid = new int[size][size];
    sc.nextLine();
    for(int r=0; r < size; r++){
      String curRow = sc.nextLine();
      for(int c=0; c < size; c++){
        grid[r][c] = curRow.charAt(c) - '0';
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

  private static boolean same(int row, int col, int size){
    int curVal = grid[row][col];
    for(int r = row; r < row + size; r++){
      for(int c = col; c < col + size; c++) {
        if (grid[r][c] != curVal) return false;
      }
    }
    return true;
  }
}