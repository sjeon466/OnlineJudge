/**
 * Created by sjeon on 4/1/2018.
 */
import java.util.Scanner;


public class TwoByN2Problem {
    public static void solve(){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] ways = new int[num + 1];
        ways[0] = 1;
        ways[1] = 1;
        ways[2] = 3;
        System.out.println(calc2(num, ways));
    }


    // Bottom up, interative approach
    private static int calc(int num, int[] ways) {


        return 0;
    }


    // Top down recursive approach
    private static int calc2(int num, int[] ways) {
        if(num <= 1){
            return num;
        }
        if(ways[num] > 0){
            return ways[num];
        }
        ways[num] = calc2(num - 1, ways) + calc2(num - 2, ways) * 2;
        return ways[num];
    }
}
