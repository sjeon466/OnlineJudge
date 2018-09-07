import java.util.*;

public class BJ_2056 {
  public static void main(){
    Scanner sc = new Scanner(System.in);
    int numJobs = sc.nextInt();
    int[] costs = new int[numJobs + 1];
    int[] cumulTime = new int[numJobs + 1];
    int[] inDegree = new int[numJobs + 1];
    List<List<Integer>> relation = new ArrayList<>();

    //initializing relation
    for(int i = 0; i <= numJobs; i++){
      relation.add(i, new ArrayList<Integer>());
    }

    for(int jobNum = 1; jobNum <= numJobs; jobNum++){
      int curCost = sc.nextInt();
      int numInDegree = sc.nextInt();

      // creating costs
      costs[jobNum] = curCost;
      if(numInDegree == 0) continue;

      //creating indegree
      inDegree[jobNum] = numInDegree;

      //creating relationship
      for(int i = 0; i < numInDegree; i++){
        relation.get(jobNum).add(sc.nextInt());
      }
    }

    Queue<Integer> queue = new LinkedList<Integer>();

    // put all the jobs that have 0 indegree
    for(int i = 1; i <= numJobs; i++){
     // totalCost = Math.max(totalCost, costs[i]);
      if(inDegree[i] == 0) {
        queue.offer(i);
        cumulTime[i] = costs[i];
      }
    }

   // int curMaxTime = totalCost;
    int nextMaxTime = 0;

    List<Integer> result = new ArrayList<Integer>();

    for(int k = 0; k < numJobs; k++){
      int curJobNum = queue.poll();
      for(int connectedJob : relation.get(curJobNum)){
        inDegree[connectedJob]--;
        if(cumulTime[connectedJob] < cumulTime[curJobNum] + costs[connectedJob] ){
          cumulTime[connectedJob] = cumulTime[curJobNum] + costs[connectedJob];
        }
        if(inDegree[connectedJob] == 0){
          queue.add(connectedJob);
        }
      }
    }

    int ans = 0;
    for(int i = 0 ; i < numJobs; i++){
      ans = Math.max(ans, cumulTime[i]);
    }
    System.out.println(ans);
  }
}
