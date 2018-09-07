import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

public class HK_Algo_WeightedUnifromString {
  public static void main(){
    Scanner sc = new Scanner(System.in);
    String str = sc.nextLine();
    int numQueries = sc.nextInt();

    int lenStr = str.length();
    Set<Integer> numSet = new HashSet<Integer>();

    int lastCharVal = 0;
    int curContiguousCount = 1;
    for(int i=0; i < lenStr; i++){
      int curCharVal = str.charAt(i) - 'a' + 1;
      if(curCharVal == lastCharVal){
        curContiguousCount++;
        numSet.add(curContiguousCount * curCharVal);
      }else{
        curContiguousCount = 1;
        lastCharVal = curCharVal;
        numSet.add(lastCharVal);
      }
    }

    for(int i=0; i < numQueries; i++){
      if(numSet.contains(sc.nextInt())){
        System.out.println("Yes");
      }else{
        System.out.println("No");
      }
    }
  }
}
