import java.util.Scanner;

public class BJ_1016 {
  public static void main(){
    Scanner sc = new Scanner(System.in);
    long min = sc.nextInt();
    long max = sc.nextInt();
    System.out.println(calcNonNonNum(min, max));
  }

  private static int calcNonNonNum(long min, long max) {
    boolean[] nums = new boolean[(int)(max - min)+1];
    for(long i = 2; i * i <= max; i++){
      long w = i * i - min % (i * i);
      if(w == i * i){
        w = 0;
      }

      while( w <= max - min){
        nums[(int)w] = true;
        w += i * i;
      }
    }

    int ans = 0;
    for(int i = 0; i <=max-min; i++){
      if(nums[i] == false){
        ans += 1;
      }
    }
    return ans;
  }
}
