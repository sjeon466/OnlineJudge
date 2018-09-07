import java.util.Scanner;

public class BJ_1629 {
  public static void main(){
    Scanner sc = new Scanner(System.in);
    int base = sc.nextInt();
    int exp = sc.nextInt();
    int divider = sc.nextInt();
    System.out.println(solve(base, exp , divider));
  }

  private static int solve(int base, int exp, int divider) {
    if (exp == 0){
      return 1;
    }
    if(exp == 1){
      return base % divider;
    }

    if(exp % 2 == 1){
      return (base % divider) * (solve(base, exp - 1, divider) % divider);
    }else{
      int temp = solve(base, exp / 2, divider);
      temp %= divider;
      return temp * temp;
    }
  }
}
