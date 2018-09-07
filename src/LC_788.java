import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LC_788 {
  public static void main(){
    Scanner sc = new Scanner(System.in);
    int num = sc.nextInt();
    LC_788 m = new LC_788();
    System.out.println(m.rotatedDigits(num));
  }

  public int rotatedDigits(int num) {
    int[] dp = new int[num + 1];
    int count = 0;
    for(int i=0; i <= num; i++){
      if(i < 10){
        if(i==0 || i ==1 || i == 8) dp[i] = 1;
        else if(i == 2 || i == 5 || i == 6 || i == 9){
          dp[i] = 2;
          count++;
        }
      } else {
        int restDigits = dp[ i / 10], onesDigit = dp[ i % 10];
        if(restDigits == 1 && onesDigit == 1) dp[i] = 1;
        else if(restDigits >= 1 && onesDigit >= 1){
          dp[i] = 2;
          count++;
        }
      }
    }
    return count;
  }

  public int rotatedDigits3(int N) {
    int count = 0;
    for (int i = 1; i <= N; i ++) {
      if (isValid(i)) count ++;
    }
    return count;
  }

  public boolean isValid(int N) {
        /*
         Valid if N contains ATLEAST ONE 2, 5, 6, 9
         AND NO 3, 4 or 7s
         */
    boolean validFound = false;
    while (N > 0) {
      if (N % 10 == 2) validFound = true;
      if (N % 10 == 5) validFound = true;
      if (N % 10 == 6) validFound = true;
      if (N % 10 == 9) validFound = true;
      if (N % 10 == 3) return false;
      if (N % 10 == 4) return false;
      if (N % 10 == 7) return false;
      N = N / 10;
    }
    return validFound;
  }


  public int rotatedDigits2(int num) {
    if(containsInvalid(num) || containsOnlyRotateNoChange(num)){
      //System.out.println("invalid ");
      return -1;
    }

    int ans = 1;
    while(num > 0){
      int digit = num % 10;
      //System.out.println(digit + ", R changed? : " + isRotatableChanged(digit));
      //System.out.println(digit + ", R changed? : " + isRotatbleNonChanged(digit));

      // if it contains invalid, answer = 0
      // if it contains only 0,1,8,  answer = 1;
      ans *= convertToPossibilities(digit);
      num /= 10;
    }

    if(ans == 1 || ans == 0){
      return -1;
    }
    return ans;
  }

  private boolean containsOnlyRotateNoChange(int num) {
    boolean isContainsOnlyRNC = true;

    while(num > 0){
      int digit = num % 10;
      if( digit != 0 && digit != 1 && digit != 8 ){
        return false;
      }
      num /= 10;
    }
    return isContainsOnlyRNC;
  }

  private int convertToPossibilities(int digit){
    switch(digit){
      case 0: return 1;
      case 1: return 2;
      case 2: return 4;
      case 3: return 4;
      case 4: return 4;
      case 5: return 4;
      case 6: return 6;
      case 7: return 6;
      case 8: return 7;
      case 9: return 7;
      default: return -1;
    }
  }


  private boolean containsInvalid(int num){
    while(num > 0){
      int temp = num % 10;
      if(temp == 3 || temp == 4|| temp == 7){
        return true;
      }
      num /= 10;
    }
    return false;
  }

  private boolean isRotatbleNonChanged(int digit){
    Pattern pattern = Pattern.compile("[018]");
    Matcher matcher = pattern.matcher(String.valueOf(digit));
    return matcher.find();
  }

  private boolean isRotatableChanged(int digit){
    switch(digit){
      case 2: return true;
      case 5: return true;
      case 6: return true;
      case 9: return true;
      default: return false;
    }
  }
}
