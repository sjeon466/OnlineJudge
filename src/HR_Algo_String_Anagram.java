import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class HR_Algo_String_Anagram {

  static int anagram(String str){
    // compare subStr1 and subStr2
    // duplicate letter found, get rid of that letter in subStr2
    // if a letter in str1 is not found on letter in str2, increase counter by 1
    int lengthStr = str.length();
    if(lengthStr % 2 != 0){
      return -1;
    }else{
      int sizeSubStr = lengthStr / 2;
      String subStr1 = str.substring(0, sizeSubStr);
      String subStr2 = str.substring(sizeSubStr, lengthStr);
      System.out.println("subStr1 = " + subStr1 + ", subStr2 = " + subStr2);

      int count = 0;
      for(int i=0; i < sizeSubStr; i++){
        char curChar = str.charAt(i);
        int index = subStr2.indexOf(curChar);
        if(index == -1){
          count++;
        }else{
          subStr2 = subStr2.substring(0,index) + subStr2.substring(index + 1);
        }
      }
    }

    return -1;
  }

  // Complete the anagram function below.
  static int anagram2(String str) {
    int strLen = str.length();
    // not possible case
    if(strLen == 0 || strLen % 2 == 1){
      //System.out.println("ans = -1");
      return -1;
    }

    int sizeSubString = strLen / 2;
    Map<Character, Integer> firstMap = convertToMap(str.substring(0, sizeSubString));
    Map<Character, Integer> secondMap= convertToMap(str.substring(sizeSubString, strLen));

    Map<Character, Integer> mergedMap = new HashMap<Character, Integer>(firstMap);
    mergedMap.keySet().retainAll(secondMap.keySet());


    // update mergeMap values with lower val
    for(char curChar : mergedMap.keySet()){
      mergedMap.put(curChar, Math.min(firstMap.get(curChar), secondMap.get(curChar)));
    }

    //System.out.println("FirstMap" +  firstMap);
    //System.out.println("SecondMap" +  secondMap);
    //System.out.println("MergedMap" +  mergedMap);

    //add all the values in mergedMap
    int commonCount = 0;
    for(Character curChar : mergedMap.keySet()){
      commonCount += mergedMap.get(curChar);
    }
    //System.out.println("sizeSubString " + sizeSubString + "\n commonCount = " + commonCount + " \n ans = " + (sizeSubString - commonCount));
    return sizeSubString - commonCount;
  }

  static Map<Character, Integer> convertToMap(String str){
    Map<Character, Integer> map = new HashMap<Character, Integer>(26);
    for(char curChar : str.toCharArray()){
      if(map.containsKey(curChar)){
        map.put(curChar, map.get(curChar) + 1);
      }else{
        map.put(curChar, 1);
      }
    }
    return map;
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main() throws IOException {
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output.txt"));

    int q = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int qItr = 0; qItr < q; qItr++) {
      String s = scanner.nextLine();

      int result = anagram(s);
      System.out.println(result);
      bufferedWriter.write(String.valueOf(result));
      bufferedWriter.newLine();
    }

    bufferedWriter.close();

    scanner.close();
  }
}