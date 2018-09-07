import java.util.Scanner;

public class LC_796 {
  public static void main(){
    Scanner sc = new Scanner(System.in);

    String strA  = sc.next();
    String strB = sc.next();

    LC_796 l = new LC_796();
    System.out.println(l.rotateString(strA, strB));

  }

  public boolean rotateString(String strA, String strB) {
      return strA.length() != strB.length() ? false : (strA + strA).contains(strB);
  }
}
