/**
 * Created by sjeon on 4/20/2018.
 */
import java.util.Scanner;

public class BaekJoon_Fill_2ByN_Problem {
    static int[] memoi;
    public static int main(){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        memoi = new int[num + 1];
        //bottom up approach
        //memoi[0] = 0;
        memoi[1] = 1;
        memoi[2] = 1;
        for(int i = 3; i <= num; i++){
            memoi[i] = memoi[i-1] + memoi[i-2];
        }
        return memoi[num];
    }
}
