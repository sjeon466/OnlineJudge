import java.util.Random;

public class LC_384_2 {
  private int[] array;
  private int[] original;
  Random rand = new Random();

  private int randInRange(int min, int max){
    return rand.nextInt( max - min ) + min;
  }

  private void swapAt(int i, int j){
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }

  public LC_384_2(int[] nums){
    array = nums;
    original = nums.clone();
  }

  public int[] reset(){
    array = original;
    original = original.clone();
    return original;
  }
  public int[] shuffle(){
    for(int i = 0; i < array.length; i++){
      swapAt(i, randInRange(i, array.length));
    }
    return array;
  }
}
