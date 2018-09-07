import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class HR_Algo_Sort_CountingSort2 {

  // Complete the countingSort function below.
  static int[] countingSort(int[] arr) {
    int[] rangeArr = new int[100];
    for(int curVal : arr){
      rangeArr[curVal]++;
    }
    return rangeArr;
  }


  private static void printResultArr(int[] result, BufferedWriter bw) throws IOException {
    for(int i=0; i < result.length; i++){
      if(result[i] == 0) continue;
      for(int j = result[i]; j > 0; j--){
        //System.out.print(i + " ");
        bw.write(i + " ");
      }
    }
  }


  private static final Scanner scanner = new Scanner(System.in);

  public static void main() throws IOException {
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("2.txt"));

    int n = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    int[] arr = new int[n];

    String[] arrItems = scanner.nextLine().split(" ");
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int i = 0; i < n; i++) {
      int arrItem = Integer.parseInt(arrItems[i]);
      arr[i] = arrItem;
    }

    int[] result = countingSort(arr);

    //printResultArr(result);
    //System.out.println(result);
    printResultArr(result, bufferedWriter);
/*    for (int i = 0; i < result.length; i++) {
      bufferedWriter.write(String.valueOf(result[i]));

      if (i != result.length - 1) {
        bufferedWriter.write(" ");
      }
    }*/

    bufferedWriter.newLine();

    bufferedWriter.close();

    scanner.close();
  }

}
