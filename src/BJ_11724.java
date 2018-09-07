import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class BJ_11724 {
  private static int[][] adjMatrix;
  private static List<Integer>[] adjList;
  private static int numVs;
  private static int numEs;
  private static Scanner sc;
  private static boolean[] visited;

  public static void main() {
    sc = new Scanner(System.in);
    numVs = sc.nextInt();
    numEs = sc.nextInt();
    generateAdjMatrixAndList();
    visited = new boolean[numVs + 1] ;
    sc.close();
    //System.out.println();
    //System.out.println(findComponentsUsingBFSMatrix());
    //System.out.println(countComponents(numVs, adjMatrix));
    //BFS_Matrix(1);
    //System.out.println(findComponentsUsingBFSList());
    //BFS_ArrList(1);
    //System.out.println(findComponentsUsingComponents());
    //System.out.println(findComponentsUsingDFSMatrix());
    //System.out.println(findComponentsUsingDFSList());
    //DFS_Matrix(1);
    //System.out.println(Arrays.deepToString(adjMatrix));
    //print2DArray(adjMatrix);
    //printArrayOfList(adjList);
}

/*  public static int countComponents(int numVss, int[][] adjMatrixs) {
    return findComponentsUsingBFSMatrix();
  }*/

  public static int findComponentsUsingBFSMatrix(){
    int numComponents = 0;
    for(int i=1; i<=numVs; i++){
      if(visited[i] == false){
        BFS_Matrix(i);
        numComponents++;
      }
    }
    return numComponents;
  }

  public static int findComponentsUsingBFSList(){
    int numComponents = 0;
    for(int i=1; i<=numVs; i++){
      if(visited[i] == false){
        BFS_ArrList(i);
        numComponents++;
      }
    }
    return numComponents;
  }

  public static int findComponentsUsingDFSList(){
    int numComponents = 0;
    for(int i=1; i<=numVs; i++){
      if(visited[i] == false){
        DFS_ArrList(i);
        numComponents++;
      }
    }
    return numComponents;
  }
  public static int findComponentsUsingDFSMatrix(){
    int numComponents = 0;
    for(int i=1; i<=numVs; i++){
      if(visited[i] == false){
        DFS_Matrix(i);
        numComponents++;
      }
    }
    return numComponents;
  }

  public static void DFS_Matrix(int visitedVal){
    if(visited[visitedVal]){
      return;
    }
    //System.out.print(visitedVal);
    visited[visitedVal] = true;

    //loop through the adjacent vertices
    for(int i=1; i<= numVs; i++){
      if(adjMatrix[visitedVal][i] == 1 && visited[i] == false){
        DFS_Matrix(i);
      }
    }
  }

  private static void BFS_Matrix(int startVertex){
    Queue<Integer> bfsQueue = new LinkedList<Integer>();
    bfsQueue.offer(startVertex);
    visited[startVertex] = true;


    while(!bfsQueue.isEmpty()){
     int curVisitedVertex = bfsQueue.poll();
      //System.out.println(curVisitedVertex + "  ");
     //check its adj vertices
      for(int i=1; i<= numVs; i++){
        int curAdjVertex = i;
        if(adjMatrix[curVisitedVertex][curAdjVertex] == 1 && visited[curAdjVertex] == false){
          bfsQueue.offer(curAdjVertex);
          visited[curAdjVertex] = true;
        }
      }
    }
  }
  public static void DFS_ArrList(int visitedVal){
    if(visited[visitedVal]){
      return;
    }
    visited[visitedVal] = true;

    // check adjacent vertices
    for(int i=0; i< adjList[visitedVal].size(); i++){
      int curAdjVertex = adjList[visitedVal].get(i);
      if(visited[curAdjVertex] == false){
        DFS_ArrList(curAdjVertex);
      }
    }
  }

  private static void BFS_ArrList(int startVertex){
    Queue<Integer> bfsQueue = new LinkedList<Integer>();
    visited[startVertex] = true;
    bfsQueue.offer(startVertex);

    while(!bfsQueue.isEmpty()){
      int curVisitedVal = bfsQueue.poll();
      //System.out.print(curVisitedVal + "    ");

      for(int i=0; i<adjList[curVisitedVal].size(); i++){
        int curAdjVal = adjList[curVisitedVal].get(i);
        if(visited[curAdjVal] == false){
          visited[curAdjVal] = true;
          bfsQueue.offer(curAdjVal);
        }
      }
    }
  }

  private static void generateAdjMatrixAndList(){
    adjMatrix = new int[numVs+1][numVs+1];

    adjList = new List[numVs + 1];

    for(int i=0; i<=numVs; i++){
      adjList[i] = new ArrayList<>();
    }

    /*for(int i=0;i<= numVs; i++){
      adjList.add(new ArrayList<Integer>());
    }*/

    for(int i=1; i<=numEs; i++){
      int vBegin = sc.nextInt();
      int vEnd = sc.nextInt();
      //System.out.println("put: " + vBegin + " " + vEnd );

      adjMatrix[vBegin][vEnd] = adjMatrix[vEnd][vBegin] = 1;
      //adjList.get(vBegin).add(vEnd);
      adjList[vBegin].add(vEnd);
      //adjList.get(vEnd).add(vBegin);
      adjList[vEnd].add(vBegin);
    }
  }

  private static void print2DArray(int[][] matrix){
    for(int[] curRow : matrix){
      for(int curVal : curRow){
        System.out.print(curVal+ " ");
      }
      System.out.println();
    }
  }

  private static void printArrayOfList(List<Integer>[] arrOfList){
    int index=0;
    for(List<Integer> list : arrOfList){
      System.out.print("[" + index++ + "]" + ": ");
      for(int curVal : list){
        System.out.print(curVal + " ");
      }
      System.out.println();
    }
  }
}