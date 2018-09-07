import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Edge{
  int adjNode;
  int weight;

  public Edge(int adjNode, int weight){
    this.adjNode = adjNode;
    this.weight = weight;
  }
}

public class BJ_1939_2 {
  static boolean[] visited;
  static ArrayList<Edge>[] edges;
  static int startIsland;
  static int finishIsland;
  static int numEdges;
  static int numPosMaxIsland = 10001;

  public static void main() throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    numEdges = Integer.parseInt(st.nextToken());

    initEdges();

    for(int i = 1; i < numEdges; i++){
      st = new StringTokenizer(br.readLine());
      int begNode, endNode, weight;
      begNode = Integer.parseInt(st.nextToken());
      endNode = Integer.parseInt(st.nextToken());
      weight = Integer.parseInt(st.nextToken());

      edges[begNode].add(new Edge(endNode, weight));
      edges[endNode].add(new Edge(begNode, weight));

    }
    st = new StringTokenizer(br.readLine());
    startIsland = Integer.parseInt(st.nextToken());
    finishIsland = Integer.parseInt(st.nextToken());

    visited = new boolean[numPosMaxIsland + 1];

    System.out.println(solve());
  }

  private static void initEdges() {
    edges = new ArrayList[numEdges + 1];
    for(int i = 1; i <= numEdges; i++){
      edges[i] = new ArrayList<Edge>();
    }
  }

  private static int solve(){
    int low = 1;
    int high = (int)1e9;
    int ans = 1;

    while(low <= high){
      int mid = low + (high - low) / 2;
      if(isPossible(mid)){
        ans = mid;
        low = mid + 1;
      }else{
        high = mid - 1;
      }
    }
    return ans;
  }

  private static boolean isPossible(int testingWeight) {
    Queue<Integer> queue = new LinkedList<Integer>();

    Arrays.fill(visited, false);
    visited[startIsland] = true;
    queue.offer(startIsland);

    while(! queue.isEmpty()){
      int curIsland = queue.poll();
      for(Edge edge : edges[curIsland]){
        if(edge.adjNode == finishIsland) return true;
        if(!visited[edge.adjNode] && edge.weight >= testingWeight){
          queue.offer(edge.adjNode);
        }
      }
    }
    return false;
  }
}
