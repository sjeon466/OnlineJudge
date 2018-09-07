import java.util.Arrays;
import java.util.Scanner;

public class BJ_10610_2 {
  public static void main(){
    Scanner sc = new Scanner(System.in);
    char[] chars = sc.nextLine().toCharArray();
    int sum = 0;
    for(int i=0; i < chars.length; i++){
      sum += chars[i] - '0';
    }

    Arrays.sort(chars);

    if(sum % 3 == 0 && chars[0] == '0'){
      for(int i = chars.length -1 ; i >= 0; i--){
        System.out.print(chars[i]);
      }
      System.out.println();
    }else{
      System.out.println(-1);
    }
  }
}
