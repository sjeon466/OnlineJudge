/**
 * Created by sjeon on 4/29/2018.
 */
import java.util.Scanner;


public class BJ_Jinbub {
    public static void main(){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int base = sc.nextInt();

        StringBuilder sb = new StringBuilder();

        while(num > 0){
            int remainder = num % base;
            if(remainder < 10){
                sb.append(num % base);
            }else{
                sb.append(Character.toString((char) (55 + remainder)));
            }
            num /= base;
        }
        System.out.println(sb.reverse().toString());
    }
}
