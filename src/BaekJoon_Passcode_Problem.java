/**
 * Created by sjeon on 4/28/2018.
 */

import java.util.Scanner;

public class BaekJoon_Passcode_Problem {
    public static int mod = 1000000;
    public static void main(){

        //String tr = "24";
        //System.out.println(tr.charAt(0) - '0');
        //System.out.println(tr.charAt(1));
        //System.out.println(tr.charAt(1) + tr.charAt(0) + "");
        //StringBuilder sb = new StringBuilder();
        //System.out.println(Integer.parseInt(sb.append(tr.charAt(0)).append(tr.charAt(1)).toString()));

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine().trim();
        int len = str.length();
        str = " " + str;

        int[] memoi = new int[len + 1];
        memoi[0] = 1;
        //memoi[1] = 9;

        for(int i = 1; i <= len; i++){
            int x = str.charAt(i) - '0';


            //by its own number
            if(1 <= x && x <= 9){
                memoi[i] += memoi[i-1];
                memoi[i] %= mod;
            }

            if(i == 1){
                continue;
            }

            if(str.charAt(i-1) == '0'){
                continue;
            }

            x = (str.charAt(i-1)-'0' * 10 + str.charAt(i) - '0');
            if(10 <= x && x <= 26){
                memoi[i] += memoi[i-2];
            }


      /*      if((Integer.parseInt(str.charAt(i-1) + str.charAt(i) + "")- '0') <= 26){

            }
            if()
*/

        }
    }
}


















