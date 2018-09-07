import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BJ_1197 {
  public static void main(){
    Scanner sc = new Scanner(System.in);
    int numVertices = sc.nextInt();
    int numEdges = sc.nextInt();

    List<List<Integer>> edges = new ArrayList<List<Integer>>(numVertices + 1);

    //initializing edges
    for(int i = 0; i <= numVertices; i++){
      edges.add(i, new ArrayList<Integer>());
    }

    for(int i = 0; i <= numEdges; i++){
      int vertexA = sc.nextInt();
      int vertexB = sc.nextInt();
      int weight = sc.nextInt();
      edges.get(vertexA);
    }

  }
}
