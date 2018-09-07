import java.util.*;

public class LC_451 {
  public static void main() {
    LC_451 l = new LC_451();
    Scanner sc = new Scanner(System.in);
    String input = sc.next();
    String output = l.frequencySort(input);
    System.out.println(output);

    //l.practice();
  }

  // 44 percentile
  public String frequencySort(String input) {
    Map<Character, Integer> map = new HashMap<>();
    for(char c : input.toCharArray()){
      map.put(c, map.getOrDefault(c, 0) + 1);
    }
    PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(
            new Comparator<Map.Entry<Character, Integer>>(){
              @Override
              public int compare(Map.Entry<Character, Integer> e1, Map.Entry<Character, Integer> e2){
                return e2.getValue() - e1.getValue();
              }
            });
    pq.addAll(map.entrySet());
    StringBuilder sb = new StringBuilder();
    while (!pq.isEmpty()) {
      Map.Entry<Character, Integer> curEntry = pq.poll();
      for(int i = 0; i < curEntry.getValue(); i++){
        sb.append(curEntry.getKey());
      }
    }
    return sb.toString();
  }


  // 67 percentile
  public String frequencySort_bucketSort(String input) {
    // populate char to frequency map
    Map<Character, Integer> map = new HashMap<Character, Integer>();
    for(char c : input.toCharArray()){
      map.put(c, map.getOrDefault(c, 0) + 1);
    }

    // sort by freqeuncy into array of  arraylist of characters types
    List<Character>[] bucket = new List[input.length() + 1];
    for(char key : map.keySet()){
      int frequency = map.get(key);
      if(bucket[frequency] == null){
        bucket[frequency] = new ArrayList<Character>();
      }
      bucket[frequency].add(key);
    }

    // make a string by its frequency
    StringBuilder sb = new StringBuilder();
    for(int pos = bucket.length - 1; pos >= 0 ; pos--){
      if(bucket[pos] == null) continue;
      // for each character occurance
      //for(int j = 0; j < bucket[pos].size(); j++){
      for(char c : bucket[pos]){
        // print frequency-number of times for the char
        for(int k = 0; k < map.get( c ); k++ ){
          sb.append(c);
        }
      }
    }
    return sb.toString();
  }


  //99 percentile
  public String frequencySort_myBucket(String input) {
    //int[] charCountArr = new int[58];
    int[] charCountArr = new int[256];

    for (int i = 0; i < input.length(); i++) {
      //charCountArr[input.charAt(i) - 'A']++;
      charCountArr[input.charAt(i)]++;
    }

    int highestCount = 0;
    int mostFreqCharIndex = -1;

    StringBuilder sb = new StringBuilder();

    // check for all possible occurance types of 52 characters
    for(int k = 0 ; k < 52; k++){

      // look for the mostFreq char
      for (int i = 0; i < charCountArr.length; i++) {
        if (charCountArr[i] > highestCount) {
          highestCount = charCountArr[i];
          mostFreqCharIndex = i;
        }
      }
      // charCountArr is empty, return the string
      if (mostFreqCharIndex == -1) return sb.toString();

      // make the string and reset the value
      for (int j = 0; j < highestCount; j++) {
        sb.append((char)   ( mostFreqCharIndex)    );
      }

      //reset values
      charCountArr[mostFreqCharIndex] = 0;
      mostFreqCharIndex = -1;
      highestCount = 0;
    }
    return sb.toString();
  }

  private void practice(){
    String str = "bq";
    int[] charArr = new int[256];

    for(int i = 0 ; i < str.length(); i++){
      //System.out.println(str.charAt(i));
      //System.out.println(Integer.valueOf(str.charAt(i)));
      //System.out.println(Integer.valueOf(str.charAt(i)));
      charArr[str.charAt(i)]++;
    }

    StringBuilder sb = new StringBuilder();
    sb.append('c');
    //sb.append((char)99);
    sb.append((char)(100));
    //sb.append(Character.valu);
    System.out.println(sb.toString());
  }
}
