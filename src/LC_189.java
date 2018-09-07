import java.util.Arrays;
import java.util.Scanner;


public class LC_189 {
  public static void main(){
    int[] orig = new int[]{4,5,7,2,9};
    int[] orig2 = new int[]{4,5,7,2,9};
    int[] orig3= new int[]{4,5,7,2,9};
    int[] orig4 = new int[]{4,5,7,2,9};
    // shift by 3
    // should be  {7,2,9,4,5}

    System.out.println(Arrays.toString(orig));
    System.out.println("Rotated by 3..");
    System.out.println(Arrays.toString(rotateByXDegree_brute(orig, 3)));
    System.out.println(Arrays.toString(rotateByXDegree_extra_arr(orig2, 3)));
  }

  private static int[] rotateByXDegree_brute(int[] nums, int degree){
    //rotate one number at a time
    int tmp, previous;
    int arr_size = nums.length;
    for(int i = 0; i < degree; i++){
      previous = nums[arr_size - 1];
      for(int j = 0; j < arr_size; j++){
        tmp = nums[j];
        nums[j] = previous;
        previous = tmp;
      }
/*
      int temp  = nums[(i+ 1) % arr_size];
      nums[(i + 1) % arr_size] = nums[i];
*/
    }
    return nums;
  }


  private static int[] rotateByXDegree_extra_arr(int[] orig, int degree){
    int arr_size = orig.length;
    int[] newArr = new int[arr_size];

    for(int i = 0; i < arr_size; i++){
      newArr[ (i + degree) % arr_size ] = orig[i];
    }
    return newArr;
  }

  private static int[] rotateByXDegree_cyclic(int[] orig, int degree){
    int arr_size = orig.length;
    degree = degree % arr_size;
    int count = 0;

    for(int start = 0; count < arr_size; start++){

    }
    return null;
  }

  private static int[] rotateByXDegree_reverse(int[] orig, int degree){
    return null;
  }


}
