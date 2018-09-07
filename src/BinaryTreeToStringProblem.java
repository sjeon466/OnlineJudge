/**
 * Created by sjeon on 3/21/2018.
 */
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;

public class BinaryTreeToStringProblem {
    public static void solve(){
        BinaryTreeToStringProblem bp = new BinaryTreeToStringProblem();
        TreeNode rt = bp.str2tree("4(2(3)(1)(6(5))");
        System.out.println("finished");
    }

    //recursion
    // if {,
    //        if within the already opened bracket
    //          make a left child
    //        else
    //          make right child
    // if },
    //         return to the parent through going back to parent




    public TreeNode str2tree(String s) {
        return null;
    }



/*    public TreeNode str2tree(String s) {
        if(s == null) return null;

        // initialization of root
        TreeNode curNode = new TreeNode(Integer.valueOf(s.charAt(0))-48);
        Map<TreeNode,TreeNode> visitedToParent = new HashMap<TreeNode,TreeNode>();

        for(int i = 1; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                // number found
                TreeNode newNode = new TreeNode(Integer.valueOf(c)-48);
                if(visitedToParent.containsKey(curNode)){
                    curNode.right = newNode;
                }else{
                    curNode.left = newNode;
                    visitedToParent.put(newNode, curNode);
                }
                curNode = newNode;
                newNode = null;
            } else if(!isOpenBracket(c)){
                // closing bracket found
                boolean closingFound = true;
                curNode = visitedToParent.get(curNode);
            }else{
                continue;
            }
        }
        return curNode;
    }

    public boolean isOpenBracket(char c){
        return (c == '(');
    }*/
}
