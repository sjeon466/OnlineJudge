/**
 * Created by sjeon on 4/3/2018.
 */
import java.util.Scanner;

public class BackJoon_Coin_Problem {
    public static void solve(){
        Scanner sc = new Scanner(System.in);

        int numTypes = sc.nextInt();
        int target = sc.nextInt();
        int[] coins = new int[numTypes];
        for(int i = 0; i < numTypes; i++){
            coins[i] = sc.nextInt();
        }

        int total = 0;
        for(int i = numTypes - 1; i >= 0; i--){
            int coinsPerType = target / coins[i];
            total += coinsPerType;
            target %= coins[i];
        }
        System.out.println(total);
    }
}
