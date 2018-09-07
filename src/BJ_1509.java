import java.util.Arrays;

public class BJ_1509 {
  public static void main(){

  }

  private static int minSubPalins(String str){
    // make c[s][e]  where
    /**
     *  c[s][e] returns either true of false if
     *  substring with index s~e is a palindrome
     *
     *  s = start index of a palindrome
     *  e = end index of a palindrome
     *
     *  c[s][e] where s == e is always true   (palindrome length of 1)
     *  c[s][e] where s + 1 = e && str(s) == str(e) is always true
     *     (palindrome length of 2 with same two letters)
     *
     *  c[s][e] of length of 3 or more is true if and only if
     *     str(s) == str(e) && c[s+1][e-1] is true.*
     *
     *  consider string     ------  |||||  //////      \\\\\\\\\\
     *               index  0                   j-1    j        i
     *
     *  let d[i] = min # of sub-palindromes in a string str, up until the ith index.
     *
     *  d[i] =  min (d[j-1])  +  1   where   c[j][i] == true;   0 <= j <= i,  i < str.length
     *
     *  where N is the length of the str,
     *  for every i-th index,  j has to be found,  =  O(N^2)
     *  for c[j][i],   it is O(1),  if the preprocessing is done  O(N^2)
     *  so the time complexity will be =  O(N^2)
     *
     */
    boolean[][] isPalin = new boolean[str.length()][str.length()];

    // subString of length 1  == palindrome
    for(int s = 0; s < str.length(); s++){
      isPalin[s][s] = true;
    }

    // subString of length 2 of same letter == palindrome
    for(int start = 0; start < str.length() - 1; start++){
      int end = start + 1;
      if(str.charAt(start) == str.charAt(end)){
        isPalin[start][end] = true;
      }
    }

    // for subString length 3 ~~ str.length()
    for(int len = 3; len < str.length(); len++){
      for(int start = 0; start <  str.length() - len ; start++ ){
        int end = start + len - 1;
        if(str.charAt(start) == str.charAt(end)
                && isPalin[start + 1][end - 1]){
          isPalin[start][end] = true;
        }
      }
    }

    int[] minPalinNums = new int[str.length()];
    Arrays.fill(minPalinNums, -1);
    minPalinNums[0] = 1;

    for(int lastPalEnd = 0; lastPalEnd < str.length() - 1; lastPalEnd++){
      minPalinNums[lastPalEnd] = -1;
      int minNums = Integer.MAX_VALUE;
      for(int lastPalStart = 0; lastPalStart <= lastPalEnd; lastPalStart++){
        if(isPalin[lastPalStart][lastPalEnd]){
          if(minPalinNums[lastPalEnd] == -1 ||
                  minPalinNums[lastPalStart] > (minPalinNums[lastPalStart - 1] + 1))
          Math.min( minNums, minPalinNums[lastPalStart - 1] );
        }
        minPalinNums[lastPalStart] = + 1;
      }
    }
    return -1;
  }
}
