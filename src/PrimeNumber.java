/**
 * Created by sjeon on 4/29/2018.
 */
import java.util.Scanner;

public class PrimeNumber {

    public static void main(){
        Scanner sc = new Scanner(System.in);
        int numVals = sc.nextInt();
        int primeCount = 0;
        for(int i=0; i < numVals; i++){
            if(isPrime2(sc.nextInt())) primeCount++;
        }
        System.out.println(primeCount);
    }
    public static boolean isPrime(int num){
        if(num < 2) return false;
        for(int i = 2; i < num / 2 ; i++ ){
            if(num % i == 0) return false;
        }
        return true;
    }

    public static boolean isPrime2(int num){
        if(num < 2) return false;
        for(int i = 2; i * i  <= num  ; i++ ){
            if(num % i == 0) return false;
        }
        return true;
    }

}
