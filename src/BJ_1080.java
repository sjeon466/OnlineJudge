import java.util.Scanner;

public class BJ_1080 {
  private static Scanner sc = new Scanner(System.in);
  public static void main(){
    int rowSize = sc.nextInt();
    //System.out.println(rowSize);
    int colSize = sc.nextInt();
    //System.out.println(colSize);

    sc.nextLine();
    int[][] matrixA = generateMatrix(rowSize, colSize);
    int[][] matrixB = generateMatrix(rowSize, colSize);
    //System.out.println("Original:  ");
    //BJ_Utils.print2DArrayAligned(matrixA);
    //BJ_Utils.getInstance().print2DArrayAligned(matrixA);
    //System.out.println("===============");
    //System.out.println("Target:   ");
    //BJ_Utils.print2DArrayAligned(matrixB);
    //BJ_Utils.getInstance().print2DArrayAligned(matrixB);
    //System.out.println("Flipping 1,2 : ");
    //flip(1,2,matrixB);
    //BJ_Utils.print2DArrayAligned(matrixB);

    int flipCount = processFlipDecision(matrixA, matrixB);

    //System.out.println("**AFTER FLIP***");
    //System.out.println("Target:   ");
    //BJ_Utils.print2DArrayAligned(matrixB);
    if(AreTwoMatricesSame(matrixA, matrixB)){
      System.out.println(flipCount);
    }else{
      System.out.println(-1);
    }
    //System.out.println("MatA & MatB same? : " + BJ_Utils.AreTwoMatricesSame(matrixA, matrixB));
  }

  private static int processFlipDecision(int[][] matA, int[][] matB){
    int rowSize = matA.length;
    int colSize = matA[0].length;
    int flipCount = 0;
    for(int r =0; r < rowSize - 2; r++){
      for(int c=0; c < colSize - 2; c++){
        if(matA[r][c] != matB[r][c]){
          //flip
          flip(r+1, c+1, matB);
          flipCount++;
        }
      }
    }
    return flipCount;
  }

  private static int[][] generateMatrix(int rowSize, int colSize) {
    int[][] matrix = new int[rowSize][colSize];
    for(int r=0; r<rowSize; r++){
      String curRow = sc.nextLine();
      for(int c=0; c<colSize; c++){
        matrix[r][c] = curRow.charAt(c) - '0';
      }
    }
    return matrix;
  }

  public static void flip(int rCetner, int cCenter, int[][] targetMatrix){
    int rowSize = targetMatrix.length;
    int colSize = targetMatrix[0].length;
    //System.out.println("rowSize : " + rowSize + " ,  colSize : " + colSize);

    // Redundant sanity check
    if( rCetner <= 0 || rowSize-1 <= rCetner || cCenter <= 0 || colSize-1 <= cCenter ){
      try{
        throw new IndexOutOfBoundsException("Matrix boundary exceeded");
      }catch (IndexOutOfBoundsException e){
        System.out.println(e.getMessage());
        e.printStackTrace();
      }
    }
    for(int r = rCetner-1;  r <= rCetner + 1; r++){
      for(int c = cCenter-1; c <= cCenter + 1; c++){
        targetMatrix[r][c] ^= 1;
      }
    }
  }
  public static void print2DArrayAligned(int[][] matrix){
    for(int[] curRow : matrix){
      for(int curVal : curRow){
        System.out.printf("%5d", curVal);
      }
      System.out.println();
    }
  }

    public static boolean AreTwoMatricesSame(int[][] matrixA, int[][] matrixB){
    if(matrixA.length != matrixB.length || matrixA[0].length != matrixB[0].length){
      return false;
    }
    for(int r=0; r < matrixA.length; r++){
      for(int c=0; c < matrixA[0].length; c++){
        if(matrixA[r][c] != matrixB[r][c]){
          return false;
        }
      }
    }
    return true;
  }
}
class MyCustomException extends Exception{
  public MyCustomException(){}
  // Constructor that accepts a message
  public MyCustomException(String message){
    super(message);
  }
}