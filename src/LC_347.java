import java.util.*;
import java.util.Map.Entry;


public class LC_347 {
  public static void main(){
    LC_347 l = new LC_347();
    List<Integer> res = l.topKFrequent(new int[]{1,1,1,2,2,3}, 2);
    System.out.println(Arrays.toString(res.toArray()));
  }


  public List<Integer> topKFrequent_using_MaxHeap(int[] nums, int topKs) {
    Map<Integer, Integer> map = new HashMap<>();

    for(int n : nums){
      map.put(n, map.getOrDefault(n, 0) + 1);
    }

    PriorityQueue<Map.Entry<Integer, Integer>> maxHeap =
            new PriorityQueue<>( (a,b) -> b.getValue() - a.getValue());

    /*for(Map.Entry<Integer, Integer> entry : map.entrySet()){
      maxHeap.add(entry);
    }*/
    maxHeap.addAll(map.entrySet());

    List<Integer> result = new ArrayList<Integer>();
    while(result.size() < topKs){
      Map.Entry<Integer, Integer> entry = maxHeap.poll();
      result.add(entry.getKey());
    }
    return result;
  }


  public List<Integer> topKFrequent (int[] nums, int k){
    Map<Integer, Integer> map = new HashMap<>();

    for(int n : nums){
      map.put(n, map.getOrDefault(n ,0) + 1);
    }

    TreeMap<Integer, LinkedList<Integer>> freqMap = new TreeMap<>();
    for(int num : map.keySet()){
      int freq = map.get(num);

      if( !freqMap.isEmpty()){
        freqMap.put(freq, new LinkedList<>());
      }
      freqMap.get(freq).add(num);
    }

    List<Integer> result = new ArrayList<>();
    while(result.size() < k){
      Map.Entry<Integer, LinkedList<Integer>> freqEntry = freqMap.pollLastEntry();
      result.add(freqEntry.getValue().remove());
      if(result.size() == k) break;
    }
    return result;
  }

  public List<Integer> topKFrequent2(int[] nums, int topKs) {

    Map<Integer, Integer> map = new HashMap<Integer, Integer>();

    //iterate the nums and update freq
    for(int i = 0; i <nums.length; i++){
      map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
    }

    //make a frequency-bucket
    List<Integer>[] freqBucket = new List[nums.length + 1];

    for(Entry<Integer, Integer> entry : map.entrySet()){
      if(freqBucket[entry.getValue()] == null){
        freqBucket[entry.getValue()] = new ArrayList<Integer>();
      }
      freqBucket[entry.getValue()].add(entry.getKey());
    }

    //populate result list sorted in most freq order

    List<Integer> resList = new ArrayList<Integer>();

    for(int i = nums.length; i >= 0; i-- ){
      if(freqBucket[i] != null ){
        while(freqBucket[i].size() > 0 && topKs > 0){
          resList.add(freqBucket[i].remove(0));
          topKs--;
        }
      }
    }

    return resList;




/*
    int minNum = Integer.MAX_VALUE;
    int maxNum = Integer.MIN_VALUE;

    //find range by getting min and max
    for(int i = 0; i < nums.length; i++){
      minNum = Math.min(minNum, nums[i]);
      maxNum = Math.max(maxNum, nums[i]);
    }

    // create a bucket of size  max - min + 1
    int[] bucket = new int[maxNum - minNum + 1];

    // fill the bucket with frequencies
    for(int i = 0 ; i < nums.length; i++){
      bucket[nums[i] - minNum]++;
    }
*/


  }
}
