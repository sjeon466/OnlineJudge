import java.util.*;

public class LC_15 {
  public static void main(){
    Scanner sc = new Scanner(System.in);
    int num = sc.nextInt();
    int[] arr = new int[num];
    for(int i=0; i < num; i++){
      arr[i] = sc.nextInt();
    }
    LC_15 l = new LC_15();

    Arrays.sort(arr);

    List<List<Integer>>list = l.threeSum(arr);

    for(List<Integer> curL: list){
      for(int val : curL){
        System.out.print(arr[val] + " ");
      }
      System.out.println();
    }
  }


  public List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);

    List<List<Integer>> result = new LinkedList<>();

    for(int i=0; i < nums.length; i++){
      if(i == 0 || (i > 0 && nums[i] != nums[i-1])){
        int low = i + 1, high = nums.length - 1, sum = 0 - nums[i];

        while(low < high){
          if(nums[low] + nums[high] == sum){
            result.add(Arrays.asList(nums[i], nums[low], nums[high]));
            while(low < high && nums[low] == nums[low+1]) low++;
            while(low < high && nums[high] == nums[high-1]) high--;
            low++; high--;
          } else if(nums[low] + nums[high] < sum){
            low++;
          }else{
            high--;
          }
        }
      }
    }
    return result;
















  }

  public List<List<Integer>> threeSum2(int[] nums) {
    List<List<Integer>> list = new ArrayList<List<Integer>>();
    if(nums.length < 3) return null;
    int left = 0, right = nums.length - 1;


    /*
    //early exit cases,  A) all negs   B) all pos
    boolean isSignChanged = false;
    for(int i=0; i < nums.length; i++){

    }*/

    if(Math.abs(nums[left]) < Math.abs(nums[right])){
      //third pointer should be on the left
      int third = left + 1;
      while(left < right && third != left && third != right  && (nums[left] * nums[right]) < 0 ){
        if(Math.abs(nums[left] + nums[third]) == Math.abs(nums[right]) ){
          list.add(new ArrayList<Integer>(Arrays.asList(left,right,third)));
          right--;
        }else if( Math.abs(nums[left] + nums[third]) < Math.abs( nums[right] ) ){
          right--;
        }else{
          third++;
        }
      }
    } else if(Math.abs(nums[left]) > Math.abs(nums[right])){
      //third pointer should be on the right
      int third = right - 1;
      while(left < right && third != left && third != right && (nums[left] * nums[right]) < 0 ){
        if(Math.abs(nums[right] + nums[third]) == Math.abs(nums[left]) ){
          list.add(new ArrayList<Integer>(Arrays.asList(left,right,third)));
          left++;
        }else if( Math.abs(nums[right] + nums[third]) < Math.abs(nums[left]) ){
          left++;
        }else{
          third--;
        }
      }
    }


    return list;
  }
}
