import java.util.Scanner;

public class BJ_2875 {
  private static Scanner sc = new Scanner(System.in);
  public static void main(){
    int numWomen = sc.nextInt();
    int numMen = sc.nextInt();
    int numInterns = sc.nextInt();

    int numTeam = 0;

    while( (numWomen + numMen >= numInterns + 3) && numWomen >= 2 && numMen >= 1){
      numTeam++;
      numWomen -= 2;
      numMen -= 1;
    }
    System.out.println(numTeam);
  }
}
