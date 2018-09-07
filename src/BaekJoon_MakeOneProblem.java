import java.util.Scanner;

/**
 * Created by sjeon on 4/20/2018.
 */
public class BaekJoon_MakeOneProblem {
    static int[] memoi;
    public static void main(){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        memoi = new int[num + 1];
        System.out.println(goDP(num));
    }

    public static int goDP2(int num){
        memoi[1] = 0;
        for(int i = 2; i <= num; i++){
            memoi[i] = memoi[i - 1] + 1;
            if(i % 3 == 0 && memoi[i/3] + 1 < memoi[i]){
                memoi[i] = memoi[i/3] + 1;
            }
            if(i % 2 == 0 && memoi[i/2] + 1 < memoi[i]){
                memoi[i] = memoi[i/2] + 1;
            }
        }
        return memoi[num];
    }

    public static int goDP(int num){

        if(num == 1) return 0;
        if(memoi[num] > 0) return memoi[num];
        memoi[num] = goDP(num - 1) + 1;
        if(num % 2 == 0){
            int temp = goDP(num/2) + 1;
            if(temp < memoi[num]) memoi[num] = temp;
        }
        if(num % 3 == 0){
            int temp = goDP(num/3) + 1;
            if(temp < memoi[num]) memoi[num]= temp;
        }
        return memoi[num];
    }
}
