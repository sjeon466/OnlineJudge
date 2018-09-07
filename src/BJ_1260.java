import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import java.util.concurrent.CopyOnWriteArrayList;
public class BJ_1260 {
  static int numVertices;
  static int numEdges;
  static int startV;
  static Scanner sc = new Scanner(System.in);
  static int[][] adjMatrix;
  static ArrayList<ArrayList<Integer>> adjList;
  static boolean[] visited;

  public static void main(){
    numVertices = sc.nextInt();
    numEdges = sc.nextInt();
    startV = sc.nextInt();
    visited = new boolean[numVertices + 1];
    fillAdjacencyMatrixAndList();

    DFS_AdjacencyMatrix(1);
    Arrays.fill(visited, false);
    System.out.println();
    BFS_AdjacencyMatrix();

    //DFS_AdjacencyList(1);
    //Arrays.fill(visited, false);
    //System.out.println();
    //BFS_AdjacencyList();

  }
  public static void fillAdjacencyMatrixAndList(){
    //initializing matrix
    adjMatrix = new int[numVertices + 1][numVertices + 1];

    //initializing list
    adjList = new ArrayList<ArrayList<Integer>>();
    adjList.ensureCapacity(10);
    for(int i=0;i<=numVertices; i++) {
      adjList.add(new ArrayList<Integer>());
    }

    for(int i=0; i < numEdges; i++){
      // filling out the matrix
      int beginV = sc.nextInt();
      int endV = sc.nextInt();
      adjMatrix[beginV][endV] = adjMatrix[endV][beginV] = 1;
      // filling out the list
      adjList.get(beginV).add(endV);
      adjList.get(endV).add(beginV);
    }
  }

  public static void BFS_AdjacencyList(){
    StringBuilder sb = new StringBuilder();
    Queue<Integer> myQueue = new LinkedList<Integer>();
    visited[1] = true;
    myQueue.offer(1);

    while(!myQueue.isEmpty()){
      int val = myQueue.poll();

      //sb.append(val + " -> ");
      sb.append(val + " ");
      ArrayList<Integer> list = adjList.get(val);
      for(int i=0; i<list.size(); i++){
        int arVal = list.get(i);
        if(!visited[arVal]){
          myQueue.offer(arVal);
          visited[arVal] = true;
        }
      }
    }
    //System.out.println(sb.delete(sb.length()-4, sb.length()-1).toString());
    System.out.println(sb.delete(sb.length()-1, sb.length()).toString());
    Arrays.fill(visited, false);
  }

  public static void DFS_AdjacencyList(int visitedVal){
    if(visited[visitedVal]){
      return;
    }else{
      System.out.print(visitedVal + " ");
      visited[visitedVal] = true;
      ArrayList<Integer> list = adjList.get(visitedVal);
      for(int i=0; i< list.size(); i++){
        int listVal = list.get(i);
        if(!visited[listVal]){
          DFS_AdjacencyList(listVal);
        }
      }
    }
  }

  public static void BFS_AdjacencyMatrix(){
    Queue<Integer> myQueue = new LinkedList<Integer>();
    myQueue.offer(1);
    System.out.print(1 + " ");
    visited[1] = true;

    while(!myQueue.isEmpty()){
      int curStartVal = myQueue.poll();
      System.out.print(curStartVal + " ");
      for(int i=1; i<= numVertices; i++){
        if(adjMatrix[curStartVal][i] == 1 && visited[i] == false){
          visited[i] = true;
          myQueue.offer(i);
        }
      }
    }
    Arrays.fill(visited,false);
  }

  public static void DFS_AdjacencyMatrix(int visitedVal){
    visited[visitedVal] = true;
    System.out.print(visitedVal + " ");

    for(int i=1; i<= numVertices;i++){
      //it is an edge, examine
      if(adjMatrix[visitedVal][i] == 1 && visited[i] == false){
          DFS_AdjacencyMatrix(i);

      }
    }
  }

}
