import java.util.Arrays;
import java.util.Scanner;

public class BJ_11066 {
  public static void main(){
    Scanner sc = new Scanner(System.in);
    int numTC = sc.nextInt();

    while(numTC-- > 0){
      int numChapters = sc.nextInt();
      int[] chapters = new int[numChapters];
      for(int i = 0 ; i < numChapters; i++){
        chapters[i] = sc.nextInt();
      }
      int[][] d = new int[numChapters][numChapters];
      for(int[] curRow : d){
        Arrays.fill(curRow, -1);
      }
      System.out.println(combine(0, numChapters - 1, chapters, d));
    }
  }

  private static int combine(int left, int right, int[] chapters, int[][] d) {
    // memoi
    if(d[left][right] >= 0) return d[left][right];

    //base case
    // 1 chapter
    if(left == right){
      d[left][right] = 0;
      return d[left][right];
    }

    // 2 chapters
    if(left + 1 == right && right < chapters.length){
      d[left][right] = chapters[left] + chapters[right];
      return d[left][right];
    }

    int minCost = -1;
    // try for all K times,  find the min cost.
    int chaptersSum = 0;
    for(int i = left; i <= right; i++){
      chaptersSum += chapters[i];
    }

    for(int k = left; k < right; k++){
      int curCost = combine(left, k, chapters, d) + combine(k + 1, right, chapters, d) + chaptersSum;
      if(minCost == -1 || curCost < minCost){
        minCost = curCost;
      }
    }
    d[left][right] = minCost;
    return d[left][right];
  }
}
