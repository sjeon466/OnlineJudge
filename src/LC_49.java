
import java.util.*;

import java.util.Arrays;


public class LC_49 {
  public static void main(){
    Scanner sc = new Scanner(System.in);
    LC_49 l = new LC_49();
    String[] strs = new String[]{"eat","tea","tan","ate","nat","bat"};
    List<List<String>> ans = l.groupAnagrams(strs);

    for(List<String> l1 : ans){
      for(String str : l1){
        System.out.print(str + "  ");
      }
      System.out.println();
      System.out.println();
    }
  }
  public List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List<String>> map = new HashMap<>();
    List<List<String>> resultList = new ArrayList<>();

    for(String str : strs){
      char[] strArr = str.toCharArray();

      Arrays.sort(strArr);

      String sortedStr = Arrays.toString(strArr);
      if(!map.containsKey(sortedStr)){
        map.put(sortedStr, new ArrayList<String>(Arrays.asList(str)));
      }else{
        map.get(sortedStr).add(str);
      }
    }

    for(String str : map.keySet()){
      resultList.add(map.get(str));
    }
    return resultList;
  }

  public List<List<String>> groupAnagrams2(String[] strs) {
    Map<CustomCharArray, List<String>> map = new HashMap<>();

    for(String str : strs){
 /*     List<Integer> charList = new ArrayList<Integer>(26);
      for(int i = 0; i < 26; i++){
        charList.add(0);
      }*/

      CustomCharArray curCustom = new CustomCharArray(str);


      if(!map.containsKey(curCustom)){
        map.put(curCustom, new ArrayList<String>(Arrays.asList(str)));
      }else {
        map.get(curCustom).add(str);
      }
    }

    List<List<String>> resList = new ArrayList<>();
    for(Map.Entry<CustomCharArray, List<String>> entry : map.entrySet()){
      List<String> strings = entry.getValue();
      resList.add(strings);
    }
    return resList;
  }

  class CustomCharArray {
    //private final int[] charArr = new int[26];
    private final int[] charArr = new int[26];
    public CustomCharArray(String str){
      for(char c : str.toCharArray()){
        charArr[c - 'a']++;
      }
    }

    @Override
    public boolean equals(Object obj){
      if(! (obj instanceof CustomCharArray)) return false;
      CustomCharArray otherCharArray =  (CustomCharArray) obj;
      boolean isEqual = true;
      for(int i = 0; i < otherCharArray.charArr.length; i++){
        if(this.charArr[i] != otherCharArray.charArr[i]){
          isEqual = false;
          break;
        }
      }
      return isEqual;
    }

    @Override
    public int hashCode(){
      int result = 17;
      result = 17 * result + Arrays.hashCode(charArr);
      return result;
    }
  }
}
