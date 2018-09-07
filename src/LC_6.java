import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class LC_6 {
  public static void main(){
    Scanner sc = new Scanner(System.in);
    String str = sc.next();
    int numRows = sc.nextInt();
    LC_6 l = new LC_6();
    System.out.println(l.convert(str, numRows));
  }
  public String convert(String str, int numRows) {
    if(str == null || numRows == 0)return "";
    //if(numRows == 1 ) return str;
    List<StringBuilder> list = new ArrayList<StringBuilder>();

    // initializing the rows of StringBuilder
    for(int i = 0; i < Math.min(numRows, str.length()); i++){
      list.add(new StringBuilder());
    }

    int curRow = 0;
    boolean goingDown = false;

    for(char c : str.toCharArray()){
      list.get(curRow).append(c);
      if(curRow == 0 || curRow == numRows - 1) goingDown = !goingDown;
      curRow += goingDown ? -1 : 1;
    }

    StringBuilder result = new StringBuilder();
    for(int i = 0; i < list.size(); i++){
      result.append(list.get(i));
    }
    return result.toString();
  }
}
