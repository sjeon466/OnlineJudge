import java.util.ArrayList;
import java.util.Scanner;

public class BJ_1201 {
  public static void main(){
    Scanner sc = new Scanner(System.in);
    int numLength = sc.nextInt();
    int incSubSQLength = sc.nextInt();
    int decSubSQLength = sc.nextInt();

    if(incSubSQLength + decSubSQLength -1 <= numLength && numLength <= incSubSQLength * decSubSQLength){
      int[] numArr = new int[numLength];
      for(int i=0; i < numLength; i++){
        numArr[i] = i + 1;
      }

      ArrayList<Integer> group = new ArrayList<Integer>();
      group.add(0);
      group.add(decSubSQLength);
      numLength -= decSubSQLength;
      incSubSQLength -= 1;

      int group_size = incSubSQLength == 0 ? 1 : numLength / incSubSQLength;


    }

  }
}
