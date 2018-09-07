import java.util.Scanner;

public class BJ_2293 {
  public static void main(){
    Scanner sc = new Scanner(System.in);
    int coinKinds = sc.nextInt();
    int[] coinTypes = new int[coinKinds];

    for(int i=0; i < coinKinds; i++){
      coinTypes[i] = sc.nextInt();
    }

    int targetSum = sc.nextInt();
    int[] d = new int[coinKinds];
    //  d[n] = number of possible arrangements to have a target of targetSum with coinKinds types of coins.
    //   n = sum

    //  m kinds of coins
    d[0] = 1;
    for(int nthCoin = 0; nthCoin <= coinKinds; nthCoin++){
      for(int sum = 0; sum < targetSum; sum++){
        //d[sum] += (sum % coinTypes[i] == 0 ? sum / coinTypes[i] : 0) ;
        if(sum - coinTypes[nthCoin] >= 0){
          d[sum] += d[sum - coinTypes[nthCoin]];
        }
      }
    }


  }



}
