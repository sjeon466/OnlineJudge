import java.util.Scanner;

/**
 * Created by sjeon on 4/1/2018.
 */
public class MakeOneProblem {
    public static void solve(){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] moves = new int[num + 1];
        System.out.println(makeOne(num, moves));
    }

    private static int makeOne2(int num, int[] moves){
        for(int i = 2; i <= num; i++){
            moves[i] = moves[i - 1] + 1;
            if(i % 2 == 0 && moves[i / 2] + 1 < moves[i]){
                moves[i] = moves[i/2] + 1;
            }

            if(i % 3 == 0 && moves[i / 3] + 1 < moves[i]){
                moves[i] = moves[i/3] + 1;
            }
        }
        return moves[num];
    }


    private static int makeOne1(int num, int[] moves){
        if(num == 1) return 0;
        if(moves[num] > 0) return moves[num];

        //populating with -1 moves
        moves[num] = makeOne1(num - 1, moves) + 1;

        //populating with -2 moves
        if(num % 2 == 0){
            int temp = moves[num / 2] + 1;
            if(temp < moves[num]){
                moves[num] = temp;
            }
        }

        if(num % 3 == 0){
            int temp = moves[num / 3] + 1;
            if(temp < moves[num]){
                moves[num] = temp;
            }
        }
        return moves[num];
    }

    //bottom up
    private static int makeOne(int num, int[] moves) {
        if(num == 1 || num == 2 || num == 3){
            return moves[num];
        }

        for(int i = 4; i <= num; i++){

        }
        return -1;
    }

    private static int min(int... numbers){
        int minNum = Integer.MAX_VALUE;
        for(int temp: numbers){
            if(temp < minNum){
                minNum = temp;
            }
        }
        return minNum;
    }
}
