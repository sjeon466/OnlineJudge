import java.util.Arrays;
import java.util.Scanner;

public class LC_238 {
  public static void main(){
    Scanner sc = new Scanner(System.in);
    LC_238 l = new LC_238();
    System.out.println(Arrays.toString(
            l.productExceptSelf(new int[]{1,2,3,4})));
  }
  public int[] productExceptSelf(int[] nums) {
    int n = nums.length;
    int[] cumulProductToLeft = new int[n];
    int[] cumulProductToRight = new int[n];
    int[] ans = new int[n];

    cumulProductToRight[n-1] = nums[n-1];
    cumulProductToLeft[0] = nums[0];

    for(int i=1; i < n; i++){
      cumulProductToLeft[i] = cumulProductToLeft[i-1] *  nums[i];
    }
    for(int i = (nums.length - 2); i >= 0; i--){
      cumulProductToRight[i] = cumulProductToRight[i+1] * nums[i];
    }


    for(int i = 1; i < n - 1; i++){
      ans[i] = cumulProductToLeft[i-1] * cumulProductToRight[i+1];
    }

    ans[0] = cumulProductToRight[1];
    ans[n-1] = cumulProductToLeft[n-2];

    return ans;
  }
}
