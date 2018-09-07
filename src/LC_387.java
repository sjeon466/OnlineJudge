import java.util.Scanner;

public class LC_387 {
  public static void main(){
    Scanner sc = new Scanner(System.in);
    System.out.println(firstUniqChar(sc.next()));
  }
  public static int firstUniqChar(String str) {
    int[] charCounter = new int[26];

    for(int i=0; i < str.length(); i++){
      charCounter[str.charAt(i) - 'a']++;
    }

    // find first non-repeating character
    int charIndex = -1;
    for(int i=0; i < str.length(); i++){
      if(charCounter[str.charAt(i) - 'a'] == 1){
        charIndex = i;
        break;
      }
    }
    return charIndex;

/*    // find the index
    int index = -1;
    for(int i=0; i < str.length(); i++){
      if(charVal == str.charAt(i) - 'a') index = i;
    }
    return index;*/
  }
}
