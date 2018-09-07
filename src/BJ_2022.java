import java.util.Scanner;

public class BJ_2022 {
  public static void main(){
    Scanner sc = new Scanner(System.in);
    while(sc.hasNext()){
      double x,y,c;
      x = sc.nextDouble();
      y = sc.nextDouble();
      c = sc.nextDouble();
      System.out.printf("%.3f" , calcDistBinary(x,y,c));
      System.out.println();
    }
    sc.close();
  }

  private static double calcDistBinary(double x, double y, double c) {
    double lowD = 0;
    double highD = Math.min(x,y);
    double ans = 0;

    while( Math.abs(highD - lowD) > 1e-6){
      double midD = lowD + (highD - lowD) / 2.0;
      ans = midD;
      double h1 = Math.pow( x * x - midD * midD , 0.5);
      double h2 = Math.pow( y * y - midD * midD , 0.5);
      double h = h1 * h2 / ( h1 + h2 );

      if(h > c){
        lowD = midD;
      }else{
        highD = midD;
      }
    }
    return ans;
  }
}
