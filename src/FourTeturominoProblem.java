/**
 * Created by sjeon on 3/29/2018.
 */
import java.util.Scanner;

public class FourTeturominoProblem {
    public static void solve(){
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        int maxScore = Integer.MIN_VALUE;

        int[][] grid = new int[row][col];


        for(int r = 0; r < row; r++){
            for(int c = 0; c < col; c++){
                grid[r][c] = sc.nextInt();
            }
        }
        // long horiz
        for(int r = 0; r < row; r++){
            for(int c = 0; c < col-3; c++){
                int sum = grid[r][c] + grid[r][c + 1] + grid[r][c + 2] + grid[r][c + 3];
                if(sum > maxScore) maxScore = sum;
            }
        }

        // long vert
        for(int r = 0; r < row; r++){
            for(int c = 0; c < col; c++){
                if(c + 3 < col) {
                    int sum = grid[r][c] + grid[r][c + 1] + grid[r][c + 2] + grid[r][c + 3];
                    if (sum > maxScore) maxScore = sum;
                }
            }
        }




    }

}

