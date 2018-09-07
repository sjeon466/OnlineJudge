import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LC_535 {
  public static void main(){
    LC_535 l = new LC_535();
    System.out.println(l.findPairs(new int[]{3, 1, 4, 1, 5},2));
  }

  public int findPairs(int[] nums, int k){
    if(k < 0) return 0;
    Map<Integer,Integer> map = new HashMap<Integer, Integer>();
    int pairs = 0;
    for(int num : nums){
      map.put(num, map.getOrDefault(num, 0) + 1);
      int count = map.get(num);
      if(k != 0 && count == 1){
        if(map.containsKey(k + num)){
          pairs++;
        }
        if(map.containsKey(num - k)){
          pairs++;
        }
      }else if(k == 0 && count == 2){
        pairs++;
      }
    }
    return pairs;
  }
  public int findPairs2(int[] nums, int k) {
    Arrays.sort(nums);
    int ans = 0;
    for(int left = 0, right = 0; left < nums.length; left++){
      for(right = Math.max(right, left + 1); right < nums.length && (nums[right] - nums[left]) < k; right++);
      if(right < nums.length &&  nums[right] - nums[left] == k) ans++;
      while(left + 1 < nums.length && nums[left] == nums[left + 1]) left++;
    }
    return ans;
  }
}
