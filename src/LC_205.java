import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class LC_205 {
  public static void main(){
    Scanner sc = new Scanner(System.in);
    String str1 = sc.next();
    String str2 = sc.next();
    //System.out.println("str1 = " +  str1  + ", str2 = " + str2);
    LC_205 l = new LC_205();
    System.out.println(l.isIsomorphic(str1, str2));
  }

  public boolean isIsomorphic(String str1, String str2) {
    boolean isIso = false;
    if(str1 == null || str2 == null
            || str1.length() != str2.length()) return false;

    int[] str1_ascii = new int[256];
    int[] str2_ascii = new int[256];

    for(int i=0; i < str1.length(); i++){
      char c1 = str1.charAt(i);
      char c2 = str2.charAt(i);

      if(str1_ascii[c1] != str2_ascii[c2]){
        return false;
      }else{
        str1_ascii[c1]++;
        str2_ascii[c2]++;
      }
    }
    return true;
  }

  public boolean isIsomorphic2(String str1, String str2) {
    boolean isIso = true;
    if(str1 == null || str2 == null
            || str1.length() != str2.length()) return false;

    Map<Character, Character> map = new HashMap<Character, Character>();
    for(int i=0; i < str1.length(); i++){
      char curChar1 = str1.charAt(i);
      char curChar2 = str2.charAt(i);
      if(map.containsKey(curChar1)){
        if(curChar2 != map.get(curChar1)){
          isIso = false;
          break;
        }
      }else{
        if(map.containsValue(curChar2)){
          isIso = false;
          break;
        }
        map.put(curChar1, curChar2);
      }
    }
    return isIso;
  }
}
