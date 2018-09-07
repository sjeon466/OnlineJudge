import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class LC_448 {
  public static void main(){
    Scanner sc = new Scanner(System.in);
    //List<Integer> resList = new ArrayList<>();
    List<Integer> resList;// = new ArrayList<>();
    int nums = sc.nextInt();
    int[] arr = new int[nums];
    for(int i=0; i < nums; i++){
      arr[i] = sc.nextInt();
    }

    resList = findDisappearedNums(arr);

  }

  private static List<Integer> findDisappearedNums(int[] arr) {
    int nums = arr.length;

    List<Integer> resList = new ArrayList<>();
    for(int i=0; i < arr.length; i++){
      arr[((arr[i]-1) % nums)] += nums;
    }

    for(int i=0; i < arr.length; i++){
      if(arr[i] > nums) resList.add(i);
    }
    return resList;
  }
}