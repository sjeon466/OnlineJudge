import sun.reflect.generics.tree.Tree;
import java.util.Stack;
public class LC_173 {
  public static void main() {
    TreeeNode root = generateTree();
    /**
     * Your BSTIterator will be called like this:
     * BSTIterator i = new BSTIterator(root);
     * while (i.hasNext()) v[f()] = i.next();
     */
    BSTIterator i = new BSTIterator(root);
    while(i.hasNext()){
      System.out.print(i.next() + " ");
    }
  }

  private static TreeeNode generateTree(){
    TreeeNode root = new TreeeNode(10);
    TreeeNode seven = new TreeeNode(7);
    TreeeNode four = new TreeeNode(4);
    TreeeNode nine = new TreeeNode(9);
    TreeeNode twenty = new TreeeNode(20);
    TreeeNode thirteen = new TreeeNode(13);
    TreeeNode thirtyFive = new TreeeNode(35);
    root.left = seven;
    seven.left = four;
    seven.right = nine;
    root.right = twenty;
    twenty.left = thirteen;
    twenty.right = thirtyFive;
    return root;
  }
}
class BSTIterator {
  private Stack<TreeeNode> stk = new Stack<TreeeNode>();
  /*TreeeNode root;
  TreeeNode curNode;*/
  public BSTIterator(TreeeNode root) {
    pushAll(root);
  }

  private void pushAll(TreeeNode node){
    for(; node != null;  stk.push(node), node = node.left);
  }
  /**
   * @return whether we have a next smallest number
   */
  public boolean hasNext() {
    //return this.curNode == null ? false : true;
    return (!stk.isEmpty());
  }

  /**
   * @return the next smallest number
   */
  public int next() {
    TreeeNode tmpNode = stk.pop();
    pushAll(tmpNode.right);
    return tmpNode.val;
  }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */

// Definition for binary tree
class TreeeNode {
  int val;
  TreeeNode left;
  TreeeNode right;

  TreeeNode(int x) {
    val = x;
  }
}