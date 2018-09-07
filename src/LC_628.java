import java.util.*;

public class LC_628 {

  public static void main(){
    Scanner sc = new Scanner(System.in);
    List<Integer> items = new ArrayList<Integer>();
    LC_628 l = new LC_628();
    //System.out.println(l.maximumProduct(new int[]{1,2,3,4}));
    System.out.println(l.maximumProduct(new int[]{-1, -2, -3}));

  }

  public int maximumProduct(int[] nums){
    PriorityQueue<Integer> poheap = new PriorityQueue<>();
    PriorityQueue<Integer> negheap = new PriorityQueue<>(Collections.reverseOrder());

    for(int num : nums){
      poheap.offer(num);
      negheap.offer(num);
      if(poheap.size() > 3){
        poheap.poll();
      }
      if(negheap.size() > 2){
        negheap.poll();
      }
    }

    int c1 = 1;
    int max = 0;
    while(!poheap.isEmpty()){
      max = poheap.poll();
      c1 *= max;
    }
    return 01;
  }

  public int maximumProduct3(int[] nums){
    int max1 = Integer.MIN_VALUE;
    int max2 = Integer.MIN_VALUE;
    int max3 = Integer.MIN_VALUE;

    int min2 = Integer.MAX_VALUE;
    int min1 = Integer.MAX_VALUE;

    for(int i=0; i < nums.length; i++){
      int curNum = nums[i];
      if(curNum > max1){
        max3 = max2;
        max2 = max1;
        max1 = curNum;
      }else if(curNum > max2){
        max3 = max2;
        max2 = curNum;
      }else if(curNum > max3){
        max3 = curNum;
      }else if(curNum < min1){
        min2 = min1;
        curNum = min1;
      }else if(curNum < min2){
         min2 = curNum;
      }
    }

    return Math.max(max1 * max2 * max3, min1 * min2 * max1);

  }


  public int maximumProduct5(int[] nums){
    int n = nums.length;
/*    Integer[] nums2 = new Integer[n];
    for(int i=0; i < n; i++){
      nums2[i] = nums[i];
    }
    Arrays.sort(nums2, Collections.reverseOrder());
    */
    //Arrays.sort(nums, Collections.reverseOrder());

    // only two cases to consider.

    // Case A. multiply largest with second largest and third largest

    // Case B. multiply lowest with second lowest with largest.

    return Math.max(nums[n - 1] * nums[n - 2] * nums[n-3], nums[0] * nums[1] * nums[n-1]);

  }



  public int maximumProduct4(int[] nums) {
    int highest_product_of_three = nums[0] * nums[1] * nums[2];
    int highest_product_of_two = nums[0] * nums[1];
    int lowest_product_of_two = nums[0] * nums[1];

    int highest_max = Math.max(nums[0], nums[1]);
    int lowest_min = Math.min(nums[0], nums[1]);

    for(int i=2; i < nums.length; i++) {
      highest_product_of_three = Math.max(highest_product_of_three,
              Math.max(nums[i] * highest_product_of_two, nums[i] * lowest_product_of_two));

      highest_product_of_two = Math.max(nums[i] * highest_max, nums[i] * lowest_min);
      lowest_product_of_two = Math.min(nums[i] * highest_max, nums[i] * lowest_min);

      highest_max = Math.max(highest_max, nums[i]);
      lowest_min = Math.min(lowest_min, nums[i]);
    }
    return highest_product_of_three;
  }

  public int maximumProduct2(int[] nums) {
    //List<T> ans = new ArrayList<Integer>();
    Arrays.sort(nums);
    boolean moreThanTwoNegs = false;
    int negCount = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] < 0) {
        negCount++;
        if (negCount >= 2) {
          moreThanTwoNegs = true;
          break;
        }
      }
    }

    //more than 2 negs
    //


    return -1;
  }


}


