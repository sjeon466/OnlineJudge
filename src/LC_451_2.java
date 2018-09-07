import org.w3c.dom.CharacterData;

import java.util.*;
//import java.util.Map.EntrySet;

public class LC_451_2{
  public static void  main(){
    Scanner sc = new Scanner(System.in);
    String str = sc.next();
    LC_451_2 l = new LC_451_2();
    System.out.println(l.frequencySort(str));
  }

  public String frequencySort(String str) {
    //Map<Character, Integer> tMap = new TreeMap<Character, Integer>(str.length(), Collections.reverseOrder());
/*    TreeMap<Character, Integer> tMap = new TreeMap<Character, Integer>(*//*Collections.reverseOrder()*//*
            new Comparator<Character>() {
              @Override
              public int compare(Character c1, Character c2) {
                return tMap.get(c2)-tMap.get(c1);
              }
            });*/
    Map<Character , Integer> map = new HashMap<Character, Integer>();

    for(char c : str.toCharArray()){
      map.put(c, map.getOrDefault(c, 0 ) + 1);
    }

    // create a frequency array which uses index as the frequency of chars
    // for one index, there can be more than one char

    List<Character>[] freqArray = new List[str.length() + 1];

    for(int i = 0; i < freqArray.length; i++){
      freqArray[i] = new ArrayList<Character>();
    }

    for(Map.Entry<Character, Integer> entry : map.entrySet()){
      int curFreq = entry.getValue();
      if(freqArray[curFreq] == null) freqArray[curFreq] = new ArrayList<Character>();
      freqArray[entry.getValue()].add(entry.getKey());
    }

    StringBuilder sb = new StringBuilder();

    for(int i = freqArray.length - 1; i >= 1; i--){
        while(freqArray[i].size() > 0) {
          char curChar = freqArray[i].remove(0);
          for(int j = 0; j < i; j++){
            sb.append(curChar);
          }
        }
    }
   /* while(!map.isEmpty()){
      //char curChar = tMap.poll();

      //EntrySet<Character, Integer> curSet = tMap.poll();
      //Map.Entry<Character, Integer> curSet = tMap.entrySet();
      //Map.Entry<Character, Integer> curEntry = ((TreeMap<Character, Integer>) tMap).pollFirstEntry()

      Map.Entry<Character, Integer> curEntry =  map.pollFirstEntry();
      for(int i = 0; i < curEntry.getValue(); i++){
        sb.append(curEntry.getKey());
      }
    }*/
    return sb.toString();
  }

}