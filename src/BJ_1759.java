import java.util.Arrays;
import java.util.Scanner;

public class BJ_1759 {
  public static void main(){
    Scanner sc = new Scanner(System.in);
    int L =  sc.nextInt();
    int C = sc.nextInt();
    //StringBuilder sb = new StringBuilder();
    char[] charPool = new char[C];
   String curPass = "";
    for(int i = 0; i < C; i++){
      charPool[i] = sc.next().charAt(0);
    }

    Arrays.sort(charPool);
    go(charPool, L, 0, curPass);
  }

  private static void go(char[] stringPool, int targetLength, int curIndexInPool, String curPass){
    if(curPass.length() == targetLength){
      if(checkAlpha(curPass)){
        System.out.println(curPass);
      }
    }

    if(curIndexInPool >= stringPool.length) return;
    //continue with two scenarios


    go(stringPool, targetLength, curIndexInPool + 1,  curPass + stringPool[curIndexInPool]);
    go(stringPool, targetLength, curIndexInPool + 1,  curPass);
  }

  private static boolean checkAlpha(String curPass){
    int vowelCount = 0;
    int consonantCount = 0;
    //char[] chars = str.toCharArray();
    for(char curC : curPass.toCharArray()){

      if(curC == 'a' || curC == 'i' || curC == 'o' || curC == 'u' || curC == 'e') {
        vowelCount++;
      }else{
        consonantCount++;
      }
    }
    return (vowelCount >= 2  && consonantCount >= 1);
  }
}
