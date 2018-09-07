import java.util.Scanner;

public class BJ_ERAS {
    public static void main(){
        Scanner sc = new Scanner(System.in);
        int low = sc.nextInt();
        int high = sc.nextInt();
        boolean[] check = new boolean[high + 1];
        check[0] = check[1] = true;
        for(int i = 2; i * i <= high; i++){
            if(check[i] == true){
                // already deleted
                continue;
            }
            // remove the multiples
            for(int j= i + i; j <= high; j+=i){
                check[j] = true;
            }
        }
        for(int i = low; i<=high; i++) {
            if (check[i] == false) {
                System.out.println(i);
            }
        }
    }
}
