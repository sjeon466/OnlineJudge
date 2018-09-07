/**
 * Created by sjeon on 4/1/2018.
 */import java.util.Scanner;

public class TwobyNTileProblem {
    public static void solve(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] ways = new int[n+1];
        ways[0] = 1;
        ways[1] = 1;

        calc(n, ways);
        System.out.println(ways[n]);
    }
    //bottom up, iterative
    private static int calc2(int num, int[] ways){
        for(int i = 2; i <= num; i++){

        }
        return -1;
    }

    //top down, recursive
    private static int calc(int num, int[] ways) {
        if(num == 2 || num == 1) {
            ways[num] = num;
            return num;
        }
        if(ways[num] > 0){
            return ways[num];
        }

        ways[num] = calc(num - 1, ways) + calc(num - 2, ways);
        return ways[num];
    }
}
