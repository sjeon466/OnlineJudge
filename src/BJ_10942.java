import java.util.Scanner;

public class BJ_10942 {
  static Scanner sc = new Scanner(System.in);
  public static void main(){
     int[] nums = generateNums();
     boolean [][] d = preprocessing(nums);
     int numTCs = sc.nextInt();


     while(numTCs-- > 0){
       int stIndex = sc.nextInt();
       int endIndex = sc.nextInt();




     }
  }







  private static int[] generateNums(){
    int numLen = sc.nextInt();
    int[] nums = new int[numLen + 1];
    for(int i = 1; i < nums.length; i++){
      nums[i] = sc.nextInt();
    }
    return nums;
  }

  private static boolean[][] preprocessing(int[] nums){
    int size = nums.length;
    boolean [][] d = new boolean [size][size];

    //bottom up approach
    // where index i is the staring index,
    // where index j in the ending index


    // so  there are simple cases which would give us O(1):
    //    a.  i == j   (length of 1)

    for(int k = 0; k < d.length; k++){
      d[k][k] = true;
    }

    //b.  i == j+1 and nums[i] == nums[j]  (length of 2)
    for(int i = 0; i < d.length - 1; i++){
      int j = i + 1;
      if(nums[i] == nums[j]){
        d[i][j] = true;
      }
    }

    //where k is the length of palindrome to be checked (length of 3 or more)
    for(int palinLength = 3; palinLength < d.length; palinLength++){
      for(int startIndex = 1; startIndex < d.length - palinLength  + 1; startIndex++){
        int j = startIndex + palinLength - 1;
        if(nums[startIndex] == nums[j] && d[startIndex + 1][j - 1]){
          d[startIndex][j] = true;
        }
      }
    }
    return d;
  }

  private int  go(int[] nums, int[][] d, int left, int right) {
    if (left == right) {
      return 1;
    } else if (left + 1 == right) {
      if (nums[left] == nums[right]) {
        return 1;
      } else return 0;
    }
    // memoization
    if (d[left][right] > 0) return d[left][right];

    if (nums[left] != nums[right]) {
      return 0;
    } else {
      return d[left][right] = go(nums, d, left - 1, right - 1);
    }
  }
}
