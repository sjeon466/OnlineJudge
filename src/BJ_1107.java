import java.util.Scanner;
        import java.util.Set;
        import java.util.HashSet;
        import java.util.Arrays;

public class BJ_1107 {
  static int[] broken = new int[10];

  public static void main(){
    Scanner sc = new Scanner(System.in);
    int targetNum = sc.nextInt();
    int brokenQuant = sc.nextInt();
    //Set<Integer> brokenNums = new HashSet<>();
    Arrays.fill(broken, 0);
    for(int i = 0; i < brokenQuant; i++){
      //brokenNums.add(sc.nextInt());
      broken[sc.nextInt()] = 1;
    }

    //brute force + or - only
    int minClicks = Math.abs(targetNum - 100);

    for(int i = 0; i <= 5000000; i++){

      int channel = i;
      boolean flag = false;
      int numButtonClicked = 0;

      while(true){
        if(broken[channel % 10] == 1 ){
          break;
        }else{
          channel /= 10;
          numButtonClicked++;
          // doesn't contain broken values
          if(channel == 0){
            flag = true;
            break;
          }
        }
      }

      // worth checking
      // searcheable with working nums
      if(flag){
        //minClicks = Math.min(minClicks, Math.abs(i - targetNum));
        int difference = Math.abs(targetNum - i);
        if((difference + numButtonClicked) < minClicks){
          minClicks = (difference + numButtonClicked);
        }
      }
    }
    System.out.println(minClicks);
  }
}
