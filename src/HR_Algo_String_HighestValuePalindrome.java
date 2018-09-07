import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class HR_Algo_String_HighestValuePalindrome {

  // Complete the highestValuePalindrome function below.
  static String highestValuePalindrome(String str, int numDigits, int maxChanges) {
    if(numDigits % 2 == 1) return "-1";
    int[] digitCount = new int[10];
    int digitToChange = -1;
    int pointer = 0;
    StringBuilder sb = new StringBuilder(str);
    int mismatchPair = countMismatchPairs(sb, numDigits);

    if(mismatchPair > maxChanges) return "-1";

    while(maxChanges > mismatchPair && pointer < numDigits / 2){
      digitToChange = findNthDigitToChange(sb, numDigits);
      if(maxChanges > mismatchPair + 2 && str.charAt(str.length() - digitToChange) != 9){
        //Can use two 9's to change two numbers
        sb.setCharAt(digitToChange, '9');
        sb.setCharAt(sb.length()- digitToChange, '9');
        maxChanges -= 2;
        pointer++;
      } else{

      }
    }
    return null;
  }

  private static int countMismatchPairs(StringBuilder sb, int numDigits){
    int mismatchCount = 0;
    for(int i=0; i < sb.length()/2; i++){
      if(sb.charAt(i) != sb.charAt(sb.length()-i-1)) mismatchCount++;
    }
    return mismatchCount;
  }

  private static int findNthDigitToChange(StringBuilder sb, int numDigits){
    for(int i=0; i < numDigits; i++){
      if(sb.charAt(i) - '0' != 9){
        return i;
      }
    }
    return -1;
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main() throws IOException {
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output.txt"));

    String[] nk = scanner.nextLine().split(" ");

    int n = Integer.parseInt(nk[0]);

    int k = Integer.parseInt(nk[1]);

    String s = scanner.nextLine();

    String result = highestValuePalindrome(s, n, k);
    System.out.println(result);

    bufferedWriter.write(result);
    bufferedWriter.newLine();

    bufferedWriter.close();

    scanner.close();
  }
}
