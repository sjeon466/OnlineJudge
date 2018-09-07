import java.util.Arrays;
import java.util.Scanner;


public class LC_26 {
  public static void main(){
    LC_26 l = new LC_26();

    int[] myArr = new int[]{0,0,1,1,1,2,2,3,3,4};
    System.out.println(l.removeDuplicates(myArr));
    System.out.println(Arrays.toString(myArr));
  }
  public int removeDuplicates(int[] nums) {
    if(nums == null) return -1;
    if(nums.length < 2) return nums.length;

    int slow = 0;
    for(int fast = 1; fast < nums.length; fast++){
      if(nums[slow] != nums[fast]){
        nums[++slow] = nums[fast];
      }
    }
    return slow + 1;
  }

}
