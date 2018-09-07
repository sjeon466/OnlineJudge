import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;

public class BJ_1541_2 {
  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  public static void main() throws IOException {
    String expression = br.readLine();
    List<Integer> numList = new ArrayList<>();
    List<Integer> operatorList = new ArrayList<>();
    int curNum = 0;
    operatorList.add(1);

    for(int i=0; i< expression.length(); i++){
      char curChar = expression.charAt(i);
      if(curChar == '-' || curChar == '+'){
        if(curChar == '+'){
          operatorList.add(1);
        }else{
          operatorList.add(-1);
        }
        numList.add(curNum);
        curNum = 0;
      }else{
        curNum =  curNum *10 + (curChar - '0');
      }
    }
    numList.add(curNum);
    //System.out.println(Arrays.toString(numList.toArray()));
    //System.out.println(Arrays.toString(operatorList.toArray()));

    int numSum = 0;
    //adding
    boolean negFound = false;
    for(int i=0; i < numList.size(); i++){
      if(operatorList.get(i) == -1){
        negFound = true;
      }
      if(negFound){
        numSum -= (numList.get(i));
      }else{
        numSum += (numList.get(i));
      }
    }
    System.out.println(numSum);
  }
}
