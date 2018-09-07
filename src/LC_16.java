import java.util.*;

public class LC_16 {
  public static void main(){
    Scanner sc = new Scanner(System.in);
    int target = sc.nextInt();

    int num = sc.nextInt();
    int[] arr = new int[num];
    for(int i=0; i < num; i++){
      arr[i] = sc.nextInt();
    }

    LC_16 l = new LC_16();
    System.out.println(l.threeSumClosest(arr, target));


  }

  public int threeSumClosest(int[] nums, int target) {

    int diff = Integer.MAX_VALUE;
    int ansSum = Integer.MAX_VALUE;

    //Map<Integer, List<Integer>> result = new HashMap<>();
    List<List<Integer>> result = new ArrayList<>();

    Arrays.sort(nums);

    for(int i = 0; i < nums.length ; i++){
      // ignore duplicate
      if(i == 0 || (i > 0 && nums[i] != nums[i-1]) ){
        int left = i+1; int right = nums.length - 1;
        while(left < right){
          int sum = nums[i] + nums[left] + nums[right];

          if(sum == target){
            diff = 0;
            ansSum = 0;
            break;
          }

          if(sum < target){
            if(Math.abs(sum - target) < diff ){
              diff = Math.abs(sum - target);
              ansSum = sum;
            }
            left++;
          }else{
            if(Math.abs(sum - target) < diff ){
              diff = Math.abs(sum - target);
              ansSum = sum;
            }
            right--;
          }
        }
      }
    }
    return ansSum;
  }
}
