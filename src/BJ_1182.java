import java.util.Scanner;
public class BJ_1182 {
  public static void main(){
    Scanner sc = new Scanner(System.in);
    int numCount = sc.nextInt();
    int targetSum = sc.nextInt();
    int[] nums = new int[numCount];
    for(int i = 0; i < numCount; i++){
      nums[i] = sc.nextInt();
    }

    int ans = 0;
   // all possibilities
    for(int i = 0; i < (1 << numCount) - 1; i++){
      int sum = 0;
      for( int k = 0; k < numCount; k++){
        if( (i & ( 1 << k)) != 0 ){
          sum += nums[k];
        }
      }
      if(sum == targetSum){
        ans += 1;
      }
    }
    System.out.println(ans);



         /* int ans = go(nums, 0, targetSum, 0);
    if(targetSum == 0) ans--;
    System.out.println(ans);*/

  }

  private static int go(int[] nums, int curNumsIndex, int targetSum, int curSum){
    if(curSum == targetSum) return 1;
    if(curSum > targetSum) return 0;

    //curSum still smaller, add possible values
    // check if next number is a possible candidate
    int ans = 0;
    if(curNumsIndex + 1 < nums.length){
        ans += go(nums,curNumsIndex + 1, targetSum, curSum + nums[curNumsIndex + 1]);
        ans += go(nums, curNumsIndex + 1, targetSum, curSum);
    }
    return ans;
  }

}
