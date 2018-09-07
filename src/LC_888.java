import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class LC_888 {
  public static void main(){
    Scanner sc = new Scanner(System.in);

    int numA = sc.nextInt();
    int[] arrA = new int[numA];
    int numB = sc.nextInt();
    int[] arrB = new int[numB];

    for(int i = 0; i < numA; i++){
      arrA[i] = sc.nextInt();
    }
    for(int i = 0; i < numB; i++){
      arrB[i] = sc.nextInt();
    }

    LC_888 l = new LC_888();
    System.out.println(Arrays.toString(l.fairCandySwap(arrA, arrB)));
  }

  public int[] fairCandySwap(int[] arrA, int[] arrB) {
    int sumA = 0;
    int sumB = 0;
    for(int i = 0; i < arrA.length; i++){
      sumA += arrA[i];
    }

    for(int i = 0; i < arrB.length; i++){
      sumB += arrB[i];
    }

    Set<Integer> setA = new HashSet<Integer>();
    for(int a : arrA){
      System.out.println("putting in " + (2 * a));
      setA.add(2*a);
    }

    int[] ans = new int[2];
    for(int b : arrB){
      int doubleA = sumA - sumB + 2 * b;
      if(setA.contains(doubleA)){
        ans[0] = doubleA / 2;
        ans[1] = b;
      }
    }
    return ans;
  }
}
