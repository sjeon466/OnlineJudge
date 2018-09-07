import java.util.Scanner;

public class LC_204 {
  public static void main(){
   LC_204 l = new LC_204();
   Scanner sc = new Scanner(System.in);
    System.out.println(l.countPrimes(sc.nextInt()));
  }


  public int countPrimes(int num) {
    boolean[] notPrimeArr = new boolean[num + 1];
    // where false == prime ,  true == not prime

    // iteration only has to be up to square root of num
    for(int i = 2; i * i <= num; i++){
      if(!notPrimeArr[i]){
        for(int j = i * 2; j <= num; j+=i){
          notPrimeArr[j] = true;
        }
      }
    }

    int primeCount = 0;
    for(int i = 2; i <= num; i++){
      if(!notPrimeArr[i]) primeCount++;
    }
    return primeCount;
  }
}
