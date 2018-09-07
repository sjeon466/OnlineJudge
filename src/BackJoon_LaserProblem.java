/**
 * Created by sjeon on 4/19/2018.
 */

import java.util.Scanner;
import java.util.Stack;

public class BackJoon_LaserProblem {
    public static void main() {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(countPieces(str));
    }

    public static int countPieces(String str){
        Stack<Integer> stk = new Stack();
        int count = 0;
        for(int i=0; i < str.length(); i++){
            char c = str.charAt(i);
            if(c == '('){
                stk.push(i);
            }else if(c == ')'){
                //Laser
                if(i == stk.peek()+ 1){
                    // Add the size of stack  //remove the front of the laser
                    stk.pop();
                    count += stk.size();
                }else{
                    //End of Stick
                    stk.pop();
                    count++;
                    // Add one
                }
            }
        }
        return count;
    }
}
