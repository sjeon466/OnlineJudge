import java.util.Arrays;
import java.util.Scanner;

public class BJ_11728 {
  private static Scanner sc = new Scanner(System.in);
  public static void main() {
    int sizeArrA = sc.nextInt();
    int sizeArrB = sc.nextInt();

    int[] arrA = new int[sizeArrA];
    int[] arrB = new int[sizeArrB];

    generateArrays(arrA, arrB);
/*    System.out.println(Arrays.toString(arrA));
    System.out.println(Arrays.toString(arrB));*/

    int[] merged = merge(arrA, arrB);
    for(int i=0; i < merged.length; i++){
      System.out.print(merged[i] + " ");
    }
  }

  private static int[] merge(int[] arrA, int[] arrB) {
    int sizeArrA = arrA.length;
    int sizeArrB = arrB.length;

    int[] merged = new int[sizeArrA + sizeArrB];

    int pointerArrA = 0;
    int pointerArrB = 0;
    int pointerMerged = 0;

    while(pointerArrA < sizeArrA && pointerArrB < sizeArrB) {
      if (arrA[pointerArrA] < arrB[pointerArrB]) merged[pointerMerged++] = arrA[pointerArrA++];
      else merged[pointerMerged++] = arrB[pointerArrB++];
    }
      // taking care of the left overs
      while(pointerArrA < sizeArrA) merged[pointerMerged++] = arrA[pointerArrA++];
      while(pointerArrB < sizeArrB) merged[pointerMerged++] = arrB[pointerArrB++];

    return merged;
  }

  private static void generateArrays(int[] arrA, int[] arrB) {
    int sizeArrA = arrA.length;
    int sizeArrB = arrB.length;
    for(int i=0; i < sizeArrA; i++){
      arrA[i] = sc.nextInt();
    }

    for(int i=0; i < sizeArrB; i++){
      arrB[i] = sc.nextInt();
    }
  }
}
