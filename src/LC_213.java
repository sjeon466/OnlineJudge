
import java.util.Scanner;


public class LC_213 {
  private static Scanner sc = new Scanner(System.in);
  public static void main(){
    int numOfVals = sc.nextInt();
    int[] nums = new int[numOfVals];
    for(int i=0; i < numOfVals; i++){
      nums[i] = sc.nextInt();
    }
    System.out.println(nums);
  }

  public int rob(int[] nums) {
    return -1;

  }
}
