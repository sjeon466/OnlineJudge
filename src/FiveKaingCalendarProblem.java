/**
 * Created by sjeon on 3/29/2018.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class FiveKaingCalendarProblem {
    public static void solve()throws IOException{
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.valueOf(br.readLine());

        while(--tc > 0){
            String[] line = br.readLine().split(" ");
           /* int M = sc.nextInt();
            int N = sc.nextInt();
            int m = sc.nextInt();
            int n = sc.nextInt();*/
            int M = Integer.parseInt(line[0]);
            int N = Integer.parseInt(line[1]);
            int m = Integer.parseInt(line[2]);
            int n = Integer.parseInt(line[3]);

            boolean ok = false;

            for(int k = m; k < (M*N); k += M){
                if(k % N == n){
                    System.out.println(k + 1);
                    ok = true;
                    break;
                }
                if(!ok){
                    System.out.println(-1);
                }
            }

            /*
            int curYear = 1;
            int curM = 1;
            int curN = 1;*/

        }
    }
}
