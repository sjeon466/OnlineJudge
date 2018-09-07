import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LC_1 {
  public static void main(){
    LC_1 l = new LC_1();
    Scanner sc = new Scanner(System.in);
    int numElements = sc.nextInt();
    int[] nums  = new int[numElements];
    for(int i = 0; i < numElements; i++){
      nums[i] = sc.nextInt();
    }
    int target = sc.nextInt();
    int[] ans = l.twoSum(nums, target);
    System.out.println(Arrays.toString(ans));
  }

  public int[] twoSum(int[] nums, int target) {

    // make a hashmap to store the desired counter-part number as the key
    // and the index of the original to be the value.
    // once the counter part number is found,   make a result arr with current index and value of the key.
    Map<Integer, Integer> map = new HashMap<>();
    int[] ans = new int[2];
    for(int i = 0; i < nums.length; i++){
      if(map.containsKey(nums[i])){
        return ans = new int[]{i, map.get(nums[i])};
      }
      int counterPartNum = target - nums[i];
      map.put(counterPartNum, i);
    }
    return ans;
  }
}
