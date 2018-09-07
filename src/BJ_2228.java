import java.util.Scanner;

public class BJ_2228 {
  public static void main(){
    Scanner sc = new Scanner(System.in);
    int numElements = sc.nextInt();
    int numSegments = sc.nextInt();
    int[] numsArr = new int[numElements];

    for(int i = 0; i < numElements; i++){
      numsArr[i] = sc.nextInt();
    }

    System.out.println(new BJ_2228().calcMaxSum(numsArr, numElements, numSegments));

  }

  private int calcMaxSum(int[] numsArr, int numElements, int numSegments){
    int[][] memoi = new int[numElements][numSegments + 1];
    for(int numIndex = 0; numIndex < numElements; numIndex++){
      for(int segment = 0; segment < numSegments; segment++){
        int indexSelected = memoi[numIndex-1][segment];

        int indexNotSelected = 0;
        for(int k = 0; k < numIndex; k++){



        }



      }
    }



    return -1;
  }
}
