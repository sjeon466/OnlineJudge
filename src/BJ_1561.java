import java.util.Scanner;

public class BJ_1561 {
  private static int numChildren, numRides;
  private static long high, low, mid, tmp_n;
  public static int[] rideDurations;

  private static long find_childrencount_uptil(long nth_min){
    long totalChildren = 0;
    for(int i = 0; i < numRides; i++){
      totalChildren += nth_min / rideDurations[i];
    }
    return totalChildren;
  }

  public static void main(){
    Scanner sc = new Scanner(System.in);

    numChildren = sc.nextInt(); // ( 1 <= N <= 2,000,000,000)
    numRides = sc.nextInt();    // ( 1 <= M <= 10,000)

    rideDurations = new int[numRides];
    for(int i = 0; i < numRides; i++){
      rideDurations[i] = sc.nextInt();
    }

    low = 1;
    high = ((long) numChildren) * (long) numRides;

    // print the nth ride that the last children gets on
    if(numChildren < numRides) System.out.println(numChildren);
    else{
      numChildren = numChildren - numRides;
      while(low <= high){
        mid = (low) + (high - low) / 2;
        tmp_n = find_childrencount_uptil(mid);
        if(tmp_n >= numChildren) high = mid - 1;
        else low = mid + 1;
      }

      tmp_n = find_childrencount_uptil(high);
      for(int i = 0; i < numChildren; i++){
        if(low % rideDurations[i] == 0 && ++tmp_n == numChildren){
          System.out.println(i+1);
          break;
        }
      }
    }
  }
}
