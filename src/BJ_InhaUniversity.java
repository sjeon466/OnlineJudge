/**
 * Created by sjeon on 4/29/2018.
 */
import java.util.Scanner;

public class BJ_InhaUniversity {
    public static void main(){
        Scanner sc = new Scanner(System.in);
        int baseA = sc.nextInt();
        int baseB = sc.nextInt();
        int nDigits = sc.nextInt();
        int ans = 0;

        for(int i = 0; i < nDigits; i++){
            int x = sc.nextInt();
            ans = ans * baseA + x;
        }

        convert(ans, baseB);
        System.out.println();
    }

    private static void convert(int num, int baseTarget) {
        if(num == 0){
            return;
        }
        convert(num/baseTarget, baseTarget);
        System.out.print(num % baseTarget + " ");
    }

}
