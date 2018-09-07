import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class BJ_1707 {
  private static Scanner sc;
  public static void main(){
    sc = new Scanner(System.in);

    int numTCs = sc.nextInt();
    for(int i=0; i<numTCs; i++){
      int numVs = sc.nextInt();
      int numEs = sc.nextInt();
      System.out.println( solveBiparite(numVs,numEs) == true ?  "YES" : "NO"   );
    }
  }

  private static void dfsBiparite(List<Integer>[] adjList, int visitedVal, int colorVal, int[] colors){
    ///System.out.print(visitedVal + "(" + colorVal + ")   ->   " );
    colors[visitedVal] = colorVal;
    // check adj vertices
    for(int i=0;i< adjList[visitedVal].size(); i++) {
      int adjVertex = adjList[visitedVal].get(i);
      if (colors[adjVertex] == 0) {
        dfsBiparite(adjList, adjVertex, 3-colorVal, colors);
      }
    }
  }

  private static boolean solveBiparite(int numVs, int numEs) {

    boolean[] visited = new boolean[numVs + 1];
    int[] colors = new int[numVs+1];
    List<Integer>[] adjList = makeMatrixAndList(numVs, numEs);

    //fill colors
    for(int i=1; i<=numVs; i++){
      if(colors[i] == 0){
        dfsBiparite(adjList, 1,1 ,colors);
      }
    }
    return checkBipirate(numVs,adjList,colors);
  }

  private static List<Integer>[] makeMatrixAndList(int numVs, int numEs) {
    List<Integer>[] adjList = new ArrayList[numVs + 1];
    for(int i=0; i<=numVs; i++){
      adjList[i] = new ArrayList<>();
    }

    for(int i=1;i<=numEs; i++){
      int vStart = sc.nextInt();
      int vEnd = sc.nextInt();
      adjList[vStart].add(vEnd);
      adjList[vEnd].add(vStart);
    }
    //printArrayOfList(adjList);
    //System.out.println();
    //System.out.println();
    return adjList;
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

  private static boolean checkBipirate(int numVs, List<Integer>[] adjList, int[] colors){
    // checking bipirate
    boolean isBipirate = true;
    for(int curV=1;curV<=numVs;curV++){
      for(int adjV : adjList[curV]){
        if(colors[curV] == colors[adjV]){
          isBipirate = false;
          break;
        }
      }
    }
    return isBipirate;
  }
}
