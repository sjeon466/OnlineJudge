import java.util.Arrays;
import java.util.Scanner;

public class BJ_11047 {
  private static Scanner sc = new Scanner(System.in);
  public static void main(){
    int numVariations = sc.nextInt();
    int coinPosessed = sc.nextInt();
    int[] typeOfCoins = new int[numVariations];

    for(int i=0; i < numVariations; i++){
      typeOfCoins[i] = sc.nextInt();
    }

    int coinCount = 0;
    for(int i= numVariations-1; i >= 0; i--){
      if(typeOfCoins[i] > coinPosessed){
        continue;
      }
      coinCount += (coinPosessed / typeOfCoins[i]);
      coinPosessed %= typeOfCoins[i];
    }
    System.out.println(coinCount);
  }
}
