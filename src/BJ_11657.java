import java.util.*;

public class BJ_11657 {
  static class Edge{
    int start, end, cost;
    public Edge(int start, int end, int cost){
      this.start = start;
      this.end = end;
      this.cost = cost;
    }
  }
  public static void main(){
    Scanner sc = new Scanner(System.in);
    int numVs = sc.nextInt();
    int numEs = sc.nextInt();

    //List<Edge>[] nodes = new List[numVs + 1];
    Edge[] edges = new Edge[numVs + 1];
    int[] costs = new int[numVs + 1];

    for(int i = 0; i <= numVs; i++){
      costs[i] = Integer.MAX_VALUE;
    }
    /*
    for(int i = 0; i < numVs + 1; i++){
      nodes[i] = new ArrayList<Edge>();
    }
    */
    costs[1] = 0;
    boolean negative_cycle = false;

    for(int i = 0; i < numEs; i++){
      int start = sc.nextInt();
      int end = sc.nextInt();
      int cost = sc.nextInt();
      //nodes[start].add(new Edge(start, end ,cost));
      edges[i] = new Edge(start, end, cost);
    }

    // with bellman-ford algorithm,
    // the maximum edges to reach from one to anyone will be at most
    // numVertex - 1 because same node will not be visited twice.
    // traverse all numEdges numVertex - 1 times will guarantee
    // dist[] to be populated with the smallest length
    // if traversing is done numVertex times, and if the smaller dist is found for
    // any of the vertices, then there is a negative cycle where provides invalid answers
    // for some of the vertices.

    for(int numTrial = 1; numTrial <= numVs; numTrial++){
      for(int j = 0; j < edges.length; j++){
        int start = edges[j].start;
        int end = edges[j].end;
        int cost = edges[j].cost;

        if(costs[start] != Integer.MAX_VALUE && costs[start] + cost < costs[end]){
          if(numTrial == numVs){
            negative_cycle = true;
          }
          costs[end] = costs[start] + cost;
        }
      }
    }
    if(negative_cycle){
      System.out.println(-1);
    }else{
      for(int i = 1; i <= numVs; i++){
        if(costs[i] == Integer.MAX_VALUE) costs[i] = -1;
        System.out.println(costs[i]);
      }
    }
  }
}
