import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by sjeon on 4/4/2018.
 */
public class BackJoon_ATMProblem {
    public static void main(){
        Scanner sc = new Scanner(System.in);
        int minutesArrNum = sc.nextInt();
        int[] minutesArr = new int[minutesArrNum];
        for(int i=0; i < minutesArrNum; i++){
            minutesArr[i] = sc.nextInt();
        }

        Arrays.sort(minutesArr);
        System.out.println(Arrays.toString(minutesArr));

        int[] cumulativeMins = new int[minutesArrNum];
        for(int i = 0; i < minutesArrNum; i++){
            if(i == 0) {cumulativeMins[0] = minutesArr[0];}
            else{
                cumulativeMins[i] = minutesArr[i] + cumulativeMins[i-1];
            }
        }
        int ans = 0;
        for(int i = 0; i < minutesArrNum; i++ ){
            ans += cumulativeMins[i];
        }
        //System.out.println(Arrays.toString(cumulativeMins));

        //System.out.println(cumulativeMins[minutesArrNum-1]);
        System.out.println(ans);
    }
}
