import java.util.ArrayList;
import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class BJ_11725 {
  private static Scanner sc = new Scanner(System.in);
  public static void main(){
    int numNodes = sc.nextInt();
    ArrayList<Integer> [] arr = (ArrayList<Integer>[]) new ArrayList[numNodes+ 1];
    for(int i=1; 1<= numNodes; i++){
      arr[i] = new ArrayList<Integer>();
    }

    //making connections
    for(int i=0; i< numNodes-1; i++){
      int nodeA = sc.nextInt();
      int nodeB = sc.nextInt();
      arr[nodeA].add(nodeB);
      arr[nodeB].add(nodeA);
    }

    boolean[] visited = new boolean[numNodes + 1];
    int[] parentOf = new int[numNodes + 1];
    Queue<Integer> myQueue = new LinkedList<Integer>();

    myQueue.add(1);
    visited[1] = true;

    while(!myQueue.isEmpty()){
      int curNode = myQueue.remove();
      for(int node : arr[curNode]){
        if(visited[node] == false){
          visited[node] = true;
          parentOf[node] = curNode;
          myQueue.add(node);
        }
      }
    }
    for(int i=2; i <= numNodes; i++){
      System.out.println(parentOf[i]);
    }
  }
}
