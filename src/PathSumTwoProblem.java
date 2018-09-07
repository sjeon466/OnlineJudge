
import java.util.*;

/**
 * Created by sjeon on 3/14/2018.
 */
public class PathSumTwoProblem {


    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> resList = new ArrayList<List<Integer>>();
        List<Integer>tempList = new ArrayList<Integer>();
        psHelper(root, sum, tempList,resList);
        return resList;
    }
    private void psHelper(TreeNode node, int sum, List<Integer> tempList, List<List<Integer>> resList) {
        if(node == null){
            return;
        }
        tempList.add(node.val);
        if(node.left == null && node.right == null && node.val == sum){
            resList.add(new ArrayList<>(tempList));
            tempList.remove(tempList.size()-1);
            return;
        } else{
            psHelper(node.left, sum - node.val, tempList, resList);
            psHelper(node.right, sum - node.val, tempList, resList);
        }

        tempList.remove(tempList.size()-1);
        return;
    }


    public static TreeNode initialize(){
        TreeNode root = new TreeNode(2);
        TreeNode seven = new TreeNode(7);
        TreeNode three = new TreeNode(3);
        TreeNode one = new TreeNode(1);
        TreeNode four = new TreeNode(4);
        root.left = seven;
        root.right = three;
        three.left = one;
        three.right = four;
        return root;
    }

    public static void solve(){
        TreeNode root = initialize();
        PathSumTwoProblem ps = new PathSumTwoProblem();
        ps.pathSum(root, 9);
    }
}

