/**
 * Created by sjeon on 4/1/2018.
 */
import java.util.Scanner;

public class FibProblem {
    public static void solve(){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] cache = new int[num + 1];
        System.out.println(fib2(num, cache));
    }

    public static int fib(int number, int[] memoi){
        if(number == 1 || number == 2){
            memoi[number] = 1;
            return memoi[number];
        }else{
            if(memoi[number] == 0){
                return memoi[number] = fib(number - 1, memoi) + fib(number - 2, memoi);
            }else{
                return memoi[number];
            }
        }
    }

    public static int fib2(int num, int[] memoi){
        int[] ansArray = new int[num + 1];
        for(int i = 1; i <= num; i++){
            if(i == 1 || i == 2){
                ansArray[i] = 1;
            }else{
                ansArray[i] = ansArray[i - 1] + ansArray[i - 2];
            }
        }
        return ansArray[num];
    }

    public static int fib3(int num, int[] memoi){
        //with T: O(n) S: O(1)
        int num1 = 1, num2 = 1, num3;
        if(num == 1 || num == 2){
            return 1;
        }else{
            for(int i = 2; i < num; i++){
                //swapping
                num3 = num1 + num2;
                num1 = num2;
                num2 = num3;
            }
            return num2;
        }
    }

}
