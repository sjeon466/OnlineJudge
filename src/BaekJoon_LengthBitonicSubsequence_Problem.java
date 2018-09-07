/**
 * Created by sjeon on 4/25/2018.
 */
import java.util.Scanner;

public class BaekJoon_LengthBitonicSubsequence_Problem {
    public static void main(){
        Scanner sc = new Scanner(System.in);

        int numVals = sc.nextInt();
        int[] vals = new int[numVals];
        int[] memoiInc = new int[numVals];
        int[] memoiDec = new int[numVals];
        int[] memoiBitonic = new int [numVals];



        for(int i = 0; i < numVals; i++){
            vals[i] = sc.nextInt();
        }

        for(int i=0; i<numVals; i++){
            memoiInc[i] = 1;
            for(int j=0; j<i; j++){
                if(vals[j] < vals[i] && memoiInc[j] + 1 > memoiInc[i]){
                    memoiInc[i] = memoiInc[j] + 1;
                }
            }
        }

        for(int i=numVals-1; i>=0; i--){
            memoiDec[i] = 1;
            for(int j= i + 1; j< numVals; j++){
                if(vals[j] < vals[i] && memoiDec[j] + 1 > memoiDec[i]){
                    memoiDec[i] = memoiDec[j] + 1;
                }
            }
        }

        int ans = 0;

        for(int j = 0; j < numVals; j++){
            memoiBitonic[j] = 1;
            if(memoiInc[j] + memoiDec[j] - 1 >  ans) {
                ans = memoiInc[j] + memoiDec[j] - 1;
            }
        }
        System.out.println(ans);
    }
}
