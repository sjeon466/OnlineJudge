/**
 * Created by sjeon on 4/20/2018.
 */
import java.util.Scanner;

public class BaekJoon_EChinSoo_Problem {
    public static void main(){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        long[][] memoi = new long[num+1][2];

        memoi[1][0] = 0;
        memoi[1][1] = 1;

        for(int i = 2; i <= num; i++){
            memoi[i][0] = memoi[i-1][0] + memoi[i-1][1];
            memoi[i][1] = memoi[i-1][0];
        }
        System.out.println(memoi[num][0] + memoi[num][1]);
    }
}
