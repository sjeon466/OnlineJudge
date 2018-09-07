import java.util.Arrays;
import java.util.Random;

public class BJ_11004 {

  public static void main(){
    int[] myArr = new int[20];
    randomGenerate(myArr);
    System.out.println(Arrays.toString(myArr));
    System.out.println("After QuickSort");
    quickSort(myArr);
  }

  public static int[] randomGenerate(int[] arr){
    int arrLen = arr.length;
    for(int i=0;i< arrLen; i++){
      Random rand = new Random();
      arr[i] = rand.nextInt(2000);
    }
    return arr;
  }

  public static void quickSort(int[] arr){ quickSort(arr, 0, arr.length-1); }

  private static void swap(int[] arr, int index1, int index2){
    int temp = arr[index1];
    arr[index1] = arr[index2];
    arr[index2] = temp;

  }
    //returns random pivot index between low and high inclusive
  private static int getPivot(int lo, int hi){
    return (int)(Math.random()* (hi-lo)+ 1 ) + lo;
  }


    //moves all n < pivot to left of pivot and all n > pivot
    // to right of pivot, then returns pivot index.
  private static int partition(int[] arr, int lo, int hi){
    swap(arr, lo, getPivot(lo, hi));




    return 0;
  }

  private static void quickSort(int[] arr, int lo, int hi){
    //if there are two or more items to sort
    if(lo < hi){
      long pivot = arr[hi];
      int left =  lo-1;
      int right = hi;
    }

  }
}
