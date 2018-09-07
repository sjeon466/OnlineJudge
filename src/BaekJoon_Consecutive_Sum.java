/**
 * Created by sjeon on 4/25/2018.
 */
import java.util.Scanner;

public class BaekJoon_Consecutive_Sum {
    public static void main(){
        Scanner sc = new Scanner(System.in);
        int numVals = sc.nextInt();
        int[] vals = new int[numVals];
        int[] memoi = new int[numVals];

        for(int i = 0; i < numVals; i++){
            vals[i] = sc.nextInt();
        }

        /*
         memoi[i] = max consecutive sum where vals[i] is the last element
                    Scenario A:   memoi[i-1] + vals[i]
                    Scenario B:   vals[i]

         therefore,  memoi[i] = max(memeoi[i-1] + vals[i], vals[i])

         */


        int maxSum = vals[0];

        for(int i = 0; i < numVals; i++){
            memoi[i] = vals[i];
            if(i == 0) continue;

            memoi[i] = Math.max(vals[i], memoi[i-1] + vals[i]);
            if(memoi[i] > maxSum){
                maxSum = memoi[i];
            }
        }
        System.out.println(maxSum);
    }
}
