import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class BJ_1541 {
  //Scanner sc = new Scanner(System.in);
  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  public static void main() throws IOException {
    String str = br.readLine();
    //str.replaceFirst("^/", "");
    String[] numsStr = str.split("[+]|[-]");
    //str.replaceFirst("^/", "");
    String[] operatorStr = str.split("\\d+");
    String[] splitByNeg = str.split("-");
    String posNumsStr = splitByNeg[0];
    String[] posNums = str.split("-")[0].split("\\+");
    int posSum = 0;
    for(int i=0; i < posNums.length; i++){
      posSum += Integer.parseInt(posNums[i]);
    }


    operatorStr = Arrays.copyOfRange(operatorStr, 1, operatorStr.length);

    int minSum = Integer.parseInt(numsStr[0]);
    boolean minusFound = false;

    for(int i=1; i<numsStr.length; i++){
      if(operatorStr[i-1].equals("-")){
        minusFound = true;
      }
      if(minusFound){
        minSum -= Integer.parseInt(numsStr[i]);
      }else{
        minSum += Integer.parseInt(numsStr[i]);
      }
    }
    System.out.println(minSum);
  }
}
