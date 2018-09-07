import java.util.Scanner;

public class BJ_10451 {
  static Scanner sc;
  public static void main(){
    sc = new Scanner(System.in);
    int numTC = sc.nextInt();
    for(int i=0; i<numTC; i++){
      System.out.println(solveCyclicPermut());
    }
  }
  private static int solveCyclicPermut(){
    int numVs = sc.nextInt();
    boolean[] visited = new boolean[numVs + 1];
    
    int[] perMutArray = makePermutArray(numVs);
 
    int numCycles = 0;
    for(int visitVertex=1; visitVertex<= numVs; visitVertex++){
      if(visited[visitVertex] == false){
        dfsCycleSearch(visitVertex, perMutArray, visited);
        //System.out.println(" ======= Next Cycle ======");
        numCycles++;
      }
    }
    return numCycles;
  }

  private static void dfsCycleSearch(int visitVertex, int[] perMutArray, boolean[] visited) {
    if(visited[visitVertex]) return;
    visited[visitVertex] = true;
    //System.out.print(visitVertex + "..");
    // checking the adj vertex
    int adjVerext = perMutArray[visitVertex];
    if(visited[ adjVerext] == false){
      dfsCycleSearch(adjVerext, perMutArray, visited);
    }
  }

  private static int[] makePermutArray(int numVs){
    int[] permutArr = new int[numVs + 1];
    for(int i=1; i<= numVs; i++){
      permutArr[i] = sc.nextInt();
    }
    return permutArr;
  }

}
