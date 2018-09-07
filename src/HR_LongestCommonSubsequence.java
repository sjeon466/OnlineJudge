import java.util.Arrays;
import java.util.Scanner;

public class HR_LongestCommonSubsequence {
  public static void main(){
    Scanner sc = new Scanner(System.in);
    int numAs = sc.nextInt();
    int numBs = sc.nextInt();

    int[] arrA = new int[numAs];
    int[] arrB = new int[numBs];
    for(int i = 0; i < arrA.length; i++){
      arrA[i] = sc.nextInt();
    }
    for(int i = 0; i < arrB.length; i++){
      arrB[i] = sc.nextInt();
    }
    System.out.println(Arrays.toString(longestCommonSubsequence(arrA, arrB)));
  }

  // Complete the longestCommonSubsequence function below.
  static int[] longestCommonSubsequence(int[] arrA, int[] arrB) {
    int[][] dp = new int[arrA.length + 1][arrB.length + 1];

    for(int r = 1; r <= arrA.length; r++){
      for(int c = 1; c <= arrB.length; c++){
        if(arrA[r - 1] == arrB[c - 1]){
          // if same, put the updated val from the prev diag
          dp[r][c] = dp[r - 1][c - 1] + 1;
        }else{
          // if not same, take the greater between prev two vals
          dp[r][c] = Math.max(dp[r - 1][c], dp[r][c - 1]);
        }
      }
    }

    //find the max length and its sequence
    int maxLength = dp[arrA.length][arrB.length];
    //System.out.println(maxLength);
    int[] solutionArr = new int[maxLength];

    int r = arrA.length, c = arrB.length;
    int solutionArrIndex = solutionArr.length - 1;

    while(maxLength > 0){
      //same found?
      //  a. put it into the arr
      //  b. move diagonal
      if(arrA[r - 1] == arrB[c - 1]){
        solutionArr[solutionArrIndex--] = arrA[r - 1];
        r--; c--;
        maxLength--;
      }else{
        // same not found
        // find the bigger of the two adjacent val
        // move to the position
        if(dp[r][c - 1] > dp[r - 1][c]){
          // left if bigger and up
          c--;
        }else{
          // up is bigger than left
          r--;
        }
      }
    }
    return solutionArr;
  }

}
