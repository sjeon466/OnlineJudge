import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LC_14 {
  public static void main(){
/*
    Scanner sc = new Scanner(System.in);
    List<String> list = new ArrayList<>();
    while(sc.hasNext()){
      list.add(sc.next());
    }
    String[] strArr = list.toArray(new String[list.size()]);
*/

    LC_14 l = new LC_14();
    //System.out.println(l.longestCommonPrefix(strArr));
    System.out.println(l.longestCommonPrefix(null));
  }


  public String longestCommonPrefix(String[] strs) {
    String sts = " flow";
    String pre = "flower";

    return String.valueOf((sts.indexOf(pre)));
/*    if(strs == null || strs.length == 0) return "";
    String pre = strs[0];
    int i = 1;

    while(i < strs.length){
      while(strs[i].indexOf(pre) != 0){
        pre = pre.substring(0, pre.length()-1);
      }
      i++;
    }
    return pre;*/
  }
}
