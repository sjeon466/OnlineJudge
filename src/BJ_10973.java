import java.util.Arrays;
import java.util.Scanner;

public class BJ_10973 {
  public static void main(){
    Scanner sc = new Scanner(System.in);
    int numLength = sc.nextInt();
    int[] numArr = new int[numLength];
    for(int i = 0; i < numLength; i++){
      numArr[i] = sc.nextInt();
    }
    //System.out.println();
    //System.out.println(Arrays.toString(numArr));
    //System.out.println();
    //System.out.println("prev permutation : ");
    BJ_10973 l = new BJ_10973();
    l.prevPermutation(numArr);
    //System.out.println(Arrays.toString(numArr));
  }

  public void prevPermutation(int[] nums) {

    int i = nums.length - 2;

    while(i >= 0 && nums[i] < nums[i + 1]){
      i--;
    }

    if(i < 0){
      // very first permutation.
      System.out.println(-1);
    }else {
      int j = nums.length - 1;
      while (j > 0 && nums[j] > nums[i]) {
        j--;
      }
      swap(nums, i, j);
      reverse(nums, i + 1);
      printArr(nums);
    }
  }

  private void printArr(int[] nums){
    for(int i : nums){
      System.out.print(i + " ");
    }
  }

  private void swap(int[] nums, int i, int j){
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }

  private void reverse(int[] nums, int st){
    int end = nums.length - 1;
    while(st < end){
      swap(nums, st, end);
      st++; end--;
    }
  }
}
