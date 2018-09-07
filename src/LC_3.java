
import java.util.*;

public class LC_3 {
  public static void main(){
    Scanner sc = new Scanner(System.in);
    String str = sc.nextLine();

    System.out.println(calcLongestSubString(str));

  }


  private static int calcLongestSubString(String str) {
    if(str == null || str.length() == 0) return 0;
    Map<Character, Integer> map = new HashMap<Character, Integer>();


    int maxLen = 0;
    for(int left = 0, right = 0; right < str.length(); ++right){
      if(map.containsKey(str.charAt(right))){
        //left = Math.max( left , map.get(str.charAt(right)) + 1);
        left = Math.max( left ,  map.get(str.charAt(right)) + 1) ;
      }
      map.put(str.charAt(right), right);
      maxLen = Math.max(maxLen, right - left + 1);
    }

    return maxLen;



    //int left = 0, right = 0, longestLen = 0;

/*    while(left < right && right < str.length()){
      if(! map.containsKey( str.charAt(right) ) ){
        map.put(str.charAt(right), right);
        right++;
        longestLen = Math.max(longestLen, map.size());
      }else{
        while( str.charAt(left) != str.charAt(right) ){
          left++;
          longestLen--;
        }
        left++;
        longestLen--;
      }
    }*/



  }




/*  private static int calcLongestSubString(String str) {
    char[] charArrStr = str.toCharArray();
    int lenStr = str.length();
    int left = 0, right = 1;
    int[] charsCount = new int[128];
    charsCount[charArrStr[0]]++;
    int maxLength = 1;
    int runningLength = 1;

    while(right < lenStr &&  left <= right){
      int curCharVal= charArrStr[right];

      // already exists
      if(charsCount[curCharVal] != 0){
        //until the duplicate is found
        while(charArrStr[left] != curCharVal ){
          runningLength--;
          charsCount[curCharVal]--;
          left++;
        }
        runningLength--;
        charsCount[curCharVal]--;
        left++;
        right++;
      }else{
        runningLength++;
        maxLength = Math.max(runningLength, maxLength);
        charsCount[curCharVal]++;
        right++;
      }
    }
    return maxLength;
  }*/
}
