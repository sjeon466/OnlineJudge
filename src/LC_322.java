import java.util.Scanner;

public class LC_322 {
  public static void main(){
    LC_322 l = new LC_322();
    Scanner sc = new Scanner(System.in);
    int numCoinTypes = sc.nextInt();
    int[] coinTypes = new int[numCoinTypes];

    for(int i = 0; i < numCoinTypes; i++){
      coinTypes[i] = sc.nextInt();
    }
    int target = sc.nextInt();
    System.out.println(l.coinChange(coinTypes, target));
  }

  public int coinChange(int[] coinTypes, int target) {
    int[] d = new int[target + 1];

    //initializing the basic denomination
    for(int i = 0; i < coinTypes.length; i++){
      if(coinTypes[i] < d.length){
        d[ coinTypes[i] ] = 1;
      }
    }

    //if the target is one of the denominations just quit
    if(d[target] == 1){
      return 1;
    }

    //filling out the d[] from index (1 to target)
    for(int i = 1; i <= target; i++){
      // check all prev coin paths
      for(int j = 0; j < coinTypes.length; j++){
        // check for array bound && prev is not reacheable amount
        if(i - coinTypes[j] > 0 &&  d[i - coinTypes[j]] != 0){
          //change:  scenario A: d[i] is zero so update min coin no matter what
          //change:  scenario B: d[ i - coinTypes[j]] has smaller coin combination than d[i], update
          if(d[i] == 0 ||  d[i - coinTypes[j]] < d[i])
            d[i] = d[i - coinTypes[j]] + 1;
        }
      }
    }
    return (d[target] == 0) ? -1 : d[target] ;
  }
}
