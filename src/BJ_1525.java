import java.util.*;

public class BJ_1525 {
  public static final int[] dc = {0, 0, 1, -1};
  public static final int[] dr = {1, -1, 0, 0};

  public static void main(){
    Scanner sc = new Scanner(System.in);
    //int[][] grid = new int[3][3];
    //for(int r = 0; r < )
    int num = 0;
    for(int i = 0; i < 9; i++){
      int digit = sc.nextInt();
      if(digit == 0) digit = 9;
      num = num * 10 + digit;
    }

    Queue<Integer> numsQueue = new LinkedList<>();
    Map<Integer, Integer> numsVisited = new HashMap<Integer, Integer>();

    numsQueue.add(num);
    numsVisited.put(num , 0);

    int goal = 123456789;

    while(!numsQueue.isEmpty()){
      int curNum = numsQueue.poll();

      //if answer found
      if(curNum == 123456789){
        System.out.println( numsVisited.get(curNum) + 1);
      }

      String curNumStr = String.valueOf(curNum);
     // System.out.println("curNumStr=" + curNumStr);
      int indexOfZero = curNumStr.indexOf('9');

     // System.out.println("indexOfZero = " + indexOfZero);
      int rOfZero = indexOfZero / 3;
      int cOfZero = indexOfZero % 3;
     // System.out.println("cOfZero = " + cOfZero + ", rOfZero = " + rOfZero);

      //ans not found, put in all four possiblities
      for(int i = 0; i < 4; i++){
        int nr = rOfZero + dr[i];
        int nc = cOfZero + dc[i];
        //System.out.println("nr = " + nr + ", nc = " + nc);

        if(0 <= nr && nr < 3 && 0 <= nc && nc < 3){
          StringBuilder next = new StringBuilder(curNumStr);
          // swap chars
          char temp = next.charAt (3 * nr + nc);
          //System.out.println(temp);
          next.setCharAt(3 * nr + nc , next.charAt(3 * rOfZero + cOfZero));
          next.setCharAt(3 * rOfZero + cOfZero, temp);

          int changedNum = Integer.valueOf(next.toString());

          if(!numsVisited.containsKey(changedNum)){
            numsVisited.put(changedNum, numsVisited.get(curNum) + 1);
            numsQueue.offer(changedNum);
          }
        }
      }
      if(numsVisited.containsKey(123456789)){
        System.out.println(numsVisited.get(123456789));
        break;
      }
    }
  }
}
