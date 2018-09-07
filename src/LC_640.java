import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LC_640 {
  public static void main(){
    LC_640 l = new LC_640();
    Scanner sc = new Scanner(System.in);
    String str = sc.next();
    System.out.println(l.solveEquation(str));
  }

  public String solveEquation(String equation) {
    int equalIndex = -1;
    int leftTermCount = 0;
    int righTermCount = 0;
    List<Integer> xCoeffOnLeft = new ArrayList<>();
    List<Integer> constantsOnLeft = new ArrayList<>();
    boolean isOnLeft = true;
    boolean curSignPos = true;
    boolean isXTerm = false;


    String coeff = "";

    for(int i = 0; i < equation.length(); i++){
      if(equation.charAt(i) == '='){
        coeff = "";
        isOnLeft = false;
        continue;
      }

      char curChar = equation.charAt(i);
      if(curChar == '+'){
        coeff = "";
        curSignPos = true;
      }else if(curChar == '-'){
        coeff = "";
        curSignPos = false;
      }

      if(curChar <= '0' && curChar <= '9'){
        coeff += curChar;
      }else if(curChar == 'x'){
        int coeffVal = coeff.length() == 0 ?  1 : Integer.valueOf(coeff);
        if(!curSignPos) coeffVal *= -1;
        if(isOnLeft){
          xCoeffOnLeft.add(coeffVal);
        }else{
          xCoeffOnLeft.add(coeffVal * -1);
        }
      }






    }
    return null;
  }
}
