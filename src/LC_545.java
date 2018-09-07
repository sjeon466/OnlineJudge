import java.util.*;

public class LC_545 {
  public static void main(){
    LC_545 l = new LC_545();
    TreeNode root = generateRoot();
    System.out.println(Arrays.toString(l.boundaryOfBinaryTree(root).toArray()));
  }

  private static TreeNode generateRoot() {
    TreeNode root = new TreeNode(1);
    TreeNode two = new TreeNode(2);
    TreeNode three = new TreeNode(3);
    root.left = two;
    root.right = three;
    TreeNode four = new TreeNode(4);
    TreeNode five = new TreeNode(5);
    two.left = four;
    two.right = five;
    TreeNode six = new TreeNode(6);
    three.left = six;
    TreeNode seven = new TreeNode(7);
    TreeNode eight = new TreeNode(8);
    five.left = seven;
    five.right = eight;
    TreeNode nine = new TreeNode(9);
    TreeNode ten = new TreeNode(10);
    six.left = nine;
    six.right = ten;
    return root;
  }


  public List<Integer> boundaryOfBinaryTree(TreeNode root) {
    if(root == null) return new ArrayList<Integer>();

    List<TreeNode> leaves = new ArrayList<>();
    List<TreeNode> leftBound = new ArrayList<>();
    List<TreeNode> rightBound = new ArrayList<>();

    TreeNode curNode = root;
    leftBound.add(root);
    // getting left bound
    if(root.left != null){
      while( ( curNode.left != null || curNode.right != null) ){
        if(curNode.left != null) {
          leftBound.add(curNode.left);
          curNode = curNode.left;
        }else {
          leftBound.add(curNode.right);
          curNode = curNode.right;
        }
      }
    }

    curNode = root;
    rightBound.add(root);
    // getting right bound
    if(root.right != null){
      while( ( curNode.right!= null || curNode.left != null) ){
        if(curNode.right != null) {
          rightBound.add(curNode.right);
          curNode = curNode.right;
        }else {
          rightBound.add(curNode.left);
          curNode = curNode.left;
        }
      }
    }

    // to post-order iteration to find leaves.
    postOrder(root, leaves);

    //System.out.println("left bound = " + Arrays.toString(leftBound.toArray()));
    //System.out.println("leaves = " + Arrays.toString(leaves.toArray()));
    //System.out.println("right bound = " + Arrays.toString(rightBound.toArray()));

    List<Integer> result = new ArrayList<>();
    Set<TreeNode> used = new HashSet<>();
    //System.out.println("hashset size = " + used.size());

    for(int i = 0; i < leftBound.size(); i++){
      TreeNode curNo = leftBound.get(i);
      if(!used.contains(curNo)){
        result.add(curNo.val);
        used.add(curNo);
      }
    }

    for(int i = 0; i < leaves.size(); i++){
      TreeNode curNo = leaves.get(i);
      if(!used.contains(curNo)){
        result.add(curNo.val);
        used.add(curNo);
      }
    }


    for(int i = rightBound.size() - 1; i >= 0; i--){
      TreeNode curNo = rightBound.get(i);
      if(!used.contains(curNo)){
        result.add(curNo.val );
        used.add(curNo);
      }
    }
    return result;
  }

  private void postOrder(TreeNode node, List<TreeNode> leaves){
    if(node == null) return;
    if(node.left != null){
      postOrder(node.left, leaves);
    }
    if(node.right != null){
      postOrder(node.right, leaves);
    }
    if(node.left == null && node.right == null){
      leaves.add(node);
    }
  }
}

