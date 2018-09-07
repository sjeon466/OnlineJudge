import java.util.Arrays;
import java.util.Scanner;


public class LC_31 {
  public static void main(){
    Scanner sc = new Scanner(System.in);
    int numLength = sc.nextInt();
    int[] numArr = new int[numLength];
    for(int i = 0; i < numLength; i++){
      numArr[i] = sc.nextInt();
    }
    System.out.println();
    System.out.println(Arrays.toString(numArr));
    System.out.println();
    System.out.println("next permutation : ");
    LC_31 l = new LC_31();
    l.nextPermutation(numArr);
    System.out.println(Arrays.toString(numArr));
  }

  public boolean nextPermutation(int[] nums){
    int arr_size = nums.length;
    int i = nums.length - 2;
    while(i >= 0 && nums[i] > nums[i + 1]){
      i--;
    }
    //found i

    if(i >= 0){
      //find j
      int j = nums.length - 1;
      while(j >= 0 && nums[i] > nums[j]){
        j--;
      }
      swap(nums, i , j);
    }
    reverse(nums, i+ 1);

    return true;
  }
  private void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }

  private void reverse(int[] nums, int st){
    int end = nums.length - 1;
    while(st < end){
      swap(nums, st, end);
      st++;
      end--;
    }
  }

  public boolean nextPermutation4(int[] nums){
    int i = nums.length - 1;
    while( i > 0 && nums[i-1] > nums[i]){
      i--;
    }

    // acquired i.

    // this is last permutation
    if(i <= 0){
      return false;
    }


    int j = nums.length - 1;

    while(nums[j] <= nums[i - 1]){
      j--;
    }

    //swap j and  i - 1
    int temp = nums[i - 1];
    nums[i - 1] = nums[j];
    nums[j] = temp;

    j = nums.length - 1;
    while(i < j){
      temp = nums[j];
      nums[j] = nums[i];
      nums[i] = temp;
      i++;
      j--;
    }
    return true;
  }

/*  private void reverse(int[] nums, int start){
    int i = start, j = nums.length - 1;
    while(i < j){
      swap(nums, i, j);
      i++;
      j--;
    }
  }*/



  public void nextPermutation3(int[] nums) {
    //find "i" and "i-1"
    // where there is the first increasing sequence start from the right side.
    // because that is the number that need to be used to rearrange to get the
    // next permutation.
    int arrLeng = nums.length;
    int i;
    for(i = arrLeng - 1; i > 0; i--){
      if(nums[i-1] < nums[i]) break;
    }
    System.out.println();
    System.out.println("nums[i-1] = " + nums[i-1] + ", i-1 = " + (i-1) );

    //find "j"
    // where  i < j, and nums[i] < nums[j]  and j is the largest
    int j;
    for(j = i; j <= arrLeng - 1; j++){
      if(nums[j] < nums[i-1]) break;
    }
    j--;
    System.out.println();
    System.out.println("nums[j] = " + nums[j] + ", j = " + (j) );
    System.out.println();


    //swap (i - 1)and j
    int temp = nums[i-1];
    nums[i-1] = nums[j];
    nums[j] = temp;

    //reverse from i to the end

    int mid = (i + arrLeng - 1) / 2;
    for(int k = i; k <= mid; k++){
      int tmp = nums[k];
      nums[k] = nums[(arrLeng - 1) + i - k ];
      nums[(arrLeng - 1) + i - k ] = tmp;
    }
  }


}
