import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ_1963 {
  private static int change(int num, int index, int digit){
    if(index == 0 && digit == 0){
      return -1;
    }

    String str = Integer.toString(num);
    StringBuilder sb = new StringBuilder(str);
    sb.setCharAt(index, (char)(digit + '0'));
    return Integer.valueOf(sb.toString());
  }

  public static void main(){
    Scanner sc = new Scanner(System.in);
      boolean[] isPrimeArr = new boolean[10001];
      for(int i = 2; i <= 10000; i++){
      if(isPrimeArr[i] == false){
        for(int j = i * i; j <= 10000; j+=i){
          isPrimeArr[j] = true;
        }
      }
    }

    for(int i = 0; i <= 10000; i++){
      isPrimeArr[i] = !isPrimeArr[i];
    }

    int t = sc.nextInt();

    while(t-- > 0){
      int n = sc.nextInt();
      int m = sc.nextInt();

      boolean[] c = new boolean[10001];
      int[] d = new int[10001];
      d[n] = 0;
      c[n] = true;

      Queue<Integer> queue = new LinkedList<Integer>();
      queue.add(n);

      while(!queue.isEmpty()){
        int now = queue.remove();
        for(int i = 0; i < 4; i++){
          for(int j = 0; j <=9; j++){
            int next = change(now, i, j);
            if(next == -1){
              if(isPrimeArr[next] && c[next] == false){
                queue.add(next);
                d[next] = d[now] + 1;
                c[next] = true;
              }
            }
          }
        }
      }
      System.out.println(d[m]);
    }
  }
}
