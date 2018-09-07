/**
 * Created by sjeon on 4/20/2018.
 */
import java.util.Scanner;
public class BaekJoon_FishBread_Problem {
    public static void main(){
        Scanner sc = new Scanner (System.in);
        int numBread = sc.nextInt();

        int[] price = new int[numBread + 1];
        for(int i = 1; i <= numBread; i++){
            price[i] = sc.nextInt();
        }

        int[] memoi = new int[numBread + 1];

        for(int i = 1; i <= numBread; i++){
            for(int j = 1; j <= i; j++){
                memoi[i] = Math.max(memoi[i],memoi[i-j] + price[j]);
            }
        }
        System.out.println(memoi[numBread]);
    }
}
