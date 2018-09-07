import java.util.Scanner;

public class BJ_6603_2 {
  static final int LOTTO_NUM = 6;
  public static void main(){
    Scanner sc = new Scanner(System.in);
    int poolCount = -100;
    while(poolCount != 0){
      poolCount = sc.nextInt();
      if(poolCount == 0 ) break;
      int[] pool = new int[poolCount];
      for(int i = 0; i < poolCount; i++){
        pool[i] = sc.nextInt();
      }
      int[] curCombination = new int[LOTTO_NUM];
      go(pool, 0, 0, curCombination);
      System.out.println();
    }
  }
  private static void go(int[] pool, int poolIndex, int combIndex,  int[] comb){
      if(combIndex == LOTTO_NUM) {
        for(int curVal : comb) System.out.print(curVal + " ");
        System.out.println();
      }

      if(0 <= combIndex && combIndex < LOTTO_NUM){
        for(int i = poolIndex; i < pool.length; i++){
          comb[combIndex] = pool[i];
          go(pool, i + 1, combIndex + 1, comb);
          go(pool, i + 1, combIndex, comb);
        }
      }
    }
}
