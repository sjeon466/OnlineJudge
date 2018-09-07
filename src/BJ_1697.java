import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ_1697 {
  public static void main(){
    Scanner sc = new Scanner(System.in);
    int startPos = sc.nextInt();
    int destPos = sc.nextInt();

    BJ_1697 l = new BJ_1697();
    System.out.println(l.calcMinTime(startPos,destPos));

  }

/*  class PosTime{
    int pos;
    int time;
    public PosTime(int pos, int time){
      this.pos = pos;
      this.time = time;
    }
  }*/

  private int calcMinTime(int startPosition, int destPosition){
    boolean[] visited = new boolean[100000 + 1];
    int[] minTimeHistory = new int[100000 + 1];

    Queue<Integer> visitQueue = new LinkedList<>();

    visitQueue.offer(startPosition);
    visited[startPosition] = true;
    minTimeHistory[startPosition] = 0;

    while(!visitQueue.isEmpty()){
      int curPos = visitQueue.poll();

      if(curPos == destPosition){
        return minTimeHistory[curPos];
      }

      //dest not found keep checking for possible next pos
      if(curPos + 1 <= 100000 && !visited[curPos + 1 ]){
        visitQueue.offer(curPos + 1);
        visited[curPos + 1] = true;
        minTimeHistory[curPos + 1] = minTimeHistory[curPos] + 1;
      }

      if(curPos * 2 <= 100000 && !visited[curPos * 2]){
        visitQueue.offer(curPos * 2);
        visited[curPos * 2] = true;
        minTimeHistory[curPos * 2] = minTimeHistory[curPos] + 1;
      }

      if(curPos - 1 >= 0 && !visited[curPos - 1]){
        visitQueue.offer(curPos - 1);
        visited[curPos - 1] = true;
        minTimeHistory[curPos - 1] = minTimeHistory[curPos] + 1;
      }
    }
    // destPosition not found.
    return -1;
  }
}
