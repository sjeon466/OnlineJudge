import java.util.Arrays;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class LC_442 {
  public static void main(){
    Scanner sc = new Scanner(System.in);
    //List<Integer> resList = new ArrayList<>();
    List<Integer> resList;// = new ArrayList<>();
    int nums = sc.nextInt();
    int[] arr = new int[nums];
    for(int i=0; i < nums; i++){
      arr[i] = sc.nextInt();
    }

    resList = findDuplicates(arr);
    System.out.println(Arrays.toString(resList.toArray()));

  }

  public static List<Integer> findDuplicates(int[] arr) {
    int nums = arr.length;

    List<Integer> resList = new ArrayList<>();
    for (int i = 0; i < arr.length; i++) {
      //System.out.println(arr[(arr[i] - 1) % nums] );
      int index = Math.abs(arr[i]) - 1;
      if (arr[index] < 0) {
        resList.add(index + 1);
      }
      arr[index] = -arr[index];
    }
    return resList;
  }
}