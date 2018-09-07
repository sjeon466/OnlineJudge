import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class BucketPair implements Comparable<BucketPair>{
  final int bucketA;
  final int bucketB;

  BucketPair(int bucketA, int bucketB){
    this.bucketA = bucketA;
    this.bucketB = bucketB;
  }

  @Override
  public int compareTo(BucketPair bucketPair){
    if(this.bucketA > bucketPair.bucketA || this.bucketB < bucketPair.bucketB
            || this.bucketA < bucketPair.bucketA || this.bucketB < bucketPair.bucketB) return -1;
    return 0;
  }

  @Override
  public boolean equals(Object object){
    if( object instanceof BucketPair){
      BucketPair bp = (BucketPair) object;
      return (this.bucketA == bp.bucketA && this.bucketB == bp.bucketB);
    }
    return false;
  }

  public int hashCode(){
    int n = 3;
    n = 17 * n + this.bucketA;
    n = 17 * n + this.bucketB;
    return n;
  }
}


public class BJ_2251 {
  public static final int[] from = {0, 0, 1, 1, 2, 2};
  public static final int[] to   = {1, 2, 0, 2, 0, 1};

  public static void main(){
    Scanner sc = new Scanner(System.in);
/*    int bucketA = sc.nextInt();
    int bucketB = sc.nextInt();
    int bucketC = sc.nextInt();*/

    int[] caps = new int[3];
    for(int i = 0; i < 3; i++){
      caps[i] = sc.nextInt();
    }

    int sum = caps[2];
    boolean[][] check = new boolean[201][201];
    boolean[] ans = new boolean[201];
    Queue<BucketPair> bucketQueue = new LinkedList<BucketPair>();
    bucketQueue.add(new BucketPair(0, 0));
    check[0][0] = true;
    ans[caps[2]] = true;

    while(!bucketQueue.isEmpty()){
      BucketPair curBuckPair = bucketQueue.poll();
      int[] cur = new int[3];
      cur[0] = curBuckPair.bucketA;
      cur[1] = curBuckPair.bucketB;
      cur[2] = sum - cur[0] - cur[1];

      // C - > A
      for(int i = 0; i < 6; i++){
        int[] afterChange = {cur[0], cur[1], cur[2]};
        afterChange[ to[i] ] += afterChange[ to[i] ];
        afterChange[from[i]] = 0;
        if(afterChange[ to[i]] >= caps[to[i]]){
          //afterChange[from[i]] += afterChange[ to[i]] - caps[to[i]];
          afterChange[from[i]] = (afterChange[to[i]] - caps[to[i]]);
          afterChange[ to[i] ] = caps[to[i]];
        }

        if(!check[afterChange[0]][afterChange[1]]){
          check[afterChange[0]][afterChange[1]] = true;
          bucketQueue.add(new BucketPair(afterChange[0], afterChange[1]));
          if(afterChange[0] == 0)  ans[ afterChange[2] ] = true;
        }
      }
    }

    for(int i = 0; i <= caps[2]; i++){
      if(ans[i]) {
        System.out.println(ans[i] + " ");
      }
    }
    System.out.println();
  }
}
