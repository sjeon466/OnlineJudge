/**
 * Created by sjeon on 4/27/2018.
 */
import java.util.Arrays;
import java.util.Scanner;

public class BaekJoon_Pado_Problem {
    public static void main(){
        Scanner sc = new Scanner(System.in);

        long[] memoi = {0,1,1,1,2,2,3,4};
        memoi = Arrays.copyOf(memoi, 101);

        for(int i = 8; i <=100; i++){
            memoi[i] = memoi[i-1] + memoi[i-5];
        }

        int numTC = sc.nextInt();
            while(numTC-- > 0){
                int n = sc.nextInt();
                System.out.println(memoi[n]);
            }
    }
}
