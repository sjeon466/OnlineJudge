import java.util.Arrays;
import java.util.Scanner;

public class BJ_2240 {
  static int timeGiven;
  static int maxMoves;
  static int[][] memoi;
  static int[] applePositions;
  public static void main(){
    Scanner sc = new Scanner(System.in);
    timeGiven = sc.nextInt();
    maxMoves = sc.nextInt();
    applePositions = new int[timeGiven + 1];
    for(int i = 1; i <= timeGiven; i++){
      applePositions[i] = sc.nextInt();
    }

    memoi = new int [timeGiven + 1][maxMoves + 1];
    for(int[] curRow : memoi){
      Arrays.fill(curRow, -1);
    }

    System.out.println(Math.max( go(0, 0) , go(0, 1)));
  }

  private static int go(int curTime, int curMove) {
    if(curTime == timeGiven + 1 && curMove <= maxMoves) return 0;
    if(curMove > maxMoves) return 0;

    if(memoi[curTime][curMove] != -1){
      return memoi[curTime][curMove];
    }

    int curTreePos = curTime % 2 + 1;
    memoi[curTime][curMove] = Math.max(  go(curTime + 1, curMove + 1),
                                          go(curTime + 1, curMove)) +
                                              curTreePos ==  applePositions[curTime] ? 1 : 0;
    return memoi[timeGiven][maxMoves];
    // if moved for the next sec     // if not moved for the next sec

    // is current apple obtainable
    // curmove = 0   -> pos 1
    // curmove = 1   -> pos 2
    // curmove = 2   -> pos 1
    // curmove = 3   -> pos 2
  }
}
