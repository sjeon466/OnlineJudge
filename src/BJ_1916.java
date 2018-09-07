import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BJ_1916 {

  static class Edge{
    int to;
    int weight;
    public Edge(int to, int weight){
      this.to = to;
      this.weight = weight;
    }
  }

  static Scanner sc = new Scanner(System.in);
  static final int INF = 1000000000;

  public static void main(){

    // make a adjacency list
    int numVs = sc.nextInt();
    int numEs = sc.nextInt();
    List<List<Edge>> adjList = generateAdjList(numVs, numEs);

    int startCity = sc.nextInt();
    int endCity = sc.nextInt();

    int[] dist = new int[numVs + 1];
    boolean[] checked = new boolean[numVs + 1];
    Arrays.fill(dist, Integer.MAX_VALUE);
    dist[0] = 0;

    for(int i = 0; i < numVs - 1; i++){
      //find the node with smallest distance.


      for(int j = 1; j <= numVs; j++){
       // if(checked[j] == false && dist[j]  )
      }


    }
  }

  private static List<List<Edge>> generateAdjList(int numVs, int numEs) {
    List<List<Edge>> adjList = new ArrayList<List<Edge>>(numVs + 1);
    for(int i = 0 ; i <= numVs; i++){
      adjList.add(new ArrayList<Edge>());
    }

    for(int i = 0; i <= numVs; i++){
      int start = sc.nextInt();
      int end = sc.nextInt();
      int weight = sc.nextInt();
      adjList.get(start).add(new Edge(end, weight));
      //adjList.get(end).add(new Edge(start, weight));
    }
    return adjList;
  }
}
