public class Practice {
  public static void main(){
    double d1 = 3;
    int i1 = 2;
    System.out.println(d1 - i1);

  }

  public int closestValue(TreeNode root, double target) {
    int closetVal = root.val;

    while(root != null){
      if(Math.abs(root.val - target) < Math.abs(closetVal - target))
        closetVal = root.val;

      if(root.val < target){
        root = root.right;
        continue;
      }else {
        root = root.left;
        continue;
      }
    }
    return closetVal;
  }



  public int closestValue2(TreeNode root, double target) {
    return (closestValue2(root, target, root.val));
  }

  private int closestValue2(TreeNode node, double target, int closestVal){
    if(node == null) return closestVal;

    if(Math.abs(node.val - target) < Math.abs(closestVal - target)) closestVal = node.val;

 /*   if(node.val < target) return closestValue(node.left, target, closestVal);
    else return closestValue(node.right, target, closestVal);
*/
    return -1;
  }
}
