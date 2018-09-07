import java.util.Scanner;

/**
 * Created by sjeon on 4/25/2018.
 */

public class BaekJoon_LargestSumofLongestIncreasingSubse_Problem {
    public static void main(){
        Scanner sc = new Scanner(System.in);
        int numVals = sc.nextInt();
        int[] vals = new int[numVals];
        int[] memoi = new int[numVals];
        for(int i=0; i<numVals; i++){
            vals[i] = sc.nextInt();
        }

        for(int i=0; i<numVals; i++){
            memoi[i] = vals[i];
            for(int j=0; j<i; j++){
                if(vals[j] < vals[i] && memoi[j] + vals[i] > memoi[i]){
                    memoi[i] = memoi[j] + vals[i];
                }
            }
        }

        int maxVal = memoi[0];
        for(int i=0; i<numVals; i++){
            if(memoi[i] > maxVal){
                maxVal = memoi[i];
            }
        }
        System.out.println(maxVal);
    }
}

