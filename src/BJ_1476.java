import java.util.Scanner;

public class BJ_1476 {
  public static void main(){
    Scanner sc = new Scanner(System.in);

    int E = sc.nextInt();   //1-15
    int S = sc.nextInt();   //1-28
    int M = sc.nextInt();   //1-19

    int numYear = 1;
    int e = 1, s = 1, m = 1;

    while(  !(E == e && S == s && M == m) ){
      if(e == 15){
        e = 1;
      }else{
        e++;
      }

      if(s == 28){
        s = 1;
      }else{
        s++;
      }

      if(m == 19){
        m = 1;
      }else{
        m++;
      }
      numYear++;
    }

    sc.close();
    System.out.println( numYear );
  }
}
