import java.util.Scanner;

public class BJ_1654 {
  private static boolean check(long[] cables, long numTarget, long mid){
    int curNumPieces = 0;
    for(int i = 0; i < cables.length; i++){
      curNumPieces += cables[i] / mid;
    }
    return curNumPieces >= numTarget;
  }

  public static void main(){
    Scanner sc = new Scanner(System.in);
    int numCablesPossessed = sc.nextInt();
    int numTarget = sc.nextInt();
    long[] cables = new long[numCablesPossessed];
    long lenLogestCable = 0;
    for(int i=0; i < numCablesPossessed; i++){
      long curLength = sc.nextLong();
      lenLogestCable = Math.max(lenLogestCable, curLength);
      cables[i] = curLength;
    }
    long ans = 0;
    long start = 1; long end = lenLogestCable;
    while(start <= end){
      long mid = (end - start) / 2 + start;
      if(check(cables, numTarget, mid)){
        start = mid + 1;
        ans = Math.max(mid, ans);
      } else {
        end = mid - 1;
      }
    }
    System.out.print(ans);
  }
}