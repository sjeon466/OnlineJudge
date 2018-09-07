import java.util.Scanner;


public class LC_11 {
  public static void main(){
    LC_11 l = new LC_11();
    Scanner sc = new Scanner(System.in);
    int num = sc.nextInt();
    int[] arr = new int[num];
    for(int i = 0; i < num; i++){
      arr[i] = sc.nextInt();
    }
    sc.close();
    System.out.println(l.maxArea(arr));
  }

  public int maxArea(int[] heights) {
    /*
     use two pointers, intially located at either ends.
     The idea behind it is that the area of a water container is bounded by the
     smaller side of the wall so when the width is at maximum in the beginning,
     the smaller side of the wall should be changed (brought inward).
    */
    if(heights == null || heights.length < 2) return 0;

    int left = 0, right = heights.length - 1;
    int maxArea = Math.min(heights[left], heights[right]) * (right - left);

    while(right > left){
      if(heights[left] <= heights[right]){
        left++;
      }else{
        right--;
      }
      maxArea = Math.max(maxArea,
              Math.min(heights[left], heights[right] ) * (right - left) );
    }
    return maxArea;
  }

  public int maxArea2(int[] heights) {
    // for each new bar, find all possible areas with the bars that come before it.
    int maxArea = 0;
    for(int i = 0; i < heights.length; i++){
      for(int j = i + 1; j < heights.length; j++){
        int curArea = Math.min(heights[i], heights[j]) * (j - i);
        maxArea = Math.max(curArea, maxArea);
      }
    }
    return maxArea;
  }
}
