import java.util.Comparator;
import java.util.Scanner;
import java.util.PriorityQueue;

public class BJ_11279 {

  static class Commpare implements Comparator<Integer>{

    @Override
    public int compare(Integer o1, Integer o2) {
      return o2.compareTo(o1);
    }
  }

/*  static Comparator<Integer> comp = new Comparator<Integer>() {
    @Override
    public int compare(Integer o1, Integer o2) {
      return o1 - o2;
    }
  };*/
  //static int[] heap;
  public static void main(){
    Scanner sc = new Scanner(System.in);
    Commpare comp = new Commpare();

    PriorityQueue<Integer> queue = new PriorityQueue<>(1,comp);

    int numOperations = sc.nextInt();
    while(numOperations-- > 0){
      int num = sc.nextInt();

      // get Max
      if(num == 0){
        if(queue.isEmpty()){
          System.out.println(0);
        }else{
          System.out.println(queue.poll());
        }
      }else{
        //insert into heap
        queue.offer(num);

      }
    }

  }



  protected void resize(){


  }
}
