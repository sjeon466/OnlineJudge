/**
 * Created by sjeon on 4/29/2018.
 */

import java.util.Scanner;

public class BJ_GCD_Sum {
    public static void main(){
        Scanner sc = new Scanner(System.in);
        int numTC = sc.nextInt();
        while(numTC-- > 0){
            int num = sc.nextInt();
            int[] nums = new int[num];
            for(int i=0; i < num; i++){
                nums[i] = sc.nextInt();
            }

            int ans = 0;
            for(int i=0; i<nums.length; i++){
                for(int j = i + 1; j < nums.length;  j++){
                   ans +=  gcd(nums[i], nums[j]);
                }
            }
            System.out.println(ans);
        }
    }

    public static int gcd(int a, int b){
        if(b == 0){
            return a;
        }else{
            return gcd(b, a%b);
        }
    }
}
