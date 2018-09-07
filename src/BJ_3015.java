import java.util.Scanner;
import java.util.Stack;

public class BJ_3015 {
  public static void main(){
    Scanner sc = new Scanner(System.in);
    int numPpl = sc.nextInt();
    int[] heights = new int[numPpl];

    for(int i = 0; i < numPpl; i++){
      heights[i] = sc.nextInt();
    }
    System.out.println(calcPairs(heights));
  }

  private static long calcPairs(int[] heights) {
    Stack<Integer> stk = new Stack<>();
    long count = 0;
    for(int i = 0 ; i < heights.length; i++){

      // taller (next guy) found.
      // curGuy cannot see the people behind the taller (next) guy.
      // pop the curGuy
      // pop until empty or taller than next guy is found in the stack.
      // the taller guy may be able to see people behind the (next) guy.

      // find the num combo with current ith vs. everyone before the current ith person.
      int curHeight = heights[i];
      //int curCount = i;

      while(!stk.isEmpty() && stk.peek() < curHeight){
        stk.pop();
        count++;
      }

      if(!stk.isEmpty()){
        count++;
      }
      stk.push(i);
    }
    return count;
  }

}
