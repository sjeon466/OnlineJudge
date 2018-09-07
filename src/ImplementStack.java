/**
 * Created by sjeon on 4/19/2018.
 */
public class ImplementStack {
    int[] stack;
    int curSize = 0;
    public ImplementStack(int defaultSize){
         stack = new int[defaultSize];
    }

    public void push(int num){
        stack[curSize] = num;
        curSize++;
    }

    public int pop(){
        if(curSize == 0){
            return Integer.MIN_VALUE;
        } else{
            int retVal = stack[curSize - 1];
            stack[curSize] = 0;
            curSize--;
            return retVal;
        }
    }
}
