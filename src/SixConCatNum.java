/**
 * Created by sjeon on 3/29/2018.
 */
import java.util.Scanner;

public class SixConCatNum {
    public static void solve(){
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();

        int numDigits = 0;
        while(number > 0){
            numDigits++;
            number /= 10;
        }
        long ans = 0;
        for(int start = 1, len = 1; start < number; start *= 10, len++){
            int end = start * 10 - 1;
            if(end > number){
                end = number;
            }
            ans += (long)(end - start + 1) * len ;
        }
        System.out.print(ans);
    }
}
