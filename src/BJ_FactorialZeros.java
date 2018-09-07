import java.util.Scanner;

public class BJ_FactorialZeros {
    public static void main(){
        Scanner sc = new Scanner(System.in);
        long n = sc.nextInt();
        long m = sc.nextInt();

        long two = 0;
        long five = 0;
        for(int i=5; i<=n; i*=5){
            five += n / i;
        }
        for(int i=2; i<=n; i*=2){
            two += n / i;
        }

        for(int i=5; i<=m; i*=5){
            five -= m / i;
        }
        for(int i=2; i<=(n-m); i*=2){
            two += (n-m) / i;
        }

        for(int i=2; i<=m; i*=2){
            five -= m / i;
        }
        for(int i=5; i<=(n-m); i*=5){
            two += (n-m) / i;
        }
        System.out.println(Math.min(two, five));
    }
}
