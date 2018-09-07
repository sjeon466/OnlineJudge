import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;

public class BJ_1939 {

  static boolean[] visited;
  static int maxPossibleIslandNum;
  static int numBridges;
  static int startIsland;
  static int endIsland;
  static List<Edge>[] edges;
  static Queue<Edge> que = new LinkedList<Edge>();

  static class Edge{
    int adjNode;
    int weight;

    public Edge(int adjNode, int weight){
      this.adjNode = adjNode;
      this.weight = weight;
    }
  }

  public static void main() throws IOException{
    //Scanner sc = new Scanner(System.in);
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    maxPossibleIslandNum = Integer.parseInt( st.nextToken() );
    numBridges = Integer.parseInt( st.nextToken() );
    visited = new boolean[maxPossibleIslandNum + 1];

    init();

    for(int i = 1; i <= numBridges; i++) {
      int a, b, c;
      st = new StringTokenizer(br.readLine());
      a = Integer.parseInt(st.nextToken());
      b = Integer.parseInt(st.nextToken());
      c = Integer.parseInt(st.nextToken());

      edges[a].add(new Edge(b, c));
      edges[b].add(new Edge(a, c));
    }
      st = new StringTokenizer(br.readLine());
      startIsland = Integer.parseInt(st.nextToken());
      endIsland = Integer.parseInt(st.nextToken());

      System.out.println(parametricSearch());

  }

  private static int parametricSearch() {
    int low = 0;
    int high = (int)1e9;
    int ans = -1;

    while(low <= high){
      int mid = low + ( high - low ) / 2;

      if(isAnswer(mid)){
        ans = mid;
        low = mid + 1;
      } else{
        high = mid - 1;
      }
    }
    return ans;
  }

  private static boolean isAnswer(int testingWeight){
    ArrayDeque<Integer> que = new ArrayDeque<Integer>();
    que.offer(startIsland);
    Arrays.fill(visited, false);
    visited[startIsland] = true;


    while(! que.isEmpty()) {
      int curIsland = que.poll();

      if(curIsland == endIsland) return true;

      for(Edge curEdge :  edges[curIsland]){
        if(!visited[curEdge.adjNode] && curEdge.weight >= testingWeight){
          que.offer(curEdge.adjNode);
          visited[curEdge.adjNode] = true;
        }
      }
    }
    return false;
  }

  private static void init(){
    edges = (ArrayList<Edge>[]) new ArrayList[numBridges + 1];
    for(int i = 0; i <= numBridges; i++){
      edges[i] = new ArrayList<Edge>();
    }
  }

/*  private static boolean go(int visitingNodeNum, int tryingLimit){
    if(visited[visitingNodeNum]) return false;
    visited[visitingNodeNum] = true;

    if(visitingNodeNum == endIsland){
      return true;
    }

    for(Island adjIsland  : islands[visitingNodeNum]){
      int nextIslandNum = adjIsland.
    }



  }*/

}
