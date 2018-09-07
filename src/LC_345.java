import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.*;

public class LC_345 {
  public static void main(){
    Scanner sc = new Scanner(System.in);
    String str = sc.next();
    System.out.println(reverseVowels(str));
  }

  public static String reverseVowels(String str) {
    if(str.length() < 2) return str;
    char[] arrChar = str.toCharArray();
    int right = arrChar.length - 1;
    int left = 0;

    while(left < right){
      if(!isVowel(arrChar[left])){
        left++;
      }else{
        while(right != left && !isVowel(arrChar[right])){
          right--;
        }

        char temp = arrChar[left];
        arrChar[left] = arrChar[right];
        arrChar[right] = temp;

        left++;
        right--;
      }
    }


/*    while(left < right) {
      //swap
      if (isVowel(arrChar[left]) && isVowel(arrChar[right])) {
        char temp = arrChar[left];
        arrChar[left] = arrChar[right];
        arrChar[right] = temp;
        right--;
        left++;
      }else if(isVowel(arrChar[left])){
        right--;
      }else if(isVowel(arrChar[right])){
        left++;
      }else{
        right--;
        left++;
      }
    }*/
    return new String(arrChar);
  }

  private static boolean isVowel(char c){
    switch(c){
      case ('a') : return true;
      case ('i') : return true;
      case ('o') : return true;
      case ('u') : return true;
      case ('e') : return true;
      case ('A') : return true;
      case ('I') : return true;
      case ('O') : return true;
      case ('U') : return true;
      case ('E') : return true;
      default: return false;
    }
  }

  public static String reverseVowels2(String str) {
    StringBuilder sb = new StringBuilder(str);
    List<Integer> listVowelIndex = new ArrayList<Integer>();
    Pattern pattern = Pattern.compile("[aioue]");
    Matcher matcher = pattern.matcher(str);

    while(matcher.find()){
      System.out.println("At Index: " + matcher.start() +", Val :"+ String.valueOf(matcher.group()));
      listVowelIndex.add(matcher.start());
    }

    int numVowels = listVowelIndex.size();
    System.out.println(numVowels);
    for(int i=0; i < numVowels / 2; i++){
      char temp1 = sb.charAt(listVowelIndex.get(i));
      sb.setCharAt(listVowelIndex.get(i), sb.charAt(listVowelIndex.get(numVowels-1-i)));
      sb.setCharAt(listVowelIndex.get(numVowels-1-i), temp1);
    }
    return sb.toString();
  }
}
