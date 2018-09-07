import java.util.Arrays;
import java.util.Scanner;

public class BJ_2110 {

  public static void main(){
    Scanner sc = new Scanner(System.in);
    int numHouses = sc.nextInt();
    int numRouters = sc.nextInt();

    int[] houses = new int[numHouses];

    for(int i = 0; i < numHouses; i++){
      houses[i] = sc.nextInt();
    }
    Arrays.sort(houses);

    BJ_2110 b = new BJ_2110();


    int ans = 1;
    int left = 1;
    int right = houses[numHouses - 1] - houses[0];

    while(left <= right){
      int mid = left + (right - left) / 2;
      if(possible(houses, numRouters, mid)){
        ans = Math.max(ans, mid);
        left = mid + 1;
      }else{
       right = mid - 1;
      }
    }
    System.out.println(ans);
  }


  public static boolean possible(int[] houses, int numRouters,  int mid){
    int cnt = 1;
    int lastPos = houses[0];

    for(int curHousePos : houses){
      if(curHousePos - lastPos >= mid){
        cnt += 1;
        lastPos = curHousePos;
      }
    }
    return cnt >= numRouters;
  }

/*
  private int maxDist(int[] houses, int minGap){
    int maxDist = -1;
    if(houses == null || houses.length == 0) return maxDist;

    for(int i = 1 ; i < houses.length; i++){
      int curDist = houses[i] = houses[i-1];
      if(minGap > curDist){
        maxDist = -1;
        break;
      }else{
        maxDist = Math.max(maxDist, curDist);
      }
    }
    return maxDist;
  }
*/

}
