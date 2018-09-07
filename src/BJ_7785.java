import java.util.*;

public class BJ_7785 {
  public static void main(){
    Scanner sc = new Scanner(System.in);

    int numLogs = sc.nextInt();
    //TreeSet<String> set = new TreeSet<>();
    Set<String> set = new TreeSet<>();


    while(numLogs-- > 0) {
      String name = sc.next();
      String action = sc.next();
      if(action.equals("enter")){
        set.add(name);
      }else if(action.equals("leave")){
        set.remove(name);
      }
    }

    List<String> sortedList = new ArrayList(set);
    Collections.sort(sortedList);

    for(String str : sortedList){
      System.out.println(str);
    }
    /*
    for(String str : set){
      System.out.println(str);
    }
    */
  }
}
