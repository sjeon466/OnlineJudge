import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.*;

public class LC_170 {
  Map<Integer,Integer> hm;

  LC_170(){
    hm = new HashMap<Integer,Integer>();
  }
  // Add the number to an internal data structure.
  public void add(int number) {
    if(hm.containsKey(number)){
      hm.put(number,2);
    }else{
      hm.put(number,1);
    }
  }

  // Find if there exists any pair of numbers which sum is equal to the value.
  public boolean find(int value) {
    Iterator<Integer> iter = hm.keySet().iterator();
    while(iter.hasNext()){
      int num1 = iter.next();
      int num2 = value - num1;
      if(hm.containsKey(num2)){
        if(num1 != num2 || hm.get(num2) == 2){
          return true;
        }
      }
    }
    return false;
  }
}