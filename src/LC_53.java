import java.util.Scanner;

public class LC_53 {
  public static void main(){
    Scanner sc = new Scanner(System.in);
    LC_53 l = new LC_53();
    int numElements =  sc.nextInt();
    int[] arr = new int[numElements];
    for(int i = 0; i < numElements; i++){
      arr[i] = sc.nextInt();
    }
    System.out.println( l.maxSubArray(arr) );
  }

  public int maxSubArray(int[] nums) {
    if(nums == null || nums.length == 0) return 0;

    int[] dArr = new int[nums.length];

    dArr[0] = nums[0];
    int maxSum = dArr[0];

    for(int i = 1; i < dArr.length; i++){
      int curSum = Math.max( dArr[i-1] + nums[i] , nums[i]);
      maxSum = Math.max(curSum, maxSum);
      dArr[i] = curSum;
    }
    return maxSum;
  }

}
