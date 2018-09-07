/**
 * Created by sjeon on 3/18/2018.
 */
public class PathSumProblemThree {

    Integer sumCount = 0;

    public static void solve(){
        TreeNode root = initialize();
        PathSumProblemThree ps = new PathSumProblemThree();

        System.out.println(ps.pathSum(root, 8));
    }

    public int pathSum(TreeNode root, int sum) {
        if(root == null) return sumCount;
        if(sum - root.val == 0){
            sumCount++;
        }
        pathSum(root.left, sum - root.val);
        pathSum(root.left, sum);
        pathSum(root.right, sum - root.val);
        pathSum(root.right, sum);
        return sumCount;
    }

    public static TreeNode initialize2(){
        TreeNode root = new TreeNode(10);
        TreeNode five = new TreeNode(5);
        TreeNode negThree = new TreeNode(-3);
        TreeNode firstThree = new TreeNode(3);
        TreeNode two = new TreeNode(2);
        root.left = five;
        root.right = negThree;
        five.left = firstThree;
        five.right = two;
        return root;
    }


    public static TreeNode initialize(){
        TreeNode root = new TreeNode(10);
        TreeNode five = new TreeNode(5);
        TreeNode negThree = new TreeNode(-3);
        TreeNode firstThree = new TreeNode(3);
        TreeNode two = new TreeNode(2);
        TreeNode eleven = new TreeNode(11);
        TreeNode secondThree = new TreeNode(3);
        TreeNode negTwo = new TreeNode(-2);
        TreeNode one = new TreeNode(1);
        root.left = five;
        root.right = negThree;
        five.left = firstThree;
        five.right = two;
        firstThree.left =secondThree;
        firstThree.right = negTwo;
        two.right = one;
        negThree.right =eleven;
        return root;
    }
}
