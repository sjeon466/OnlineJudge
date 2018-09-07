/**
 * Created by sjeon on 3/29/2018.
 */

import java.util.Scanner;

public class Two_CalculateYear {
    public static void solve(){

        Scanner sc = new Scanner(System.in);
        int E = sc.nextInt();
        int S = sc.nextInt();
        int M = sc.nextInt();
        //System.out.println(E + " " + S + " " + M);
        int e = 1; int s =1; int m =1;
        int myYear = 1;
        while(!((E == e) && (S == s) && (M == m))){
            //System.out.print("333333");
            e++;
            s++;
            m++;
            if(e == 16) e = 1;
            if(s == 29) s = 1;
            if(m == 20) m = 1;
            myYear++;
        }
        System.out.println(myYear);
    }
}
