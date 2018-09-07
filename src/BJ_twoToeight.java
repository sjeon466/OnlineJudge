/**
 * Created by sjeon on 4/29/2018.
 */

import java.util.Scanner;

public class BJ_twoToeight {
    public static void main(){
        Scanner sc = new Scanner(System.in);
        String origNum = sc.nextLine().trim();
        StringBuilder sb = new StringBuilder();

        int len = origNum.length();

        if(len  % 3 == 1){
            System.out.print(origNum.charAt(0) - '0');
        }

        if(len % 3 == 2){
            System.out.print( (origNum.charAt(0) - '0') * 2 + (origNum.charAt(1) - '0') );
        }

        for(int i = len % 3; i < len; i+=3){
            System.out.print( (origNum.charAt(0) - '0') * 4 + (origNum.charAt(i+1) - '0') * 2
            + (origNum.charAt(i+2) - '0'));
        }
        System.out.println();
        //(Integer.valueOf(origNum.substring(0, (len % 3 == 0 ) ? 3 : (len % 3))));
    }

}
