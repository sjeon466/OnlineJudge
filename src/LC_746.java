import java.util.Arrays;
import java.util.Scanner;

public class LC_746 {
  public static void main(){
    Scanner sc = new Scanner(System.in);
    int numStairs = sc.nextInt();
    int[] stairs = new int[numStairs];
    for(int i = 0; i < numStairs; i++){
      stairs[i] = sc.nextInt();
    }
    LC_746 l = new LC_746();
    System.out.println(l.minCostClimbingStairs(stairs));
  }

  public int minCostClimbingStairs(int[] cost) {
    if(cost == null || cost.length == 0) return 0;

    int[] d = new int[cost.length];

    // take care of length 1 and 2 scenario
    if(d.length == 1 || d.length == 2){
      return 0;
    }

    // scenario 1
    // start from index 0
    d[0] = cost[0];
    d[1] = cost[0] + cost[1];
    for(int i = 2; i < d.length; i++){
      d[i] = Math.min(d[i-1], d[i-2]) + cost[i];
    }
    int scenarioOne = Math.min(d[d.length-1], d[d.length-2]);

    // scenario 2
    // start from index 1
    Arrays.fill(d, 0);
    d[0] = cost[1];
    d[1] = cost[1];
    for(int i = 2; i < d.length; i++){
      d[i] = Math.min(d[i-1], d[i-2]) + cost[i];
    }
    int scenarioTwo = Math.min(d[d.length-1], d[d.length-2]);

    return Math.min(scenarioOne, scenarioTwo);
  }
}
