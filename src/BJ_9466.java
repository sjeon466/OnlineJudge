import java.util.Scanner;

public class BJ_9466 {
  static Scanner sc;

  // array of corresponding other students id of the specific index of student want to be teamed up with.
  static int[] students;

  // array to store the number of times itself was chosen by others/itself.
  static int[] count;

  // number of students who do not have team.
  static int noTeamCount=0;

  static boolean[] visited;
  public static void main(){
    sc = new Scanner(System.in);
    int numTC = sc.nextInt();
    while(numTC-- >0){
      System.out.println(solveTermProject());
    }
  }

  private static int solveTermProject() {
    int numStudents = sc.nextInt();
    int[] students = makeStudents(numStudents);
    boolean[] visited = new boolean[numStudents + 1];
    int numTeams = 0;
    for(int i=1; i<=numStudents; i++){
      if (visited[i] ==false) {
       numTeams += dfsSearchStudentCycle(i, 1);
      }
    }
    return numTeams;
  }

  private static int dfsSearchStudentCycle(int visitedStudent, int count) {
    return -1;
  }

  private static int[] makeStudents(int numStudents) {
    int[] students = new int[numStudents + 1];
    for(int i=1; i<=numStudents; i++){
      int chosenStudent = sc.nextInt();
      students[i] = chosenStudent;
      count[students[chosenStudent]]++;
    }
    return students;
  }
}
