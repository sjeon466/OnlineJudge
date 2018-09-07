/**
 * Created by sjeon on 4/25/2018.
 */

import java.util.Scanner;


public class BaekJoon_Consecutive_Stairs {
    public static void main(){
        Scanner sc = new Scanner(System.in);
        int numVals = sc.nextInt();
        int[] stairs = new int[numVals + 1];
        int[][] memoi = new int[numVals+1][3];

        /**
         * memoi[n][state] = # of max points can be earned when nth stair is reached when only two state are allowed
         * where states are :
         *      A: nth stair is the 1 consecutive stair (2 stairs in a row)
         *      B: nth stiar is the 2 consecutive stiars (3 stairs in a row)
         *
         *      memoi[n][0] = not possible because a person has to reach the nth stair by going up the stair.
         *      memoi[n][1] = n - 1 th stair must not be stepped.
         *          so memoi[n][1] = max ( memoi[n-2][0] , memoi[n-2][1] ) + stairs[n]
         *
         *          memoi[n][2] = n-1 and n-2 are stepped, meaning
         *          so memoi[n][2] = memoi[n-1][1] + stairs[n]
         *
         *      answer = max ( memoi[n][1], memoi[n][2] );
         */

        for(int i =1 ; i <= numVals; i++){
            stairs[i] = sc.nextInt();
        }
        /**
         * initializing base cases
         * start with 0th position
         */
        memoi[1][1] = stairs[1];
        //memoi[2][1] = Math.max(stairs[1], stairs[2]);
        //memoi[2][2] = stairs[1] + stairs[2];

        for(int r = 2; r <= numVals; r++){
            memoi[r][1] = Math.max(memoi[r-2][1], memoi[r-2][2] )+ stairs[r];
            memoi[r][2] = memoi[r-1][1] + stairs[r];
        }

        System.out.println(Math.max(memoi[numVals][1], memoi[numVals][2]));
    }
}
