import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LC_384 {
  private int[] array;
  private int[] original;

  private Random rand = new Random();

  public LC_384(int[] nums){
    array = nums;
    original = nums.clone();
  }

  public static void main(){
    int[] nums = new int[] {1,2,4,6,7,9,27,32};
    LC_384 l = new LC_384(nums);
  }

  /** Resets the array to its original configuration and return it. */
  public int[] reset() {
    array = original;
    original = original.clone();
    return array;
  }

  /** Returns a random shuffling of the array. */
  public int[] shuffle() {
    List<Integer> aux = getListCopy();

    for(int i = 0; i < array.length; i++){
      int removeIdx = rand.nextInt(aux.size());
      array[i] = aux.get(removeIdx);
      aux.remove(removeIdx);
    }
    return array;
  }

  private List<Integer> getListCopy(){
    List<Integer> asList = new ArrayList<Integer>();
    for(int i = 0; i < array.length; i++){
      asList.add(array[i]);
    }
  return asList;
  }
}
