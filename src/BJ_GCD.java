/**
 * Created by sjeon on 4/28/2018.
 */
import java.util.Scanner;

public class BJ_GCD {
    public static void main2(){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        gcd(a,b);
    }

    public static int gcd2(int a, int b) {
        while(b != 0){
            a = b;
            b = a%b;
        }
        return a;
    }

    public static int gcd(int a, int b){
        if(b == 0) {
            return a;
        } else {
            return gcd(b, a%b);
        }
    }


    public static void main(){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        int gcd = 1;

        for(int i = 2; i <= Math.min(a,b); i++){
            if(a % i == 0 && b % i == 0){
                gcd = i;
            }
        }
        System.out.println(gcd);
    }
}
