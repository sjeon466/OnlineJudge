/**
 * Created by sjeon on 4/20/2018.
 */
import java.util.Scanner;

public class BaekJoon_Non_Decreasing_Problem {
    public static void main(){
        Scanner sc = new Scanner(System.in);
        int numLength = sc.nextInt();
        int[][] memoi = new int[numLength+1][10];

        // Filling out the base cases
        for(int i = 0; i <= 9; i++){
            memoi[1][i] = 1;
        }

        for(int i = 2; i <= numLength; i++){
            for(int j = 0; j <= 9; j++){
                //int tempSum = 0;
                for(int k = 0; k <= j; k++){
                    memoi[i][j] += memoi[i-1][k];
                    memoi[i][j] %= 10007;
                }
                //memoi[i][j] = tempSum;
            }
        }

        long ans = 0;
        for(int i = 0; i <= 9; i++){
            ans += memoi[numLength][i];
        }
        System.out.println(ans %= 10007);
    }
}
