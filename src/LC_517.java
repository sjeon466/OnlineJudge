import java.util.Arrays;
import java.util.Scanner;

public class LC_517 {

  public static void main(){
    LC_517 l = new LC_517();
    Scanner sc = new Scanner(System.in);
    int numArr = sc.nextInt();
    int[] arr = new int[numArr];
    for(int i = 0; i < numArr; i++){
      arr[i] = sc.nextInt();
    }

    System.out.println(l.findMinMoves(arr));
  }
  public int findMinMoves(int[] machines) {
    if(machines == null || machines.length == 0) return -1;

    int sum = 0;
    for(int i = 0; i < machines.length; i++){
      sum += machines[i];
    }

    if(sum % machines.length != 0) return -1;

    int ave = sum / machines.length;
    System.out.println(ave);

    int[] referenceVals = new int[machines.length];
    int[] forwardCumuls = new int[machines.length];
    int[] decisions = new int[machines.length];
    // -1 for left +1 for right

    forwardCumuls[0] = machines[0];
    referenceVals[0] = ave;

    for(int i = 1; i < forwardCumuls.length; i++){
      forwardCumuls[i] = machines[i] + forwardCumuls[i-1];
      referenceVals[i] = ave * (i+1);
    }
    System.out.println(Arrays.toString(machines));
    System.out.println(Arrays.toString(forwardCumuls));
    System.out.println(Arrays.toString(referenceVals));



    boolean allEven = false;
    int moveCount = 0;

    while(!allEven){
      allEven = true;

      // for each machine, decide whether to move laundry to left or right
      for(int i = 0; i < machines.length; i++){
        //only take an action for the machine is the ref val is off
        if(machines[i] != referenceVals[i]){
          allEven = false;
          if(i != 0 && forwardCumuls[i] < referenceVals[i] && machines[i] != 0){
            decisions[i] = -1;
          }
          if(i != machines.length-1 && forwardCumuls[i] > referenceVals[i] && machines[i] != 0){
            decisions[i] = 1;
          }
        }
      }
      if(!allEven){
        moveCount++;

        //make moves for machine(s)
        for(int i = 0; i < machines.length; i++){
          if(decisions[i] == 1){
            machines[i]--;
            machines[i+1]++;
          }
          if(decisions[i] == -1){
            machines[i]--;
            machines[i-1]++;
          }
        }
      }
    }
    return moveCount;
  }


}
