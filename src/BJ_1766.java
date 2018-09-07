import java.util.*;

public class BJ_1766 {
  public static void main() {

    Scanner sc = new Scanner(System.in);
    int numProblems = sc.nextInt();
    int numRelations = sc.nextInt();

    List<List<Integer>> relations = new ArrayList<List<Integer>>(numProblems + 1);
    Queue<Integer> pQueue = new PriorityQueue<>(numProblems);
    int[] inDegrees = new int[numProblems  + 1];

    // making all sublists beforehand
    for(int i = 0; i <= numProblems; i++){
      relations.add(i, new ArrayList<Integer>());
    }

    //System.out.println("done");

    //creating inDegrees & relations
    for(int i = 0; i < numRelations; i++){
      int num1 = sc.nextInt();
      int num2 = sc.nextInt();
      relations.get(num1).add(num2);
      inDegrees[num2]++;
    }

    // queue set up. fill it up with 0 indegrees (solvable questions)
    for(int i = 1; i <= numProblems; i++){
      if(inDegrees[i] == 0) pQueue.offer(i);
    }

    List<Integer> result = new ArrayList<>();

    while(!pQueue.isEmpty()){
      int curProblem = pQueue.poll();
      System.out.print(curProblem + " ");
      result.add(curProblem);

      // take care of the relationships
      for(int connected : relations.get(curProblem)){
        inDegrees[connected]--;
        if(inDegrees[connected] == 0) pQueue.offer(connected);
      }
    }
  }
}