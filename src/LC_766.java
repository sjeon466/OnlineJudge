public class LC_766 {
  public boolean isToeplitzMatrix(int[][] matrix) {
    if(matrix == null) return false;

    for(int r = 0; r < matrix.length; r++){
      for(int c = 0; c < matrix[0].length; c++){
        if(r > 0 && c > 0){
          if(matrix[r-1][c-1] != matrix[r][c]) return false;
        }
      }
    }
    return true;
  }
}
