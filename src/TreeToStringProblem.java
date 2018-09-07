import java.util.HashSet;
import java.util.Stack;
import java.util.Set;

/**
 * Created by sjeon on 3/19/2018.
 */
public class TreeToStringProblem {

    public static void solve(){
        TreeNode root = initialize();
        TreeToStringProblem tp = new TreeToStringProblem();
        System.out.println(tp.tree2str_iterative(root));
    }

    //iterative solution
    public String tree2str_iterative(TreeNode node){
        Stack<TreeNode> nodeStack = new Stack<TreeNode>();
        Set<TreeNode> visited = new HashSet<TreeNode>();
        StringBuffer sb = new StringBuffer();
        //if root is null
        if(node == null) return sb.toString();

        nodeStack.push(node);
        while(!nodeStack.empty()){
            TreeNode temp = nodeStack.peek();
            // new node
            if(!visited.contains(temp)){
                sb.append("(").append(node.val);
                if(temp.left == null && temp.right != null){
                    sb.append("()");
                }
                if(temp.left != null){
                    nodeStack.push(temp.left);
                }
                if(temp.right != null){
                    nodeStack.push((temp.right));
                }
            }else{
                nodeStack.pop();
                sb.append(")");
            }
        }
        return sb.substring(1,sb.length()-2).toString();
    }


    public String tree2str2(TreeNode node){
        StringBuffer sb = new StringBuffer();
        treeStrHelper(node, sb);
        return (sb.length() > 0) ?  sb.substring(1,sb.length()-1) : sb.toString();
    }

    private void treeStrHelper(TreeNode node, StringBuffer buffer) {
        if(node == null) return;
        buffer.append("(").append(node.val);
        if((node.left== null && node.right != null)){
            buffer.append("()");
        }
        treeStrHelper(node.left, buffer);
        treeStrHelper(node.right, buffer);
        buffer.append((")"));
    }


    public String tree2strHelper(TreeNode node){
        //initial case when given root is null
        if(node == null) return "";
        StringBuffer sb = new StringBuffer();
        sb.append("(").append(String.valueOf(node.val));

        //if the node is leaf then return
        if(node.left == null && node.right == null){
            return sb.append(")").toString();
        }

        //only has right child empty parenthesis needed
        if(node.left == null){
            sb.append("()").append(tree2strHelper(node.right));
        }else if(node.right == null){
            //has only right child
            sb.append(tree2strHelper(node.left));
        }else{
            sb.append(tree2strHelper(node.left)).append(tree2strHelper(node.right));
        }
        return sb.append(")").toString();
    }

    public static TreeNode initialize(){
        TreeNode root = new TreeNode(1);
        TreeNode firstFour = new TreeNode(4);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);

        root.left = two;
        root.right = three;
        two.right = firstFour;
        return root;
    }
}
