import java.util.ArrayList;
import java.util.List;

/**
 * Created by sjeon on 3/21/2018.
 */
public class ConvertBSTtoGreaterValue {


    public TreeNode convertBST(TreeNode root) {
        List<Integer> sumList = new ArrayList<>();
        helper(root, sumList);
        for(int i = sumList.size()-2; i >= 0; i--){
            sumList.set(i, sumList.get(i+1) + sumList.get(i));
        }
        helper2(root, sumList);
        return root;
    }

    public  void helper(TreeNode node, List<Integer> sList){
        if(node == null) return;
        helper(node.left, sList);
        sList.add(node.val);
        helper(node.right, sList);
    }


    int i = 0;
    public void helper2(TreeNode node, List<Integer> sList){
        if(node == null) return;
        helper2(node.left, sList);
        node.val = sList.get(i++);
        helper2(node.right, sList);
    }


    public static TreeNode initialize() {
        TreeNode root = new TreeNode(5);
        TreeNode two = new TreeNode(2);
        TreeNode thirteen = new TreeNode(13);

        root.left = two;
        root.right = thirteen;
        return root;
    }

    public static void solve() {
        ConvertBSTtoGreaterValue CBST = new ConvertBSTtoGreaterValue();
        TreeNode root = initialize();
        CBST.convertBST(root);
    }
}
