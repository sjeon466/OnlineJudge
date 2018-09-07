/**
 * Created by sjeon on 4/22/2018.
 */
import java.util.Scanner;

public class Baekjoon_RedWine_Problem {
    public static void main(){
        Scanner sc = new Scanner(System.in);
        int numGlasses = sc.nextInt();
        int[] amounts = new int[numGlasses+1];

        // populating amounts array
        for(int i = 1; i <= numGlasses; i++){
            amounts[i] = sc.nextInt();
        }

        //memoization for storing max amount for Nth glasses
        // with 3 states, j ( j consecutive glasses are drunk

        int[][] memoi = new int[numGlasses+1][3];


        memoi[1][0] = 0;
        memoi[1][1] = amounts[1];

        memoi[2][0] = amounts[1];
        memoi[2][1] = Math.max(amounts[1],amounts[2]);

        for(int i=3; i<= numGlasses; i++){
            memoi[i][0] = Math.max(Math.max(memoi[i][1],memoi[i][0]), memoi[i][2]);
            memoi[i][1] = memoi[i-1][0] + amounts[i];
            memoi[i][2] = memoi[i-1][1] + amounts[i];
        }
        long ans = 0;
        ans = Math.max(Math.max(memoi[numGlasses][2], memoi[numGlasses][0]), memoi[numGlasses][1]);
        System.out.println(ans);

    }
    public static void main2(){
        Scanner sc = new Scanner(System.in);
        int numGlasses = sc.nextInt();
        int[] amounts = new int[numGlasses+1];
        for(int i = 1; i <= numGlasses; i++){
            amounts[i] = sc.nextInt();
        }

        int[][] memoi = new int[numGlasses+1][2];

        memoi[1][1] = amounts[1];
        memoi[1][0] = 0;
        memoi[2][0] = amounts[1];
        memoi[2][1] = amounts[1] + amounts[2];
        memoi[3][0] = amounts[1] + amounts[2];
        memoi[3][1] = Math.max((amounts[2] + amounts[3]),(amounts[1] + amounts[3]));

        for(int r = 4; r <= numGlasses; r++){
            memoi[r][0] = Math.max(
                /*memoi[r-3][S]*/
                Math.max(memoi[r-3][0],memoi[r-3][1]) + amounts[r-2] + amounts[r-1],
                Math.max(memoi[r-3][0],memoi[r-3][1]) + amounts[r-1]);

            memoi[r][1] = Math.max(
                 /*memoi[r-3][S]*/
                Math.max(memoi[r-3][0],memoi[r-3][1]) + amounts[r-1] + amounts[r],
                Math.max(memoi[r-3][0],memoi[r-3][1]) + amounts[r-2] + amounts[r]
            );
        }

        long ans = 0;
        ans = Math.max(memoi[numGlasses][0], memoi[numGlasses][1]);
        System.out.println(ans);
    }
}
