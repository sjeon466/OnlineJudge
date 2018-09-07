public class BJ_Sort {
  public static void main() {
    int[] arr = new int[50];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = (int) (Math.random() * 50);
    }
    System.out.println("Before Sort:  ");
    printArray(arr);
    System.out.println();

    System.out.println("After Merge Sort: ");
    sort(arr);
    printArray(arr);
  }

  public static void printArray(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
  }

  public static void quickSort(){

  }















  public static void sort(int arr[]){
    mergeSort(arr, 0,arr.length-1);
  }

  public static int[] mergeSort(int[] arr, int lo, int hi) {
    if (lo >= hi) {
      return arr;
    }
    int mid = lo + (hi - lo) / 2 ;
    arr = merge(mergeSort(arr, lo, mid), mergeSort(arr, mid + 1, hi));
    return arr;
  }

  public static int[] merge(int[] arr1, int[] arr2) {
    int[] merged = new int[arr1.length + arr2.length];
    int indexArr1 = 0;
    int indexArr2 = 0;
    for (int i = 0; i < merged.length; i++) {
      if (indexArr1 >= arr1.length) {
        merged[i] = arr2[indexArr2];
        indexArr2++;
      } else if (indexArr2 >= arr2.length) {
        merged[i] = arr2[indexArr1];
        indexArr1++;
      } else if (arr1[indexArr1] < arr2[indexArr2]) {
        merged[i] = arr1[indexArr1];
        indexArr1++;
      } else if (arr1[indexArr1] >= arr2[indexArr2]) {
        merged[i] = arr1[indexArr1];
        indexArr1++;
      }
    }
    return merged;
  }
}
