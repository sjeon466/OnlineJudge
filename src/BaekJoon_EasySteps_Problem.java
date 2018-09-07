/**
 * Created by sjeon on 4/20/2018.
 */
import java.util.Scanner;

public class BaekJoon_EasySteps_Problem {
    public static void main(){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        long[][] memoi = new long[num+1][10];

        for(int i = 1; i <= 9; i++) memoi[1][i] = 1;

        for(int i = 2; i <= num; i++){
            for(int j = 0; j <= 9; j++){
/*                memoi[i][j] = 0;
                if(j - 1 >= 0) memoi[i][j] += memoi[i-1][j-1];
                if(j + 1 <= 9) memoi[i][j] += memoi[i-1][j+1];*/
                if(j == 0){
                    memoi[i][j] = memoi[i-1][1];
                }else if(j == 9){
                    memoi[i][j] = memoi[i-1][8];
                }else{
                    memoi[i][j] = memoi[i-1][j+1] + memoi[i-1][j-1];
                }
                memoi[i][j] %= 1000000000;
            }
        }
        long ans = 0;
        for(int i = 0; i <= 9; i++){
            ans += memoi[num][i];
        }
        System.out.println(ans % 1000000000);
    }
}
