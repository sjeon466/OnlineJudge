import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class HK_Algo_TwoLetters {

  // Complete the twoCharaters function below.
  static int twoCharaters(String str) {
    char[][] letterGrid = new char[26][26];
    int[][] valueGrid = new int[26][26];

    for(char curChar : str.toCharArray()){
      // for each character,  update its row and col to represent its char as the last char of the
      // alternating sequence.

      //Note that if the same char is stored in the charGrid, the alternating requirement fails and
      // that combination becomes invalid.


      int curIndex = (int) curChar - 'a';
      for(int i=0; i < 26; i++){
        //update its row

        // if no repetition now, and if not invalid yet
        if(letterGrid[curIndex][i] != curChar && valueGrid[curIndex][i] != -1){
          letterGrid[curIndex][i] = curChar;
          ++valueGrid[curIndex][i];
        }else{
          // same char found (same char repeated, this combination is invalid.)
          valueGrid[curIndex][i] = -1;
        }

        //update its column
        // if no repetition now, and if not invalid yet
        if(letterGrid[i][curIndex] != curChar && valueGrid[i][curIndex] != -1){
          letterGrid[i][curIndex] = curChar;
          ++valueGrid[i][curIndex];
        }else{
          // same char found (same char repeated, this combination is invalid.)
          valueGrid[i][curIndex] = -1;
        }
      }
    }

    int lengthLongestStr = 0;
    for(int r = 0; r < 26; r++){
      for(int c = 0; c < 26; c++){
        if(valueGrid[r][c] > lengthLongestStr){
          lengthLongestStr = valueGrid[r][c];
        }
      }
    }
    if(lengthLongestStr > 1){
      return lengthLongestStr;
    }else {
      return 0;
    }
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main() throws IOException {
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output2.txt"));

    //System.out.println('\u0000');
    int l = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    String s = scanner.nextLine();

    int result = twoCharaters(s);
    System.out.println(result);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedWriter.close();

    scanner.close();
  }
}
