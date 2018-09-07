/**
 * Created by sjeon on 4/2/2018.
 */

import java.util.Scanner;

public class OneTwoThreeProblem {

    public static void solve(){
        Scanner sc = new Scanner(System.in);
        int tcNum = sc.nextInt();


        for(int i = 0; i < tcNum; i++){
            int num = sc.nextInt();
            int[] ways = new int[Math.max((num + 1), 4)];
            ways[1] = 1;
            ways[2] = 2;
            ways[3] = 4;
            System.out.println(calc(num, ways));
        }
    }

    // TOP DOWN, recursive
    private static int calc(int num, int[] ways) {
        if(num <= 3){
            return ways[num];
        }

        if(ways[num] > 0){
            return ways[num];
        }

        ways[num] = calc(num - 1, ways) + calc(num - 2, ways) + calc(num - 3, ways);
        return ways[num];
    }
}
