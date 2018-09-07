import java.util.*;

public class BJ_2252 {
  public static void main() {
    Scanner sc = new Scanner(System.in);
    int numStudents = sc.nextInt();
    int num1Comparisons = sc.nextInt();
    int[] inDegree = new int[numStudents + 1];

    //int[][] comparisons = new int[numComparisons][2];

    List<Integer>[] compareFromNum1 = new List[numStudents + 1];


    for (int i=1; i<= numStudents; i++) {
      compareFromNum1[i] = new ArrayList<Integer>();
    }

    //creating comparisons
    // creating inDegree
    for (int i = 1; i <= num1Comparisons; i++) {
      int num1 = sc.nextInt();
      int num2 = sc.nextInt();
      compareFromNum1[num1].add(num2);
      inDegree[num2]++;
    }

    Queue<Integer> queue = new LinkedList<Integer>();
    //put inDegree Zeros (the shortest guys)
    for(int i = 1; i <= numStudents; i++){
      if(inDegree[i] == 0) queue.offer(i);
    }

    List<Integer> resultOrder = new ArrayList<>();

    while(!queue.isEmpty()){
      int curStudent = queue.poll();
      resultOrder.add(curStudent);
      System.out.println(curStudent + " ");
      for(int taller : compareFromNum1[curStudent]){
        inDegree[taller]--;
        if(inDegree[taller] == 0){
          queue.offer(taller);
        }
      }
    }
  }
}
