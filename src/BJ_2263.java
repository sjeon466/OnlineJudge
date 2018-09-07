import java.util.Scanner;

class Nodee{
  int val;
  public Nodee(int val){
    this.val = val;
  }
}

public class BJ_2263 {
  private static Scanner sc = new Scanner(System.in);
  private static int[] inOrder;
  private static int[] postOrder;
  private static int[] positionArr;
  public static void main() {
    int numOfElements = sc.nextInt();
    inOrder = new int[numOfElements];
    postOrder = new int[numOfElements];

    //contains positions of the given val in InOrder (1~N)
    positionArr = new int[numOfElements + 1];

    for(int i=0; i < numOfElements; i++){
      inOrder[i] = sc.nextInt();
    }

    for(int i=0; i < numOfElements; i++){
      postOrder[i] = sc.nextInt();
    }

    for(int i = 0; i < numOfElements; i++){
      positionArr[inOrder[i]] = i;
    }

    int rootIndexPostOrder = numOfElements - 1;

    Nodee root = new Nodee(postOrder[rootIndexPostOrder]);
    convert(0, rootIndexPostOrder, 0, rootIndexPostOrder);
    //printPreOrder(root);
  }

  private static void convert(int inOrderStart, int inOrderEnd, int postOrderStart, int postOrderEnd) {

    if(inOrderStart > inOrderEnd || postOrderStart > postOrderEnd) return;

    int rootVal = postOrder[postOrderEnd];
    System.out.printf("%d ", rootVal);

    //int rootIndexPostOrder = postOrderEnd;

    //find root in the inOrder
    int rootIndexInsideInorder =  positionArr[rootVal];

    //Arrays.asList(inOrder).indexOf(rootNode.val);

    // inorder : in_start (root_in_Inorder)  in_end
    // postorder : post_start post_end
    // leftCount : root_In_Inorder - (in_start)
    // rightCount : (in_end) - root_In_Inorder

    int leftCount = rootIndexInsideInorder - inOrderStart;
    convert(inOrderStart, rootIndexInsideInorder - 1, postOrderStart, postOrderStart + leftCount - 1);
    convert(rootIndexInsideInorder + 1, inOrderEnd, postOrderStart + leftCount , postOrderEnd - 1);
  }

  /*  private static int findIndex(int[] arr, int val){
      for(int i=0; i < arr.length; i++){
        if(arr[i] == val) return i;
      }
      return -1;
    }*/

  /*  private static void printPreOrder(Nodee root){
      if(root == null) return;
      System.out.print(root.val + " ");
      printPreOrder(root.left);
      printPreOrder(root.right);
    }*/
}
