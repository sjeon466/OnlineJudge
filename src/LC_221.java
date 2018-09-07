import java.util.Scanner;

public class LC_221 {
  public static void main(){
    char[][] matrix = generateMatrix();
    LC_221 l = new LC_221();
    System.out.println(l.maximalSquare(matrix));
  }

  private static char[][] generateMatrix() {
    /* return new char[][]{
    };*/
    return new char[][]{
            {'1', '0', '1', '0', '0'},
            {'1', '0', '1', '1', '1'},
            {'1', '1', '1', '1', '1'},
            {'1', '0', '0', '1', '0'},
    };
  }

  public int maximalSquare(char[][] matrix) {
    int rowSize = matrix.length, colSize = rowSize > 0 ? matrix[0].length : 0;
    int[] dp = new int[colSize + 1];

    int maxsqlen = 0, prev = 0;

    for(int r = 1;  r <= rowSize; r++){
      for(int c = 1; c <= colSize; c++){
        int prev_dp_c = dp[c];

        if(matrix[r-1][c-1] == '1'){
          dp[c] = Math.min(dp[c], Math.min(dp[c-1], prev_dp_c)) + 1;
          maxsqlen = Math.max(maxsqlen, dp[c]);
        }else{
          dp[c] = 0;
        }
        //prev_dp_c = dp[c];
      }
    }
    return maxsqlen * maxsqlen;
  }

  public int maximalSquare6(char[][] matrix) {
    int rowSize = matrix.length, colSize = rowSize > 0 ? matrix[0].length : 0;
    int[][] dp = new int[rowSize + 1][colSize + 1];
    int maxSqlen = 0;

    for(int r = 1; r <= rowSize; r++){
      for(int c = 1; c <= colSize; c++){
        if(matrix[r-1][c-1] == '1'){
          dp[r][c] = Math.min(dp[r-1][c-1], Math.min(dp[r][c-1], dp[r-1][c])) + 1;
          maxSqlen = Math.max(maxSqlen , dp[r][c]);
        }
      }
    }
    return maxSqlen * maxSqlen;
  }

  public int maximalSquare4(char[][] matrix) {
    if(matrix == null) return 0;
    int rowSize = matrix.length, colSize = (matrix.length > 0 ) ? matrix[0].length : 0;

    // extra column on the left with zeros
    int[][] dp = new int[2][colSize + 1];

    //initializing the values for DP row 0.
    for(int i = 1; i <= colSize; i++){
      dp[0][i] = matrix[0][i-1] == '1' ? 1 : 0;
    }

    int maxVal = 0;
    for(int r = 1; r < rowSize; r++){
      for(int c = 0; c < colSize; c++){
        if(matrix[r][c] == '1'){
          dp[1][c+1] = Math.min( dp[0][c], Math.min(dp[0][c+1] , dp[1][c])) + 1;
          maxVal = Math.max(dp[1][c+1], maxVal);
        }
      }
      for(int col = 1; col <= colSize; col++){
        dp[0][col] = dp[1][col];
      }
    }
    return maxVal * maxVal;
  }

  public int maximalSquare2(char[][] matrix) {
    int maxSize = 0;
    if(matrix == null || matrix.length == 0) return 0;
    int rowSize = matrix.length;
    int colSize = matrix[0].length;
    for(int r = 0; r < rowSize; r++){
      for(int c = 0; c < colSize; c++){
        if(matrix[r][c] == '1'){
         // maxSize = Math.max(maxSize, calcMaxSize(r, c, matrix));
        }
      }
    }
    return maxSize;
  }

  public int maximalSquare3(char[][] matrix) {
    if(matrix == null || matrix.length == 0) return 0;
    int rowSize = matrix.length, colSize = rowSize > 0 ? matrix[0].length : 0;
    int[][] dp = new int[rowSize][colSize];


    // intializing column 0 values
    for(int r = 0; r < rowSize; r++){
      dp[r][0] = (matrix[r][0] == '0') ?  0 : 1;
    }

    // initializing row 0 values
    for(int c = 0; c < colSize; c++){
      dp[0][c] = (matrix[0][c] == '0') ? 0 : 1;
    }

    for(int r = 1; r < rowSize; r++){
      for(int c = 1; c < colSize; c++){
        if(matrix[r][c] == '0') dp [r][c] = 0;
        else dp[r][c] = Math.min(dp[r-1][c-1], Math.min(dp[r][c-1], dp[r-1][c])) + 1;
      }
    }

    int maxVal = 0;
    for(int r = 0; r < rowSize; r++){
      for(int c = 0; c < colSize; c++){
        maxVal = Math.max(maxVal, dp[r][c]);
      }
    }
    return maxVal * maxVal;
  }

  private int calcMaxSize2(int rowStart, int colStart, char[][] matrix) {
    int curR = rowStart + 1, curC = colStart + 1;
    int maxSize = 1, curSize = 1;
    int rowSize = matrix.length, colSize = matrix[0].length;

    outerloop:
    while(curR < rowSize && curC < colSize && matrix[rowStart][colStart] == '1'){
      boolean allRowOne = true, allColOne = true;

      //check new Row
      for(int i = colStart; i <= curC; i++){
        if(matrix[curR][i] == '0'){
          allRowOne = false;
          break outerloop;
        }
      }
      //check new column
      for(int i = rowStart; i <= curR; i++){
        if(matrix[i][curC] == '0'){
          allColOne = false;
          break outerloop;
        }
      }

      if(allColOne && allRowOne){
        curSize = (int) Math.pow(curC - colStart + 1, 2);
        maxSize = Math.max(curSize, maxSize);
        curC++;
        curR++;
      }
    }
    return maxSize;
  }
}
