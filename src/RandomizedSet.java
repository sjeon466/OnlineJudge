import java.util.*;

class RandomizedSet {
  static Set<Integer> set;
  static Map<Integer, Integer> map;
  static List<Integer> list;
  java.util.Random rand = new java.util.Random();

  /** Initialize your data structure here. */
  public RandomizedSet() {
    //set = new HashSet<Integer>();
    map = new HashMap<Integer, Integer>();
    list = new ArrayList<Integer>();
    java.util.Random rand = new java.util.Random();
  }

  /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
  public boolean insert(int val) {
    if(!map.containsKey(val)){
      map.put(val, list.size());
      list.add(val);
      return true;
    }else{
      return false;
    }
  }

  /** Removes a value from the set. Returns true if the set contained the specified element. */
  public boolean remove(int val) {
    if(map.containsKey(val)){
      int valIndex = map.get(val);

      if(valIndex < list.size() - 1){
        // swap val with the last element
        int lastVal = list.get(list.size() - 1);
        map.put(val, list.size() - 1);
        map.put(lastVal, valIndex);
      }
      map.remove(val);
      list.remove(list.size()- 1);
      return true;
    }else{
      return false;
    }
  }

  /** Get a random element from the set. */
  public int getRandom() {
    return list.get( rand.nextInt(list.size()) );
  }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */