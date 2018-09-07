/**
 * Created by sjeon on 4/19/2018.
 */
public class ImplementQueue {
    static int begin = 0;
    static int end = 0;
    static int[] arr = new int[9999];

    public static void push(int num){
        arr[end] = num;
        end++;
    }

    public static int pop(){
        begin++;
        return arr[begin-1];
    }
}
