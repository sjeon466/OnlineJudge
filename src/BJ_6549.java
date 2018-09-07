import java.util.Scanner;
import java.util.Stack;

public class BJ_6549 {
  public static void main(){
    Scanner sc = new Scanner(System.in);

    while (true) {
      int numBars = sc.nextInt();
      if(numBars == 0) break;
      int[] bars = new int[numBars];

      for(int i = 0; i < numBars; i++){
        bars[i] = sc.nextInt();
      }
      System.out.println(maxAreaBars(bars));
    }
  }

  private static int maxAreaBars(int[] bars){
    Stack<Integer> stk = new Stack<Integer>();


    int ans = 0;
    for(int i = 0; i < bars.length; i++){
      int left = i;
      while(!stk.isEmpty() && bars[i] < stk.peek()){
        //int height = bars[stk.pop()];
        int height = bars[stk.peek()];
        stk.pop();
        int width = i;
        if(!stk.empty()){
          width = i - stk.peek() - 1;
        }
        if(ans <  width * height){
          ans = width * height;
        }
      }
      stk.push(i);
    }

    while(!stk.isEmpty()){
      // for all these remaining bars,  their right is at the end.
      // right = bar.length - 1
      int height = stk.peek();
      stk.pop();
      int width = bars.length;
      if(!stk.isEmpty()){
        width = bars.length - stk.peek() - 1;
      }

      if(ans  >  height * width){
        ans = height * width;
      }
    }

    return ans;
  }








  private static int maxAreaBars3(int[] bars) {
    Stack<Integer> stk = new Stack<>();
    int maxArea = -1;
    for(int i = 0; i < bars.length; i++){
      int left = i;

      while(!stk.isEmpty() && bars[stk.peek()] > bars[i]){
        int curHeight = bars[stk.peek()];
        stk.pop();
        int width = i;
        if(!stk.empty()) width = (i - stk.peek() - 1);
        if(maxArea < width * curHeight) maxArea = width * curHeight;
      }



    }

    return -1;
  }

  private static int maxAreaBars2(int[] bars) {
    Stack<Integer> increasingBars = new Stack<>();
    int maxArea = -1;
    for(int i = 0; i < bars.length; i++){
      if(increasingBars.isEmpty()){
        increasingBars.push(i);
      }else{
        // new bar is taller
        if(bars[i] >=  bars[increasingBars.peek()]){
          increasingBars.push(i);
        }else{
          // new bar is smaller
          // calc the max area using curHeight as the highest height.
          int curHeight = bars[increasingBars.pop()];
          int right = i;

          while(!increasingBars.isEmpty() && increasingBars.peek() >= curHeight){
            increasingBars.pop();
          }
          int curArea = increasingBars.isEmpty() ? (right * bars[i]) :
                  bars[i] * ( right -  increasingBars.peek() - 1);
          maxArea = Math.max(maxArea, curArea );
        }
      }
    }
    while(!increasingBars.isEmpty()){

      maxArea = Math.max(maxArea, bars[increasingBars.pop()] * 1);
    }
    return maxArea;
  }


}
