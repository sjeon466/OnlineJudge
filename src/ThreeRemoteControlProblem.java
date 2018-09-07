/**
 * Created by sjeon on 3/29/2018.
 */
import java.util.Scanner;

public class ThreeRemoteControlProblem {
    public static void solve(){
        Scanner sc = new Scanner(System.in);
        boolean[] brokenButtons = new boolean[10];
        int targetChan = sc.nextInt();
        int numBrokenButtons = sc.nextInt();

        for(int i = 0; i < numBrokenButtons; i++){
            brokenButtons[sc.nextInt()] = true;
        }

        int minMove = Integer.MAX_VALUE;

        for(int i = 0; i < 1000000; i++){
            if(targetChan == 100){
                minMove = 0;
                break;
            }

            if(containsBroken(i, brokenButtons) || i == 100){
                continue;
            }

            int curMove = Math.min(String.valueOf(i).length() + Math.abs(targetChan - i), Math.abs(i - 100 ));
            //int curMove = String.valueOf(i).length() + Math.abs(targetChan - i);
            if(curMove < minMove){
                minMove = curMove;
            }
        }
        System.out.println(minMove);
    }

    public static boolean containsBroken(int channel, boolean[] bButtons) {
        if (channel == 0) {
            return bButtons[0];
        }
        while (channel > 0) {
            int val = channel % 10;
            if (bButtons[val]) return true;
            channel /= 10;
        }
        return false;
    }
}
