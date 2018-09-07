import java.lang.reflect.Array;
import java.util.*;

public class BJ_9019 {
  static final int MAX_VAL = 10000;
  static boolean[] visited = new boolean[MAX_VAL + 1];
  static int[] distArr = new int[MAX_VAL + 1];
  static int[] operationDoneAtNum = new int[MAX_VAL + 1];
  static int[] beforeNumArr = new int[MAX_VAL + 1];
  static Queue<Integer> pathQueue = new LinkedList<>();

  static List<ComputeCommand> commands = new ArrayList<ComputeCommand>(
          Arrays.asList(new ComputeDCommand(), new ComputeSCommand(), new ComputeLCommand(), new ComputeRCommand())
  );

  public static void main(){
    test(1000);
    Scanner sc = new Scanner(System.in);
    int numTCs = sc.nextInt();
    //System.out.println();
    while(numTCs-- > 0){
      System.out.println(calcDSLR(sc.nextInt(), sc.nextInt()));

      Arrays.fill(visited,false);
      Arrays.fill(distArr, 0);
      Arrays.fill(operationDoneAtNum,'\u0000'  );
      Arrays.fill(beforeNumArr, 0);
      pathQueue = new LinkedList<>();
    }
  }

  private static void test(int num) {
    System.out.println(computeD(num));
    System.out.println(computeS(num));
    System.out.println(computeL(num));
    System.out.println(computeR(num));
  }

  private static String calcDSLR(int startNum, int destNum){
    pathQueue.offer(startNum);
    visited[startNum] = true;
    distArr[startNum ] = 0;
    beforeNumArr[startNum] = -1;
    // no need to update beforeNumArr[startNum] AND operationDoneAtNum[startNum] yet.

    while(!pathQueue.isEmpty()){
      int curPosition = pathQueue.poll();

      if(curPosition == destNum){
        return computePathString(startNum, destNum);
      }

      // dest pos not reached yet, keep adding the 4 options, if possible
      for(ComputeCommand command : commands){
        command.compute(curPosition);
      }
    }
    return "NOT POSSIBLE";
  }

  public interface ComputeCommand{
    void compute(int curPosition);
  }

  public static class ComputeDCommand implements  ComputeCommand{
    public void compute(int curPosition){
      int computed = computeD(curPosition);
      if(!visited[computed]){
        pathQueue.add(computed);
        visited[computed] = true;
        operationDoneAtNum[computed] = 'D';
        beforeNumArr[computed] = curPosition;
      }
    }
  }

  public static class ComputeSCommand implements  ComputeCommand{
    public void compute(int curPosition){
      int computed = computeS(curPosition);
      if(!visited[computed]){
        pathQueue.add(computed);
        operationDoneAtNum[computed] = 'S';
        beforeNumArr[computed] = curPosition;
        visited[computed] = true;
      }
    }
  }

  public static class ComputeLCommand implements ComputeCommand{
    public void compute(int curPosition){
      int computed = computeL(curPosition);
      if(!visited[computed]){
        pathQueue.add(computed);
        operationDoneAtNum[computed] = 'L';
        beforeNumArr[computed] = curPosition;
        visited[computed] = true;
      }
    }
  }
  public static class ComputeRCommand implements  ComputeCommand{
    public void compute(int curPosition){
      int computed = computeR(curPosition);
      if(!visited[computed]){
        pathQueue.add(computed);
        operationDoneAtNum[computed] = 'R';
        beforeNumArr[computed] = curPosition;
        visited[computed] = true;
      }
    }
  }

  private static String computePathString(int startNum, int destNum) {
    StringBuilder sb = new StringBuilder();
    int curPos = destNum;
    while(curPos != startNum){

      sb.append((char)operationDoneAtNum[curPos]);
      curPos = beforeNumArr[curPos];
    }
    return sb.reverse().toString();
  }

  private static int computeD(int startNum){
    int computedNum = startNum * 2 % 10000;
    return computedNum;
  }

  private static int computeS(int startNum){
    //int computedNum = (startNum == 0) ? 9999 : startNum - 1;
    int computedNum = startNum - 1;
    if(computedNum == -1) computedNum = 9999;
    return computedNum;
  }

  private static int computeL(int startNum){  //1234
    int leftMostNum = startNum / 1000;      // 1
    int remainder = startNum % 1000;        // 234
    return remainder * 10 + leftMostNum;    // 2340 + 1
    //2341
  }

  private static int computeR(int startNum){  //1234
    int rightMostNum = startNum % 10;          // 4
    int remainder = startNum / 10;            //  123
    return remainder + (rightMostNum * 1000);   // 4123
  }
}
