import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class HR_Algo_GemStones {

  static int gemStones(String[] stonesArr){
    int numStones = stonesArr.length;
    Set<Character> set = convertToSet(stonesArr[0]);

    for(int i=0; i < numStones; i++){
      set.retainAll(convertToSet(stonesArr[i]));
    }
    return set.size();
  }

  static Set<Character> convertToSet(String stoneStr){
    Set<Character> set = new HashSet<Character>(26);
    for(char curChar : stoneStr.toCharArray()){
      set.add(curChar);
    }
    return set;
  }



  // Complete the gemstones function below.
  static int gemstones2(String[] arr) {
    int numRocks = arr.length;
    int[][] rocksAndMinerals = new int[numRocks][26];

    for(int i=0; i < numRocks; i++){
      String curRock = arr[i];
      for(int j=0; j < curRock.length(); j++){
        int curCharVal = curRock.charAt(j) - 'a';
        rocksAndMinerals[i][curCharVal]++;
      }
    }

    // check each mineral for omnipresence in all the rocks
    int gemCount = 0;
    for(int  i=0; i < 26; i++){
      boolean isGem = true;
      for(int j=0; j < numRocks; j++){
        if(rocksAndMinerals[j][i] == 0) isGem = false;
      }
      if(isGem) gemCount++;
    }
    return gemCount;
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main() throws IOException {
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output.txt"));

    int n = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    String[] arr = new String[n];

    for (int i = 0; i < n; i++) {
      String arrItem = scanner.nextLine();
      arr[i] = arrItem;
    }

    int result = gemStones(arr);
    System.out.println(result);
    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedWriter.close();

    scanner.close();
  }
}
