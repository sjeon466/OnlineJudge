/**
 * Created by sjeon on 4/27/2018.
 */
import java.util.Scanner;

public class BaekJoon_Fill_ThreeByN {
    public static void main(){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        long[] memoi = new long[num + 1];

        memoi[0] = 1;

        for(int i = 2; i <= num; i+=2){
            memoi[i] = 3 * memoi[i-2];
            for(int j = i - 4; j >= 0; j-=2){
                memoi[i] += 2 * memoi[j];
            }
        }

        System.out.println(memoi[num]);
    }
}
