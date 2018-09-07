
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;


public class HR_Algo_Sort_LillyHomeWork {

  // Complete the lilysHomework function below.
  static int lilysHomework(int[] original) {
    // Preprocessing stage:
      // Generate a Map with:

      /*     keys : values from input list
             values : indexes from the input list
       */
      Map<Integer, Integer> map = new HashMap<Integer, Integer>();
      for(int i=0; i < original.length; i++){
        map.put(original[i], i);
      }

      // back up copy of the hashMap
      Map<Integer, Integer> copy = new HashMap<>();
      for(Map.Entry<Integer, Integer> entry : map.entrySet()){
        copy.put(entry.getKey(), entry.getValue());
      }

    // Generate a copy of sorted input list
    int[] sortedCopy = new int[original.length];
    System.arraycopy(original, 0 , sortedCopy, 0 ,original.length);
    Arrays.sort(sortedCopy);

    //System.out.println("Sorted Copy:" + Arrays.toString(sortedCopy));
    int val1 = process(original, sortedCopy, map);

    //Collections.reverse(Arrays.asList(sortedCopy));
    sortedCopy = reverseArray(sortedCopy);

    //System.out.println("reversed Sorted Copy:" + Arrays.toString(sortedCopy));
    int val2 = process(original, sortedCopy, copy);
    //System.out.println();
    //System.out.println("val1=" + val1 + ", val2=" + val2);
    return Math.min(val1, val2);
  }

  private static int process(int[] original, int[] sortedCopy, Map<Integer, Integer> map) {

    // Compare OrigVal (val from original Arr) to SortedVal (val from sorted Arr)
    // if different,
    //      a. increment counter
    //      b. find index of the sortedVal in the original Array.
    //      c. swap original Val and sortedVal in the original array.
    //      d. update the index of the original val of the original array.
    int counterSwap = 0;

    for(int i = 0; i < original.length; i++){
      if(original[i] != sortedCopy[i]){
        int sortedVal = sortedCopy[i];
        int originalVal = original[i];
        int indexSortedVal  = map.get(sortedVal);

        // swap
        int temp = originalVal;
        original[i] = sortedVal;
        original[indexSortedVal] = temp;

        // update the index of the original val of the original array
        map.put(originalVal, indexSortedVal);
        counterSwap++;
      }
    }
    return counterSwap;
  }

  private static int[] reverseArray(int[] original){
    for(int i = 0; i < original.length / 2; i++){
      int temp = original[i];
      original[i] = original[original.length - 1 - i];
      original[original.length - 1 - i] = temp;
    }
    return original;
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main() throws IOException {
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("t.txt"));

    int n = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    int[] arr = new int[n];

    String[] arrItems = scanner.nextLine().split(" ");
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int i = 0; i < n; i++) {
      int arrItem = Integer.parseInt(arrItems[i]);
      arr[i] = arrItem;
    }


    int result = lilysHomework(arr);


    System.out.println(result);
    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedWriter.close();

    scanner.close();
  }
}

