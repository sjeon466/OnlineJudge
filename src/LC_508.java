import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC_508 {
  public static void main(){

  }

  public int[] findFrequentTreeSum(TreeNode root) {
    Map<Integer, Integer> map = new HashMap<>();
    go(root, map);

    int maxFreqVal = 0;
    List<Integer> resList = new ArrayList<>();

    for(int key : map.keySet()){
      int curFreqVal = map.get(key);
      if(curFreqVal > maxFreqVal){
        maxFreqVal = curFreqVal;
        resList.clear();
        resList.add(key);

      }else if(curFreqVal == maxFreqVal){
        resList.add(key);
      }
    }
    int[] resLi = new int[resList.size()];
    for(int i = 0; i < resLi.length; i++){
      resLi[i] = resList.get(i);
    }

    return resLi;
  }

  private int go(TreeNode node, Map<Integer,Integer> map){
    //if leaf node, return the leaf val.
    if(node.left == null && node.right == null) {
      map.put(node.val, map.getOrDefault(node.val, 0) + 1);
      return node.val;
    }

    int leftSubTreeSum = 0;
    if(node.left != null){
      leftSubTreeSum += go(node.left, map);
    }
    int rightSubTreeSum = 0;
    if(node.right != null){
      rightSubTreeSum = go(node.right, map);
    }

    int curSubTreeSum = rightSubTreeSum + leftSubTreeSum + node.val;
    map.put(curSubTreeSum, map.getOrDefault(curSubTreeSum, 0) + 1);
    return curSubTreeSum;
  }
}
