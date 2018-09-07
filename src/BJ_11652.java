
import java.util.ArrayList;
import java.util.Scanner;
public class BJ_11652 {
  public static void main(){
    Scanner sc = new Scanner(System.in);
    ArrayList<Integer> myList = new ArrayList<>();
    int nums = sc.nextInt();
    for(int i=0; i<nums;i++){
      myList.add(sc.nextInt());
    }
    int counter=1;
    int maxCount = 1;
    int num = myList.get(0);
    for(int i=1;i<nums; i++){
      if(myList.get(i) == myList.get(i-1)){
        counter++;
        if(counter >= maxCount){
          maxCount = counter;
          num = myList.get(i);
        }
      }else{
        counter=0;
      }
    }
    System.out.println(num);
  }
}
