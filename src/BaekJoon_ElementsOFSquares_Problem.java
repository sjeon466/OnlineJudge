/**
 * Created by sjeon on 4/27/2018.
 */
import java.util.Scanner;

public class BaekJoon_ElementsOFSquares_Problem {
    public static void main(){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        /* int ans = 0;
        int start = (int) Math.floor(Math.sqrt(num));
        for(int i = start; i >=1; i--){

        }*/
        int memoi[] = new int[num + 1];
        for(int i = 1; i <= num; i++){
            memoi[i] = i;
            for(int j = 1; j * j <= i; j++){
                if(memoi[i - j * j] + 1 < memoi[i]) memoi[i] = memoi[i- j*j] + 1;
            }
        }
        System.out.println(memoi[num]);
    }
}
