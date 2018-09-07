import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class HR_Algo_String_Palin_Index {

  static int palinDromeIndex(String str){
    int fixIndex = -1;
    int left = 0;
    int strLen = str.length();
    int right = strLen - 1;

    while(left < right){
      if(str.charAt(left) != str.charAt(right)){
        break;
      }
      left++;
      right--;
    }

    int leftFlag = left;
    int rightFlag = right;

    while(left < right){
      if(str.charAt(left) != str.charAt(right - 1)){
        fixIndex = leftFlag;
        break;
      } else{
        fixIndex = rightFlag;
      }
      left++;
      right--;
    }
    return fixIndex;
  }


  // Complete the palindromeIndex function below.
  static int palindromeIndex(String str) {
    int fixCount = 0;
    int fixIndex = -1;
    int left = 0;
    int right = str.length() - 1;
    int strLen = str.length();

    if(strLen == 1 || strLen == 0) return -1;

    while(left < right){
      if(str.charAt(left) != str.charAt(right)){
        //not mathcing, decide which pointer to move
        if(str.charAt(left + 1) == str.charAt(right)){
          fixIndex = left;
          left++;
        }else if(str.charAt(left) == str.charAt(right - 1)){
          fixIndex = right;
          right--;
        }else{
          // both pointers are off, cannot be fixed to make a palindrome.
          //return -1;
          fixIndex+=2;
          return -1;
        }
        fixCount++;
      } else{
        //both pointers are same letters
        left++;
        right--;
      }
    }
    if(fixCount >= 2){
      return -1;
    }
    return fixIndex;
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main() throws IOException {
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output.txt"));

    int q = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int qItr = 0; qItr < q; qItr++) {
      String s = scanner.nextLine();

      int result = palindromeIndex(s);
      System.out.println(result);

      bufferedWriter.write(String.valueOf(result));
      bufferedWriter.newLine();
    }

    bufferedWriter.close();

    scanner.close();
  }
}
