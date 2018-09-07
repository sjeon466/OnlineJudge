import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

import java.util.List;
import java.util.ArrayList;

public class BJ_2331 {
  static Scanner sc;
  public static void main(){
    sc = new Scanner(System.in);
    int startNum = sc.nextInt();
    int pTimes = sc.nextInt();
    //List<Boolean> visited = new ArrayList<Boolean>();
    Map<Integer, Integer> permutations = new HashMap<Integer, Integer>();
    int startOfCycle = dfsFindCycleUsingMap(startNum, pTimes,  permutations);
    System.out.println(countNonCyclicNums(startNum, startOfCycle, permutations));
  }

  private static int countNonCyclicNums(int startNum, int startOfCycle, Map<Integer, Integer> permutations) {
      int count = 0;
      int val = startNum;
      while(val != startOfCycle){
        val = permutations.get(val);
        count++;
      }
      return count;
  }

  private static int dfsFindCycleUsingMap(int visitedVertex, int pTimes , Map<Integer, Integer> permuations ){
    if(permuations.containsKey(visitedVertex)){
      return visitedVertex;
    }
    int nextNum = calcSumNum(visitedVertex, pTimes);
    permuations.put(visitedVertex, nextNum);
    return dfsFindCycleUsingMap(nextNum, pTimes, permuations);
  }

  private static int calcSumNum(int num, int pTimes){
    int curDigit = 0;
    int sum = 0;
    while(num > 0){
      curDigit = num%10;
      //sum += power(curDigit, pTimes);
      sum += Math.pow(curDigit, pTimes);
      num /= 10;
    }
    return sum;
  }

  private static long power(long base, int exp){
    if(exp == 0) return 1;
    if(exp == 1) return base;
    if(exp % 2 == 0) return     power(base * base, exp/2); // even a = (a^2)^(b/2)
    if(exp % 2 == 0) return base * power(base * base, exp/2); // odd  a = a *(a^2)^(b/2)
    return base;
  }
}