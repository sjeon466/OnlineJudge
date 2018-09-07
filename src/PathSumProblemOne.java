import java.util.ArrayList;
import java.util.List;

/**
 * Created by sjeon on 3/18/2018.
 */
public class PathSumProblemOne {
    public static void solve(){
        TreeNode root = initialize();
        PathSumProblemOne PPO = new PathSumProblemOne();
        PrintUtil.printNestedArrayList(PPO.pathSum(root, 22));
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum){
        List<List<Integer>> resultList = new ArrayList<List<Integer>>();
        List<Integer> tempList = new ArrayList<Integer>();
        helper(root, resultList, tempList, sum);
        return resultList;
    }
    private void helper(TreeNode node, List<List<Integer>> resultList, List<Integer> tempList, int sum) {
        if(node == null) return;
        if(sum - node.val == 0 && node.left == null && node.right == null){
            tempList.add(node.val);
            resultList.add(new ArrayList<>(tempList));
            tempList.remove(tempList.size()-1);
        }

        tempList.add(node.val);
        helper(node.left, resultList, tempList, sum - node.val);
        helper(node.right, resultList, tempList, sum - node.val);
        tempList.remove(tempList.size() - 1);
        return;
    }


    public static TreeNode initialize(){
        TreeNode root = new TreeNode(5);
        TreeNode firstFour = new TreeNode(4);
        TreeNode eight = new TreeNode(8);
        TreeNode eleven = new TreeNode(11);
        TreeNode thirteen = new TreeNode(13);
        TreeNode secondFour = new TreeNode(4);
        TreeNode seven = new TreeNode(7);
        TreeNode two = new TreeNode(2);
        TreeNode five = new TreeNode(5);
        TreeNode one = new TreeNode(1);
        root.left = firstFour;
        root.right = eight;
        firstFour.left = eleven;
        eleven.left = seven;
        eleven.right = two;
        eight.left = thirteen;
        eight.right = secondFour;
        secondFour.left = five;
        secondFour.right = one;

        return root;
    }
}
