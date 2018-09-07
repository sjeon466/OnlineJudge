import java.util.Scanner;


public class BJ_10610 {
  private static Scanner sc = new Scanner(System.in);

  public static void main(){
    int num = sc.nextInt();
    if((num > 10 && !constainsZero(num)) || sumDigits(num) % 3 != 0){
      System.out.println(-1);
    }else{
      System.out.println(reArrange(num));
    }
  }

  private static boolean constainsZero(int num) {
    while(num > 0){
      int curDigit = num % 10;
      if(curDigit == 0){
        return true;
      }
      num /= 10;
    }
    return false;
  }

  private static int reArrange(int num) {
    int[] digitCounts = new int[10];
    while(num > 0){
      int curDigit = num % 10;
      digitCounts[curDigit]++;
      num /= 10;
    }
    StringBuilder sb = new StringBuilder();
    for(int i=9; i >= 0; i--){
      while(digitCounts[i] > 0){
        digitCounts[i]--;
        sb.append(i);
      }
    }
    return Integer.parseInt(sb.toString());
  }

  private static int sumDigits(int num) {
    int sumDigits = 0;
    while(num > 0){
      sumDigits += num % 10;
      num /= 10;
    }
    return sumDigits;
  }
}
