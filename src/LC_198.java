import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.Scanner;

public class LC_198 {
  public static void main(){
    Scanner sc = new Scanner(System.in);
    int nums = sc.nextInt();
    int numsArr[] = new int[nums];
    for(int i=0; i<nums;i++){
      numsArr[i] = sc.nextInt();
    }
    LC_198 lc = new LC_198();
    System.out.println(lc.rob(numsArr));
  }
  public int rob(int[] num) {
    int prevDayMax = 0;
    int twoDayAgoMax = 0;

    for(int curDayVal : num){
      int temp = prevDayMax;
      prevDayMax =  Math.max(prevDayMax , curDayVal + twoDayAgoMax);
      twoDayAgoMax = temp;
    }
    return prevDayMax;
/*    int prevMax = 0;
    int currMax = 0;
    for (int r : num) {
      int temp = currMax;
      currMax = Math.max(prevMax + r, currMax);
      prevMax = temp;
    }
    return currMax;*/
  }


/*  public int rob(int[] nums) {
    int numHouses = nums.length;
    int[] maxCumulative = new int[numHouses];

    if(numHouses == 0){
      return 0;
    }

    if(numHouses == 1){
      return nums[0];
    } else if(numHouses == 2){
      return Math.max(nums[0], nums[1]);
    }*//*else if(numHouses == 3){
            return Math.max(nums[1], (nums[0] + nums[2]));
        }*//*

    maxCumulative[0] = nums[0];
    maxCumulative[1] = Math.max(nums[0], nums[1]);
    //maxCumulative[2] = Math.max( nums[1], (nums[0] + nums[2]));

    for(int i = 3; i < numHouses; i++){
      maxCumulative[i] = Math.max( (nums[i] + maxCumulative[i-2]), maxCumulative[i-1]   *//*(maxCumulative[i-3] + nums[i-1])*//*);
    }

    return maxCumulative[numHouses - 1];
  }*/
}
