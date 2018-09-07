import java.util.Scanner;

public class BJ_10971 {

  public static void main(){
    BJ_10971 b = new BJ_10971();
    int[][] grid = generateGrid();
    System.out.println(b.calcMinPath(grid));
  }

  private static int[][] generateGrid(){
    Scanner sc = new Scanner(System.in);
    int rowColSize = sc.nextInt();
    int[][] grid = new int[rowColSize][rowColSize];
    for(int r = 0; r < rowColSize; r++){
      for(int c = 0; c < rowColSize; c++){
        grid[r][c] = sc.nextInt();
      }
    }
    return grid;
  }

  private int calcMinPath(int[][] grid){
    int numCities = grid.length;
    int[] d = new int[numCities];
    for(int i = 0; i < numCities; i++) d[i] = i;
    int ans = Integer.MAX_VALUE;

    do{
      if(d[0] != 1) break;

      boolean ok = true;
      int sum = 0;

      for(int i = 0; i < numCities - 2; i++){
        if(grid[d[i]][d[i+1]] == 0) ok = false;
        else sum += grid[d[i]][d[i+1]];
      }

      if(ok && grid[0][0] != 0 && grid[d[numCities-2]][0] != 0){
        sum += grid[0][d[0]] + grid[d[numCities-2]][0];
        ans = Math.min(ans, sum);
      }
    }while(next_permutation(d));
   return ans;
  }

  private static boolean next_permutation(int[] a) {
    int i = a.length-1;
    while (i > 0 && a[i-1] >= a[i]) {
      i -= 1;
    }

    if (i <= 0) {
      return false;
    }

    int j = a.length-1;
    while (a[j] <= a[i-1]) {
      j -= 1;
    }

    int temp = a[i-1];
    a[i-1] = a[j];
    a[j] = temp;

    j = a.length-1;
    while (i < j) {
      temp = a[i];
      a[i] = a[j];
      a[j] = temp;
      i += 1;
      j -= 1;
    }
    return true;
  }
}
