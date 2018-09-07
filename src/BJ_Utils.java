public final class BJ_Utils {
  // Private static instance is created at the time of the class loading
  private static BJ_Utils bjUtils = null;

  // Constructor made private so that no new instance can be created
  private BJ_Utils(){
    throw new AssertionError("Suppress default constructor for non-instantiability");
  }

  // Static method to return the instance to the client
  public static BJ_Utils getInstance(){
    if( bjUtils == null){
      bjUtils = new BJ_Utils();
    }
    return bjUtils;
  }

  // For solving 1080

  public static void print2DArrayAligned(int[][] matrix){
    for(int[] curRow : matrix){
      for(int curVal : curRow){
        System.out.printf("%5d", curVal);
      }
      System.out.println();
    }
  }

  public static boolean AreTwoMatricesSame(int[][] matrixA, int[][] matrixB){
    if(matrixA.length != matrixB.length || matrixA[0].length != matrixB[0].length){
      return false;
    }
    for(int r=0; r < matrixA.length; r++){
      for(int c=0; c < matrixA[0].length; c++){
        if(matrixA[r][c] != matrixB[r][c]){
          return false;
        }
      }
    }
    return true;
  }
  // End For solving 1080

  private static boolean binarySearch(int targetVal,int left, int right, int[] arr){
    while(left <= right){
      int mid = left + (right - left) / 2;
      if(targetVal == arr[mid]){
        return true;
      } else if(targetVal < arr[mid]){
        right = mid - 1;
      }else{
        left = mid + 1;
      }
    }
    return false;
  }

  public static boolean binarySearch(int targetVal, int[] arr){
    return binarySearch(targetVal, 0, arr.length - 1, arr);
  }


  private static void mergeSort(int start, int end, int[] arr){
    // size is 1, divide is done, now conquer
    if(start == end){
      return;
    }
    int mid = start + (end - start) / 2;
    mergeSort(start, mid, arr);
    mergeSort(end, mid + 1, arr);
    merge(start,end, arr);
    return;
  }

  private static void merge(int start, int end, int[] arr) {
    int[] merged = new int[arr.length];
    int mid = start + (end - start) / 2;
    int pointer1 = start;
    int pointer2 = mid + 1;
    int mergedPointer = start;
    while(pointer1 <= mid && pointer2 <= end){
      if(arr[pointer1] < arr[pointer2]) merged[mergedPointer++] = arr[pointer1++];
      else merged[mergedPointer++] = arr[pointer2++];
    }
    while(pointer1 <= mid)  merged[mergedPointer++] = arr[pointer1++];
    while(pointer2 <= end)  merged[mergedPointer++] = arr[pointer2++];

    for(int i = start; i <=end; i++){
      arr[i] = merged[i];
    }

  }
}
