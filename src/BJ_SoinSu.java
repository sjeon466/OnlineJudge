import java.util.Scanner;

public class BJ_SoinSu {
    public static void main(){
        Scanner sc = new Scanner(System.in);
        int targetNum = sc.nextInt();

        for(int i=2; i * i <= targetNum; i++){
            while(targetNum % i == 0){
                System.out.println(i);
                targetNum /=i;
            }
        }

        if(targetNum > 1){
            System.out.println(targetNum);
        }

    }
}
