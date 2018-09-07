import java.util.Scanner;
import java.util.Stack;

/**
 * Created by sjeon on 4/19/2018.
 */
public class BakJoon_ParenthesisProblem {
    public static void solve(){
        Scanner sc = new Scanner(System.in);
        int numTC = sc.nextInt();
        for(int i = 0; i < numTC; i++){
            String str = sc.next();
            Stack<Character> stk = new Stack();
            boolean isAns = true;
            for(int k = 0; k < str.length(); k++){
                //Integer.parseInt(Character.toString(str.charAt(k)));
                char c = str.charAt(k);
                if(c == '('){
                    stk.push(')');
                }else if(c == ')'){
                    if(stk.empty()){
                        System.out.println("NO");
                        isAns = false;
                        break;
                    }
                    if(!stk.isEmpty()){
                        if(c != stk.pop()){
                            System.out.println("NO");
                            isAns = false;
                            break;
                        }
                    }
                }
            }
            if(isAns){
                if(!stk.isEmpty()){
                    System.out.println("NO");
                    continue;
                }else{
                    System.out.println("YES");
                    continue;
                }
            }
        }
    }
}
