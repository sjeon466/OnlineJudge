import java.util.Scanner;
import java.util.Arrays;

public class BJ_10819 {

  public static void main2(){
    int[] arr = new int[]{1, 4, 8, 10, 20, 15};
    System.out.println(Arrays.toString(arr));
    System.out.println(next_permutation(arr));
    System.out.println(Arrays.toString(arr));
  }

  public static void main(){
    Scanner sc = new Scanner(System.in);
    int numQunt = sc.nextInt();
    int[] numArr = new int[numQunt];

    for(int i = 0; i < numQunt; i++){
      numArr[i] = sc.nextInt();
    }
    Arrays.sort(numArr);


    int answer = 0;
    do{
      int temp = findMaxDiff(numArr);
      answer = Math.max(temp, answer);
    }while(next_permutation(numArr));

    System.out.println(answer);
  }

  private static int findMaxDiff(int[] numArr) {
    int maxDiff = Integer.MIN_VALUE;
    do{
      //System.out.println(Arrays.toString(numArr));
      maxDiff = Math.max(maxDiff, diff(numArr));
    } while(next_permutation(numArr));
    return maxDiff;
  }

  private static int diff(int[] numArr){
    int diff = 0;
    for(int i = 1; i < numArr.length; i++){
      diff += Math.abs(numArr[i-1] - numArr[i]);
    }
    return diff;
  }

  private static boolean next_permutation(int[] arr){
    int i = arr.length - 2;
    while(i >= 0 && arr[i] > arr[i+1]){
      i--;
    }

    // this number is the last permutation
    if(i < 0){
      return false;
    }

    //find j
    int j = arr.length - 1;

    while(arr[i] > arr[j]){
      j--;
    }

    //System.out.println("!!! i= "+ i + ", j= " +j);

    swap(arr, i , j);
    reverse(arr, i + 1);
    return true;
  }

  private static void swap(int[] arr, int i, int j){
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  private static void reverse(int[] arr, int st){
    int end = arr.length - 1;
    while(st < end){
      swap(arr, st, end);
      st++;
      end--;
    }
  }
}
