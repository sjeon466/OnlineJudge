import java.util.Scanner;

public class BJ_1717 {
  static int[] parent;
  public static void main() {
    Scanner sc = new Scanner(System.in);

    int nums = sc.nextInt();
    parent = new int[nums + 1];
    for(int i = 0; i < nums; i++){
      parent[i] = i;
    }

    int numTCs = sc.nextInt();

    while(numTCs -- > 0){
      int operation = sc.nextInt();
      int x = sc.nextInt();
      int y = sc.nextInt();
      if(operation == 0){
        // ex.   0 4 2
        // union(4, 2)
        // add 2 to 4.
        union(x, y);

      }else if(operation == 1){
        x = find(x);
        y = find(y);
        if(x == y){
          System.out.println("YES");
        }else{
          System.out.println("NO");
        }
      }
      numTCs--;
    }
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
