import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class BJ_11729 {
  private static Scanner sc = new Scanner(System.in);
  private static List<Stack<Integer>> listStacks = new ArrayList<>(4);
  private static Stack<Integer> stk1 = new Stack<>();
  private static Stack<Integer> stk2 = new Stack<>();
  private static Stack<Integer> stk3 = new Stack<>();

  public static void main(){
    int numDiscs = sc.nextInt();

    int numMoves = 0;
    for(int i = numDiscs; i >= 1; i--){
      stk1.push(i);
    }
    listStacks.add(null);
    listStacks.add(1, stk1);
    listStacks.add(2, stk2);
    listStacks.add(3, stk3);
    StringBuilder sb = new StringBuilder();

    solve2(numDiscs, 1, 3, sb);
    System.out.println(sb.toString());
  }

  private static void solve2(int biggestDiskToMove, int sourceStackNum, int destStackNum, StringBuilder sb){
    if(biggestDiskToMove == 0) return;
    solve2(biggestDiskToMove -  1, sourceStackNum, 6 - sourceStackNum - destStackNum, sb);
    sb.append(sourceStackNum + " " + destStackNum + "\n");
    solve2(biggestDiskToMove - 1, 6 - sourceStackNum - destStackNum, destStackNum, sb);
  }

  private static void solve(int biggestDiskToMove, int sourceStackNum, int destStackNum){
    if(biggestDiskToMove == 0) return;
    Stack<Integer> sourceStk = listStacks.get(sourceStackNum);
    Stack<Integer> destStk = listStacks.get(destStackNum);
    int thirdStackNum = 6 - sourceStackNum - destStackNum;
    solve(biggestDiskToMove - 1,  sourceStackNum, thirdStackNum);
    //destStk.push(sourceStk.pop());
    System.out.printf("%d %d", sourceStackNum, destStackNum);
    System.out.println();
    solve(biggestDiskToMove - 1, thirdStackNum, destStackNum);
  }
}
