import java.util.*;

public class LC_406 {
  public static void main(){
    Scanner sc = new Scanner(System.in);
    int numPpl = sc.nextInt();
    int[][] queue = new int[numPpl][2];

    for(int r=0; r < numPpl; r++){
      for(int c=0; c < 2; c++){
        queue[r][c] = sc.nextInt();
      }
    }
    print2DArray(queue);
/**
 * Sort people in decreasing order
 * for persons with same height, sort them based on the the increasing K order.
 *
 *  first sort tallest persons [7,0], [7,1],
 *  then insert lower height to the position of their k index.
 *
 *
 */

    Arrays.sort(queue, new Comparator<int[]>(){
      @Override
      public int compare(int[] person1, int[] person2){
       return( person1[0] == person2[0] ? person1[1] - person2[1] : person1[0] - person2[0]);
      }
    });

    List<int[]> list = new ArrayList<int[]>();
    for(int[] cur : queue){
      list.add(cur[1], cur);
    }


/*    Arrays.sort(queue, new Comparator<int[]>() {
      @Override
      public int compare(int[] q1, int[] q2) {
        if(q1[0] == q2[0]){
          return q1[1] - q2[1];
        }else{
          return q1[0] - q2[0];
        }
      }
    });*/

    System.out.println("SORT!");
    print2DArray(queue);

    System.out.println("Reconstruct");
    int[][] grid = reconstructQueue(queue);
    print2DArray(grid);
  }

  private static void print2DArray(int[][] grid){
    for(int[] curRow : grid){
      for(int curVal : curRow){
        System.out.printf("%5d", curVal);
      }
      System.out.println();
    }
  }
  public static int[][] reconstructQueue(int[][] people) {
    /**
     *  Sort people in decreasing order of height,
     *  for same height, sort them in increasing K value.
     *
     *  Start with the tallest person
     *  and insert lower height person to the position of their K index.
     *
     */
     Arrays.sort(people, new Comparator<int[]>(){
       @Override
       public int compare(int[] person1, int[] person2){
         return (person1[0] == person2[0]) ? person1[1] - person2[1] : person2[0] - person1[0];
       }
     });

     List<int[]> list = new ArrayList<int[]>();
     for(int[] cur : people){
       list.add(cur[1], cur);
     }

     //return (int[][])list.toArray();
    return list.toArray(new int[people.length][2]);





/*    List<int[]> list = new ArrayList<>();

    int[][] reconstructedQueue = new int[people.length][2];

    for(int r=0; r < people.length; r++){
      if(reconstructedQueue[ people[r][1] ][0] != 0){

      }
      reconstructedQueue[ people[r][1] ][0] = people[r][0];
      reconstructedQueue[ people[r][1] ][1] = people[r][1];
      //list.add(people[r][1], new int[] { people[r][0], people[r][1]});
    }
    return reconstructedQueue;*/
  }
}
