/**
 * Created by sjeon on 4/29/2018.
 */
import java.util.Scanner;

public class BJ_Eight_To_Two {
    public static void main(){
        Scanner sc = new Scanner(System.in);
        String[] eight = {"000", "001", "010", "011", "100", "101", "110", "111"};
        String numBaseEight = sc.nextLine();
        boolean start = true;
        if(numBaseEight.length() == 1 && numBaseEight.charAt(0) == '0'){
            System.out.println(0);
        }

        for(int i = 0; i < numBaseEight.length(); i++){
            int n = numBaseEight.charAt(i) - '0';
            if(start == true && n < 4){
                if(n == 0){
                    continue;
                } else if(n == 1){
                    System.out.print("1");
                } else if(n == 2){
                    System.out.print("10");
                } else if(n == 3){
                    System.out.print("11");
                }
                start = false;
            } else{
                System.out.print(eight[n]);
                start = false;
            }
            System.out.println();
        }
    }
}
