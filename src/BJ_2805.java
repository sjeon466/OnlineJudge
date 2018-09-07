
import java.util.Scanner;

public class BJ_2805 {
  public static void main(){
    Scanner sc = new Scanner(System.in);
    int numTrees = sc.nextInt();
    int lengthMinTree = sc.nextInt();

    int[] trees = new int[numTrees];
    int maxTree = 0;
    for(int i=0; i < numTrees; i++){
      int curTree = sc.nextInt();
      maxTree = Math.max(maxTree, curTree);
      trees[i] = curTree;
    }
    int maxHeight = 0;

    int low = 0; int high = maxTree;
    while(low <= high){
      int mid = (high - low) / 2 + low;
      if(checkForRightCut(trees, lengthMinTree, mid)){
        low = mid + 1;
        maxHeight = Math.max(maxHeight, mid);
      } else {
        high = mid - 1;
      }
    }
    System.out.println(maxHeight);
  }

  private static boolean checkForRightCut(int[] trees, int lengthMinTree, int mid){
    int treeSum = 0;
    for(int i = 0; i < trees.length; i++){
      if(trees[i] > lengthMinTree){
        treeSum += (trees[i] - lengthMinTree);
      }
      //treeSum += (trees[i] - mid) > 0 ? (trees[i] - mid) : 0;
    }
    return treeSum >= lengthMinTree;
  }
}
