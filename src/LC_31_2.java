import java.util.Arrays;
import java.util.Scanner;

public class LC_31_2 {
  public static void main(){
    Scanner sc = new Scanner(System.in);
    int numDigit = sc.nextInt();
    int[] arr = new int[numDigit];
    for(int i = 0; i < numDigit; i++){
      arr[i] = sc.nextInt();
    }
    System.out.println("Before Pemutation:");
    System.out.println(Arrays.toString(arr));

    System.out.println();
    System.out.println();

    System.out.println("After Permutation");

    nextPermutation(arr);

    System.out.println(Arrays.toString(arr));


  }

  public static void nextPermutation(int[] nums) {

    //[9,   5,   4,   8,   7,   6,   3,  2,   1]
    //           i    i+1
    //

    int i = nums.length - 2;

    while( i >= 0  && nums[i]  >  nums[i + 1] ){
      i--;
    }


    //[9,   5,   4,   8,   7,   6,   3,  2,   1]
    //           i                            j
    //

    int j = nums.length - 1;

    while(i < j && nums[j] < nums[i] ){
      j--;
    }

    //System.out.println("i with index " + i + ", nums[i]=" + nums[i] );
   // System.out.println("j with index " + j + ", nums[j]=" + nums[j] );
    // i found at index 2 with value 4!!!


    //[9,   5,   4,   8,   7,   6,   3,  2,   1]
    //           i              j
    //

    // swap nums[i]  with nums[j]
    swap(nums , i , j);


    //[9,   5,   6,   8,   7,   4,   3,  2,   1]
    //           i              j
    //

    // reverse  from (i+1) ~~~  end


    reverse(nums, i + 1 , nums.length - 1 );
  }

  private static void reverse(int[] nums, int start, int end){
    //[9,   5,   6,   8,   7,   4,   3,  2,   1]
    //           i               j
    //                st                      end

    //[9,   5,   6,   1,   7,   4,   3,  2,   8]
    //           i              j
    //                     st           end
    while(start < end){
      swap(nums, start , end);
      start++;
      end--;
    }
  }

  private static void swap(int[] nums, int i, int j){
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }
}
