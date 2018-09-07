public class BJ_Misc_1 {
  public static void main(){

    System.out.println(jegob(2, 5));

  }

  private static int jegob(int base, int exp) {
    int ans = base;

    for(int i = 1; i < exp; i++){
      ans *=  base;
    }
    return ans;
  }



  private static int jegob_divideNConquer(int base, int exp, int[] memoi) {
    if(exp == 0) return 1;
    if(exp == 1) return base;

    int ans = 0;
    if(memoi[exp] != 0) ans = memoi[exp];

    if(exp % 2 == 1){
      ans = base * jegob_divideNConquer(base, exp - 1, memoi);
      memoi[exp] = ans;

    }else{
      int temp = jegob_divideNConquer(base, exp / 2, memoi);
      ans = temp * temp;
      memoi[exp]= ans;
    }
    return ans;
  }
}
