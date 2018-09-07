import java.util.Arrays;
import java.util.Scanner;

public class LC_300 {
  public static void main(){
    Scanner sc = new Scanner(System.in);
    int numElements = sc.nextInt();
    int[] nums = new int[numElements];

    for(int i = 0; i < numElements; i++){
      nums[i] = sc.nextInt();
    }

    LC_300 l = new LC_300();
    System.out.println(l.lengthOfLIS(nums));
  }

  public int lengthOfLIS(int[] nums){
    int[] dp = new int[nums.length];
    int len = 0;

    for(int num: nums){
      int i =  Arrays.binarySearch(dp, 0, len, num);

      if(i < 0){
        i = -(i + 1);
      }

      dp[i] = num;
      if(i == len){
        len++;
      }
    }
    return len;
  }


  public int lengthOfLIS9(int[] num){

    return -1;
  }


  // let d[n] represent the LIS  up until n-th index

  //then  d[n] =  Max ( d[i] ) + 1,  for all   0 <=  i < n
  public int lengthOfLIS8(int[] num){
    int[] d = new int[num.length];
    d[0] = 1;
    int ans = 1;

    for(int n = 1; n < num.length; n++){
      int maxfromi = 1;
      for(int i = 0; i < n; i++){
        //if(d[i] > )
        if(num[n] > num[i]){
          maxfromi = Math.max(maxfromi, d[i]);
        }
      }
      d[n] = maxfromi + 1;
      ans = Math.max(ans, d[n]);
    }
    return ans;
  }

  public int lengthOfLIS6(int[] nums){

    int memo[][] = new int[nums.length + 1][nums.length + 1];
    for(int[] curRow : memo){
      Arrays.fill(curRow, -1);
    }
    return lenOfLIS(nums, -1, 0, memo);
  }

  private int lenOfLIS(int[] nums, int prevIndex, int curPos, int[][] memo) {
    if(curPos == nums.length){
      return 0;
    }

    if(memo[prevIndex + 1 ][curPos] >= 0){
      return memo[prevIndex + 1][curPos];
    }

    int taken = 0;

    if(prevIndex < 0 || nums[curPos] > nums[prevIndex]){
      taken = 1 + lenOfLIS(nums, curPos, curPos + 1, memo);
    }

    int notTaken = lenOfLIS(nums, prevIndex, curPos + 1, memo);
    memo[prevIndex + 1][curPos] = Math.max(taken, notTaken);
    return memo[prevIndex + 1][curPos];
  }

  public int lengthOfLIS4(int[] nums){
    return lengthOfLISHelper4(nums, 0, Integer.MIN_VALUE);
  }

  private int lengthOfLISHelper4(int[] nums, int index, int prevVal ){
    if(index == nums.length) return 0;

    int curValTakenCount = 0;

    if(nums[index] > prevVal){
      curValTakenCount = lengthOfLISHelper4(nums, index + 1, nums[index]) + 1;
    }

    int curValNotTakenCount = lengthOfLISHelper4(nums, index + 1, prevVal);

    return Math.max(curValTakenCount, curValNotTakenCount);
  }

  public int lengthOfLIS3(int[] nums) {
    return lengthOfLIS(nums, Integer.MIN_VALUE, 0);

  }

  public int lengthOfLISHelper3(int[] nums, int prevVal, int curPos){
    if(curPos == nums.length) return 0;

    int ifCurTaken = 0;
    if(nums[curPos] > prevVal){
      ifCurTaken = 1 + lengthOfLISHelper4(nums, nums[curPos], curPos + 1);
    }

    int ifCurNotTaken = lengthOfLISHelper4(nums, prevVal, curPos  + 1);
    return Math.max(ifCurTaken, ifCurNotTaken);
  }




  //Brute force 1 (recursion)
  public int lengthOfLIS2(int[] nums) {
    return lengthOfLIS(nums, Integer.MIN_VALUE, 0);
  }

  private int lengthOfLIS(int[] nums, int prev, int curpos) {
    if(curpos == nums.length) return 0;

    int taken = 0;

    if(nums[curpos] > prev){
      taken = 1 + lengthOfLIS(nums, nums[curpos], curpos + 1);
    }
    int notTaken = lengthOfLIS(nums, prev, curpos + 1);
    return Math.max(taken, notTaken);
  }
}
