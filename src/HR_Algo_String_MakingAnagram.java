import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class HR_Algo_String_MakingAnagram {

  // Complete the makingAnagrams function below.
  static int makingAnagrams(String s1, String s2) {
    int commonLetterCount = 0;
    int[] arr1 = convertToAlphaArray(s1);
    int[] arr2 = convertToAlphaArray(s2);

    for(int i=0; i < 26; i++){
      if(arr1[i] != 0 && arr2[i] != 0){
        commonLetterCount += Math.min(arr1[i], arr2[i]);
      }
    }
    return (s1.length() - commonLetterCount) + (s2.length() - commonLetterCount);
  }

  static int[] convertToAlphaArray(String str){
    int[] alphaArr = new int[26];
    for(char curChar : str.toCharArray()){
      alphaArr[curChar - 'a']++;
    }
    return alphaArr;
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main() throws IOException {
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output.txt"));

    String s1 = scanner.nextLine();

    String s2 = scanner.nextLine();

    int result = makingAnagrams(s1, s2);
    System.out.println(result);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedWriter.close();

    scanner.close();
  }
}
