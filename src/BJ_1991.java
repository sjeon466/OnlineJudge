
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

class TreeNodeChar{
  TreeNodeChar left;
  TreeNodeChar right;
  char val;
  public TreeNodeChar(char val){
    this.val = val;
  }
}

public class BJ_1991 {
    private static Scanner sc;
  public static void main(){
    sc = new Scanner(System.in);
    Map<Character, TreeNodeChar> treeMap = new HashMap<>();
    TreeNodeChar root = generateTree(treeMap);
    preOrder(root);
    System.out.println();
    inOrder(root);
    System.out.println();
    postOrder(root);
  }

  private static TreeNodeChar generateTree(Map<Character, TreeNodeChar> treeMap) {
    int numNodes = sc.nextInt();
    TreeNodeChar root = null;
    for(int i=0; i<numNodes; i++){
      char curChar = sc.next().charAt(0);
      char leftChar = sc.next().charAt(0);
      char rightChar = sc.next().charAt(0);

      if(!treeMap.containsKey(curChar)){
        TreeNodeChar curNode = new TreeNodeChar(curChar);
        treeMap.put(curChar, curNode);
        if(i==0) root = curNode;
      }

      if(leftChar != '.' && (!treeMap.containsKey(leftChar))){
        TreeNodeChar leftNode = new TreeNodeChar(leftChar);
        treeMap.put(leftChar,leftNode);
      }
      treeMap.get(curChar).left = treeMap.get(leftChar);

      if(rightChar != '.' && (!treeMap.containsKey(rightChar))){
        TreeNodeChar rightNode = new TreeNodeChar(rightChar);
        treeMap.put(rightChar, rightNode);
      }
      treeMap.get(curChar).right = treeMap.get(rightChar);
    }
    return root;
  }

  private static void inOrder(TreeNodeChar node){
    if(node == null) return;
    inOrder(node.left);
    System.out.print(node.val);
    inOrder(node.right);
  }

  private static void postOrder(TreeNodeChar node){
    if(node == null) return;
    postOrder(node.left);
    postOrder(node.right);
    System.out.print(node.val);
  }

  private static void preOrder(TreeNodeChar node){
    if(node == null) return;
    System.out.print(node.val);
    preOrder(node.left);
    preOrder(node.right);
  }
}
