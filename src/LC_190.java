import java.util.Scanner;

public class LC_190 {
  public static void main(){
    Scanner sc = new Scanner(System.in);
    int num = sc.nextInt();
    System.out.println(Integer.toBinaryString(num));
    LC_190 l = new LC_190();
    System.out.println(l.reverseBits(num));
    sc.close();
  }

  // you need treat n as an unsigned value
  public int reverseBits(int n) {
/*    StringBuilder sb = new StringBuilder( Integer.toBinaryString(n) );
    sb.reverse();
    System.out.println(Integer.parseInt(sb.toString(), 2));
    return Integer.valueOf(sb.toString());*/
    int result = 0;
    for(int i=0; i < 32; i++){
      result += n & 1;
      n >>>= 1; // CATCH: must do unsigned shift
      if( i < 31 ) // CATCH: for last digit, don't shift
        result <<= 1;
    }
    return result;
  }
}
