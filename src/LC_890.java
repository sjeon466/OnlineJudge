import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class LC_890 {
  public static void main(){
    /*
    s = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb"
    Output: ["mee","aqq"]
    */
    LC_890 l = new LC_890();
    Scanner sc = new Scanner(System.in);
    int numWords = sc.nextInt();
    String[] words = new String[numWords];
    for(int i = 0; i < words.length; i++){
      words[i] = sc.next();
    }

    String pattern = sc.next();
   // System.out.println(Arrays.toString(words));
    //System.out.println(pattern);
    System.out.println(Arrays.toString(l.findAndReplacePattern(words, pattern).toArray()));
  }

  public List<String> findAndReplacePattern(String[] words, String pattern) {

     /*
    s = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb"
    Output: ["mee","aqq"]
    */

    List<String> res = new ArrayList<>();
    Map<Character, Character> wordToPattern = new HashMap<>();
    Map<Character, Character> patternToWord = new HashMap<>();

    for(String word : words){

      if(word.length() != pattern.length()) continue;
      for(int i = 0 ; i < word.length(); i++) {
        // mee    abb
        if (wordToPattern.getOrDefault(word.charAt(i), pattern.charAt(i)) != pattern.charAt(i)
                || patternToWord.getOrDefault(pattern.charAt(i), word.charAt(i)) != word.charAt(i)) {
          break;
        }
      }
      res.add(word);
    }
    return res;
  }
}
