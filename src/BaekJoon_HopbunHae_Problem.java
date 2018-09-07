/**
 * Created by sjeon on 4/28/2018.
 */
import java.util.Scanner;

public class BaekJoon_HopbunHae_Problem {
    public static long mod = 1000000000L;
    public static void main(){
        Scanner sc = new Scanner(System.in);
        int targetNum = sc.nextInt();
        int kNum = sc.nextInt();

        int[][] memoi = new int[kNum + 1][targetNum + 1];
        memoi[0][0] = 1;

        for(int k = 1; k <= kNum; k++){
            for(int n = 0; n <= targetNum; n++){
                for(int l = 0; l <= n; l++){
                    memoi[k][n] += memoi[k-1][n-l];
                    memoi[k][n] %= mod;
                }
            }
        }
        System.out.println(memoi[kNum][targetNum]);
    }
}
