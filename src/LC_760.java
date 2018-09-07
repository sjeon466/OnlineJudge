import java.util.*;

public class LC_760 {
  public static void main(){
    Scanner sc = new Scanner(System.in);
    int numA = sc.nextInt();
    int[] arrA = new int[numA];
    for(int i = 0; i < numA; i++) arrA[i] = sc.nextInt();
    int numB = sc.nextInt();
    int[] arrB = new int[numB];
    for(int i = 0; i < numB; i++) arrB[i] = sc.nextInt();

    LC_760 l = new LC_760();
    System.out.println(Arrays.toString(l.anagramMappings( arrA, arrB )));
  }

  public int[] anagramMappings(int[] arrA, int[] arrB) {
    Map<Integer, List<Integer>> mapping = new HashMap<>();
    for(int i = 0; i < arrA.length; i++){
      if(!mapping.containsKey(arrA[i])){
        mapping.put(arrA[i], new ArrayList<>());
      }
      mapping.get(arrA[i]).add(i);
    }

    int[] mapAtoB = new int[arrA.length];

    for(int i = 0; i < arrB.length; i++){
       mapAtoB[ mapping.get(arrB[i]).remove(0) ] = i;
    }
    return mapAtoB;
  }

  public int[] anagramMappings2(int[] arrA, int[] arrB) {
    boolean[] picked = new boolean[arrB.length];
    int[] mapping = new int[arrA.length];

      for(int i = 0; i < arrA.length; i++){
        for(int j = 0; j < arrB.length; j++){
          if(arrA[i] == arrB[j] && !picked[j]){
            mapping[i] = j;
          }
        }
      }
      return mapping;
  }
}
