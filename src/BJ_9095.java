import java.util.Scanner;

public class BJ_9095 {
  public static void main(){
    Scanner sc = new Scanner(System.in);
    int targetNum = sc.nextInt();
    System.out.println(go(0, 0, targetNum));
  }

  private static int go(int curCount, int curSum, int targetNum) {
    if(curSum > 10) return  0;
    if(curSum > targetNum) return 0;
    if(curSum == targetNum) return 1;

    int now = 0;
    for(int i = 1; i <= 3; i++){
      now += go(curCount + 1, curSum + i, targetNum);
    }
    return now;
  }
}
