import org.omg.IOP.ENCODING_CDR_ENCAPS;

import java.util.*;

public class BJ_1948 {

  static Scanner sc;
  static int numCities;
  static int numEdges;
  static int startCity;
  static int endCity;
  static List<List<Edge>> normalRelations;
  static List<List<Edge>> reverseRelations;
  static int[] maxBuildTimes;
  static boolean[] check;
  static int[] normalInDegree;

  static class Edge{
    int destination;
    int cost;
    public Edge(int destination, int cost){
      this.destination = destination;
      this.cost = cost;
    }
  }

  public static void main(){
    sc = new Scanner(System.in);
    numCities = sc.nextInt();
    numEdges = sc.nextInt();

    normalRelations = new ArrayList<List<Edge>>(numCities + 1);
    reverseRelations = new ArrayList<List<Edge>>(numCities + 1);
    maxBuildTimes = new int[numCities + 1];
    check = new boolean[numCities + 1];
    normalInDegree = new int[numCities + 1];

    //initializing relations
    for(int i = 0; i <= numCities; i++){
      normalRelations.add(i, new ArrayList<Edge>());
      reverseRelations.add(i, new ArrayList<Edge>());
    }


    // filling up both relations & indegress
    for(int i = 0; i < numEdges; i++){
      int start = sc.nextInt();
      int end = sc.nextInt();
      int cost = sc.nextInt();
      normalRelations.get(start).add(new Edge(end, cost));
      reverseRelations.get(end).add(new Edge(start, cost));
      normalInDegree[end]++;
    }

    startCity = sc.nextInt();
    endCity = sc.nextInt();

    int cPathNums = criticalPathNums(startCity);
    System.out.println(maxBuildTimes[endCity]);
    System.out.println(cPathNums);
  }

  private static int criticalPathNums(int startCity) {

  /*
  static List<List<Edge>> normalRelations;
  static List<List<Edge>> reverseRelations;
  static int[] maxBuildTimes;
  static boolean[] check;
  static int[] normalInDegree;
   */
  Queue<Edge> queue = new ArrayDeque<Edge>();
  queue.offer(new Edge(startCity, 0));
  //maxBuildTimes[startCity] = 0;

  for(int k = 0; k < numCities; k++){
    //int curCity = queue.poll();
    Edge curEdge = queue.poll();


/*
    for(int j = 0; j < normalRelations.get(curEdge.destination).size(); j++){
      maxBuildTimes[edge.destination] =
              Math.max( maxBuildTimes[edge.destination], maxBuildTimes[curCity] + edge.cost);

    }
*/



  }

    return 0;
  }
}
