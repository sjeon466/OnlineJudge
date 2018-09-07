import java.util.*;

public class LC_297 {
  public static void main(){
    TreeNode root = generateTree();
    // Your Codec object will be instantiated and called as such:
    // Codec codec = new Codec();
    // codec.deserialize(codec.serialize(root));

    Codec codec = new Codec();
    //System.out.println(codec.serialize(root));
    codec.deserialize(codec.serialize(root)) ;
    //System.out.println("done");

  }

  private static TreeNode generateTree() {
    TreeNode root = new TreeNode(4);

    TreeNode left_1 = new TreeNode(7);
    TreeNode right_2 = new TreeNode(10);
    root.left = left_1; root.right = right_2;

    TreeNode left_2 = new TreeNode(8);
    left_1.left = left_2;

    TreeNode right_3 = new TreeNode(20);
    TreeNode left_4 = new TreeNode(5);
    right_2.left = right_3;
    right_2.right = left_4;

    return root;
  }
}

 class Codec {

   // Encodes a tree to a single string.
   public String serialize(TreeNode root) {
     StringBuilder sb = new StringBuilder();
     preOrder(root , sb);
     sb.deleteCharAt(sb.length() - 1);
     //System.out.println(sb.toString());
     return sb.toString();
   }

   private void preOrder(TreeNode node, StringBuilder sb) {
     if(node == null) {
       sb.append("X,");
       return;
     }
     sb.append(node.val+",");
     preOrder(node.left, sb);
     preOrder(node.right, sb);
   }

   // Decodes your encoded data to tree.
   public TreeNode deserialize(String data) {
     // preOrder reconstruction

     Queue<String> nodes = new LinkedList<>();
     nodes.addAll(Arrays.asList( data.split(","))) ;
     return buildTree(nodes);
   }

   private TreeNode buildTree(Queue<String> nodes) {
     TreeNode curNode = null;
     String curNodeString = nodes.poll();
     if(!curNodeString.equals("X")){
       curNode = new TreeNode(Integer.parseInt(curNodeString));
       curNode.left = buildTree(nodes);
       curNode.right = buildTree(nodes);
     }
     return curNode;
   }


   // Encodes a tree to a single string.
  public String serialize2(TreeNode root) {
    if(root == null) return "";
    //List<Integer> treeNodeList =  new ArrayList<>();
    Map<Integer, Integer>  treeMap = new HashMap<>();
    preOrder(treeMap, 0, root);

    //Arrays.toString(treeNodeList.toArray());

    StringBuilder sb = new StringBuilder();
    for(int node : treeMap.keySet()){
      sb.append(node + "@" + treeMap.get(node) + ",");
    }
    sb.deleteCharAt(sb.length()-1);
    //System.out.println(sb.toString());
    return sb.toString();
  }

  private void preOrder(Map<Integer, Integer> treeMap, int parentIndex, TreeNode parent){
    if(parent == null) return;
    //System.out.println("Putting: " + parent.val  + " @ index: " + parentIndex);
    treeMap.put(parent.val, parentIndex);
    //treeNodeList.add(parentIndex, parent.val);
    //int newRightIndex = parentIndex * 2 + 2;
    //int curListSize = treeNodeList.size();
    //for(int i = curListSize; i <= newRightIndex; i++){
    //  treeNodeList.add(null);
    //}

    preOrder(treeMap, parentIndex * 2 + 1, parent.left);
    preOrder(treeMap, parentIndex * 2 + 2, parent.right);
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize2(String data) {

    //  index     val
    Map<Integer, TreeNode> indexToNodeMap = new HashMap<Integer, TreeNode>();
    //Map<Integer, TreeNode> valToNodeMap = new HashMap<Integer, TreeNode>();
    Map<TreeNode, Integer> nodeToIndexMap = new HashMap<TreeNode, Integer>();

    //Set<TreeNode> treeSet = new HashSet<>();
    String[] nodes = data.split(",");

    for(int i = 0; i < nodes.length; i++){
      //nodeVal[i] = Integer.parseInt( nodes[i].split("@")[0] );
      //nodeIndex[i] = Integer.parseInt( nodes[i].split("@")[1] );
      String[] curNode = nodes[i].split("@");
      TreeNode node = new TreeNode(Integer.parseInt(curNode[0]));
      indexToNodeMap.put(Integer.parseInt( curNode[1] ), node);
      //valToNodeMap.put(Integer.parseInt( curNode[0] ), node);
      nodeToIndexMap.put(node, Integer.parseInt( curNode[1] ));
    }

    Set<TreeNode> visitedNodes  = new HashSet<>();
    Queue<TreeNode> bfsNodeQueue = new LinkedList<>();
    TreeNode root = indexToNodeMap.get(0);

    bfsNodeQueue.offer(root);

    while(!bfsNodeQueue.isEmpty()){
      TreeNode curNode = bfsNodeQueue.poll();
      int curNodeIndex = nodeToIndexMap.get(curNode);
      if(!visitedNodes.contains(curNode)){
        int leftIndex = curNodeIndex * 2 + 1;
        int rightIndex = curNodeIndex * 2 + 2;
        if(indexToNodeMap.get(leftIndex) != null){
          indexToNodeMap.get(curNodeIndex).left = indexToNodeMap.get(leftIndex);
          bfsNodeQueue.add(indexToNodeMap.get( leftIndex ) );
        }
        if(indexToNodeMap.get(rightIndex) != null){
          indexToNodeMap.get(curNodeIndex).right = indexToNodeMap.get(rightIndex);
          bfsNodeQueue.add(indexToNodeMap.get( rightIndex ) );
        }
        visitedNodes.add(curNode);
      }
    }
    return root;
  }
}