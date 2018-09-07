/**
 * Created by sjeon on 4/24/2018.
 */
import java.util.Scanner;

public class BaekJoon_LongestIncreasingSubsequence_Problem {
    public static void main(){
        Scanner sc = new Scanner(System.in);
        int numVals = sc.nextInt();
        int[] vals = new int[numVals];
        int[] memoi = new int[numVals];
        for(int i=0; i<numVals; i++){
            vals[i] = sc.nextInt();
        }

        for(int i=0; i<numVals; i++){
            memoi[i] = 1;
            for(int j=0; j<i; j++){
                if(vals[j] < vals[i] && memoi[j] >= memoi[i]){
                    memoi[i] = memoi[j] + 1;
                }
            }
        }

        int maxVal = Integer.MIN_VALUE;
        for(int i=0; i<numVals; i++){
            if(memoi[i] > maxVal){
                maxVal = memoi[i];
            }
        }
        System.out.println(maxVal);
    }
}

