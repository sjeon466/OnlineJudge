import java.util.*;

public class BJ_1922 {

  static boolean[] visited;
  static class Edge implements Comparable <Edge>{
    int start;
    int end;
    int weight;

    public Edge(int start, int end, int weight){
      this.start = start;
      this.end = end;
      this.weight = weight;
    }

    public Edge() {
      this(0,0,0);
    }

    /*    @Override public int compare(Edge e1, Edge e2){
          return Integer.compare(e1.weight, e2.weight);
        }*/
    @Override public int compareTo(Edge e2){
      return Integer.compare(this.weight, e2.weight);
      //this.weight - e2.weight;
    }
  }

  public static void main(){
    Scanner sc = new Scanner(System.in);
    int numVertices = sc.nextInt();
    int numEdges = sc.nextInt();
    visited = new boolean[numVertices + 1];
    List<List<Edge>> edges = new ArrayList<>(numVertices + 1);

    //initializing edges
    for(int i = 0; i <= numVertices; i++){
      edges.add(i, new ArrayList<Edge>());
    }

    for(int i = 0; i < numEdges; i++){
      int vertexA = sc.nextInt();
      int vertexB = sc.nextInt();
      int weight = sc.nextInt();
      edges.get(vertexA).add(new Edge(vertexA, vertexB, weight));
      edges.get(vertexB).add(new Edge(vertexB, vertexA, weight));
    }

    // start randomly with vertex1.

    visited[1] = true;

    Queue<Edge> pQueue = new PriorityQueue<Edge>();

    List<Edge> curEdges = edges.get(1);
    for(int i = 0; i < curEdges.size(); i++){
      pQueue.offer(curEdges.get(i));
    }
    int totalWeight = 0;

    for(int i = 0; i < numVertices - 1; i++){
      Edge curEdge = new Edge();
      while(!pQueue.isEmpty()){
        curEdge = pQueue.poll();
        if(!visited[curEdge.end]){
          break;
        }
      }
      visited[curEdge.end] = true;
      totalWeight += curEdge.weight;
      List<Edge> nextEdges = edges.get(curEdge.end);
      for(int j = 0; j < nextEdges.size(); j++){
        pQueue.offer(nextEdges.get(j));
      }
    }
    System.out.println(totalWeight);
  }
}
