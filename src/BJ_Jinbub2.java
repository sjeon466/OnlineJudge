/**
 * Created by sjeon on 4/29/2018.
 */
import java.util.Scanner;
public class BJ_Jinbub2 {

    public static void main3(){
        Scanner sc = new Scanner(System.in);
        String[] line = sc.nextLine().split(" ");
        String s = line[0];
        int b = Integer.parseInt(line[1]);

        int ans = 0;

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if('0' <= c && c <= '9'){
                ans = ans * b + (c - '0');
            } else {
                ans = ans * b + (c - 'A' + 10);
            }
        }
        System.out.println(ans);

    }

    public static void main(){
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int base = sc.nextInt();
        //System.out.println(str + " rrr" + base);

        int len = str.length();

        StringBuilder sb = new StringBuilder();
        long ans = 0;
        for(int i = 0; i < len; i++){
            char c = str.charAt(len - 1 - i);
            if(c - '0' > 10){
                ans += power(base, i) * (c - 'A' + 10);

            }else{
                ans += power(base, i) * Integer.parseInt(String.valueOf(c));
            }
        }
        System.out.println(ans);
    }

    public static long power(int base, int exp){
        long ans = 1;
        for(int i = 0; i < exp; i++){
            ans *= base;
        }
        return ans;
    }
}
