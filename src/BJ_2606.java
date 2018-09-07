import java.util.Scanner;

public class BJ_2606 {
  static int[] parent;
  public static void main() {
    Scanner sc = new Scanner(System.in);
    int numComps = sc.nextInt();
    int numLinks = sc.nextInt();
    parent = new int[numComps + 1];
    for(int i = 1; i <= numComps; i++){
      parent[i] = i;
    }
    while(numLinks -- > 0) {
      int x = sc.nextInt();
      int y = sc.nextInt();
      System.out.println(x + " " +y);
      union(x, y);
    }
    int virusCount = 0;
    for(int i = 2; i <=numComps; i++){
      if(parent[i] == 1) virusCount++;
    }
    System.out.println(virusCount);
  }

  /**
   * find A's parent and make it same as B's parent
   * @param numA
   * @param numB
   */
  private static void union(int numA, int numB) {
    numA = find(numA);
    numB = find(numB);

    if(numA != numB){
      parent[numB] = numA;
    }
  }

  /**
   * @param num : input num
   * @return parent of the input num.
   */
  private static int find(int num){
    if(parent[num] == num){
      return num;
    }else{
      return parent[num] = find(parent[num]);
      /*int root = find(parent[num]);
      parent[num] = root;
      return root;*/
    }
  }

}
