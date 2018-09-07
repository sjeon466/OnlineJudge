import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class LC_784 {
  public static void main(){
    Scanner sc = new Scanner(System.in);
    String input = sc.next();
    LC_784 l = new LC_784();
    System.out.println(Arrays.toString(l.letterCasePermutation(input).toArray()));
  }

  public List<String> letterCasePermutation(String input) {
   /*
    Pattern numPattern = Pattern.compile("[0-9]");
    Pattern lowerPattern = Pattern.compile("[a-z]");
    Pattern upperPattern = Pattern.compile("[A-Z]");
    */

    //List<StringBuilder> temp = new ArrayList<StringBuilder>();
    List<StringBuilder> results = new ArrayList<>();
    results.add(new StringBuilder());

    for(char c : input.toCharArray()){
      int size = results.size();
      if(Character.isDigit(c)){
        for(StringBuilder sb : results){
          sb.append(String.valueOf(c));
        }
      }else if(Character.isLetter(c)){
        for(int i = 0; i < size; i++){
          results.add(new StringBuilder(results.get(i)));
          results.get(i).append(Character.toLowerCase(c));
          results.get(i+size).append(Character.toUpperCase(c));
        }
      }
    }

    List<String> finalResults = new ArrayList<>();
    for(StringBuilder sb : results){
      finalResults.add(sb.toString());
    }
    return finalResults;
  }
}
