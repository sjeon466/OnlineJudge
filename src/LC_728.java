import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class LC_728 {
  public static void main(){
    Scanner sc = new Scanner(System.in);
    int low = sc.nextInt();
    int high = sc.nextInt();

    LC_728 l = new LC_728();
    List<Integer> res = l.selfDividingNumbers(low,high);
    System.out.println(Arrays.toString(res.toArray()));
/*    for(int curInt : res){

    }*/

  }

  public List<Integer> selfDividingNumbers(int left, int right) {
    List<Integer> res = new ArrayList<>();
    for(int i = left; i <= right; i++){
      if(!divide(i)){
        continue;
      }
      res.add(i);
    }
    return res;
  }

  private boolean divide(int num){
    int dividend = num;
    if(num == 0) return false;
    int divisor;

    while(dividend > 0){
      divisor = dividend % 10;
      if(divisor == 0) return false;
      if((num % divisor) != 0) return false;
      dividend /= 10;
    }
    return true;
  }
}
