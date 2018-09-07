  class TriiNode {
    int val;
    TriiNode left;
    TriiNode right;
    TriiNode(int x) { val = x; }
  }
public class LC_536 {
  // class variable to be use within this class, "class-wide"
  private int index = 0;

  public static void main(){
    LC_536 l = new LC_536();
    TriiNode root = l.str2tree("4(2(3)(1))(6(5))");
  }

  public TriiNode str2tree(String str) {
    if(str == null || str.equals("")) return null;
    return dfsHelper(str);
  }

  private TriiNode dfsHelper(String str) {
    TriiNode root = null;
    if(str.charAt(index) != '('){
      root = new TriiNode(getIntVal(str));
    }

    TriiNode leftNode = null, rightNode = null;
    if(index < str.length() && str.charAt(index) == '('){
      //for the possible leftNode, if '(' met.
      index++;
      leftNode = dfsHelper(str);
    }



    return null;
  }

  private int getIntVal(String str){
    StringBuilder sb = new StringBuilder();
    while(index < str.length()){
      if(str.charAt(index) == '(' || str.charAt(index) == ')')  break;
      sb.append(str.charAt(index++));
    }
    return Integer.valueOf(sb.toString());
  }


  public TriiNode str2tree2(String str) {
    if(str == null) return null;
    TriiNode root = new TriiNode(str.charAt(0) - '0' );
    strToTreeHelper(str, 0, root);
    System.out.println("done");
    return root;
  }

  //  4 ( 2 ( 3 ) ( 1 ) ) ( 6 ( 5 ) )
  //                      1 1 1 1 1 1
  //  0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5

  private int strToTreeHelper(String str, int index, TriiNode parentNode){
    //immediate left child exist, go deeper
    if(str.charAt(index + 1) == '('){
      TriiNode leftNode = new TriiNode(str.charAt(index + 2) - '0');
      parentNode.left = leftNode;
      strToTreeHelper(str, index + 2, leftNode);
      //if right node does not exist
      if(index + 2 >= str.length() || str.charAt(index + 2) == ')' ){
        return -1;
      }
      TriiNode rightNode = new TriiNode(str.charAt(index + 2) - '0');
      parentNode.right = rightNode;
      strToTreeHelper(str, index + 2, rightNode);
    }else{
      //reached the end
      return -2;
    }
    return -2;
  }
}