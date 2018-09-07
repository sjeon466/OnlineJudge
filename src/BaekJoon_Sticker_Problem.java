/**
 * Created by sjeon on 4/22/2018.
 */
import java.util.Scanner;


public class BaekJoon_Sticker_Problem {
    public static void main(){
        Scanner sc = new Scanner(System.in);
        int numTC = sc.nextInt();
        for(int i=0; i<numTC; i++){
            int numN = sc.nextInt();

            //populating prices tables
            int[][] prices = new int[numN+1][2];
            for(int c = 0; c <= 1; c++){
                for(int r = 1; r <= numN; r++){
                    prices[r][c] = sc.nextInt();
                }
            }

            /*
                D[N][S] = Max score with N num with State S where
                    S == 0 -> Both stamps in the column are cut
                                X
                                X
                    S == 1 -> top stamp in the column is cut
                                0
                                X
                    S == 1 -> bottom stamp in the column is cut
                                X
                                O
                Recurrence Formula:
                    D[N][0] = max( D[N-1][0], max ( D[N-1][1], D[N-1][2] ) )
                    D[N][1] = max( D[N-1][0], D[N-1][2] ) + P[N][1]
                    D[N][2] = max( D[N-1][0], D[N-1][1] ) + P[N][0]

                The final answer will be Max of (D[N][S]) where ( 0 <= S <= 2 )
             */

            long[][] memoi = new long[numN + 1][3];
            for(int r = 1; r <= numN; r++){
                memoi[r][0] = Math.max( memoi[r-1][0], Math.max ( memoi[r-1][1], memoi[r-1][2] ) );
                memoi[r][1] = Math.max( memoi[r-1][0], memoi[r-1][2] ) + prices[r][1];
                memoi[r][2] = Math.max( memoi[r-1][0], memoi[r-1][1] ) + prices[r][0];
            }
            long ans = 0;
            ans = (Math.max(memoi[numN][0], Math.max(memoi[numN][1],memoi[numN][2])));
            System.out.println(ans);
        }
    }
}
