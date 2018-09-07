import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class HR_Algo_Sort_FullCountingSort {

  private static final Scanner scanner = new Scanner(System.in);

  public static void main() {
    int numPairs = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    List<List<String>> myList = new ArrayList<>();

    // creating list
    for(int i=0; i < numPairs; i++){
      myList.add(new ArrayList<String>());
    }

    for (int nItr = 0; nItr < numPairs; nItr++) {
      String[] pair = scanner.nextLine().split(" ");
      int value = Integer.parseInt(pair[0]);
      String word = pair[1];

      if(nItr < (numPairs / 2)){
        myList.get(value).add("-");
      }else{
        myList.get(value).add(word);
      }
    }

    //printing out the list.
    StringBuilder sb = new StringBuilder();
    for(List<String> curList : myList){
      for(String curStr : curList){
        sb.append(curStr + " ");
      }
    }
    sb.deleteCharAt(sb.length()-1);
    System.out.println(sb.toString());
    scanner.close();
  }
}
