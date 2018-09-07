import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class LC_78 {
  public static void main(){
    Scanner sc = new Scanner(System.in);
    int nums = sc.nextInt();
    int[] numsArr = new int[nums];
    for(int i = 0; i < nums; i++){
      numsArr[i] = sc.nextInt();
    }
    LC_78 l = new LC_78();
    List<List<Integer>> res = l.subsets(numsArr);
    System.out.println(Arrays.toString(res.toArray()));
  }

  public List<List<Integer>> subsets(int[] numsArr) {
    List<List<Integer>> resultList = new ArrayList<>();
    if(numsArr == null || numsArr.length == 0){
      return resultList;
    }
    int numsLength = numsArr.length;
    for(int i = 0; i < (1 << numsLength); i++){
      List<Integer> individualAns = new ArrayList<>();
      for(int k = 0; k <= numsLength; k++){
        if( (i & (1 << k) ) > 0){
          individualAns.add(numsArr[k]);
        }
      }
      resultList.add(individualAns);
    }
    return resultList;
  }
}