import java.util.Arrays;

class MinHeap <T extends Comparable<T>> implements Heap {
  //protected T [] heap;
  protected int[] heap;
  private static final int DEFAULT_SIZE = 20;
  //private int lastIndex = 0;
  protected  int size;


  @SuppressWarnings("unchecked")
  public MinHeap(){
    // Java doesn't allow construction of arrays
    // of placeholder data types
    //initializeHeap();
    heap = //(T[])  new Comparable[DEFAULT_SIZE];
    new int[DEFAULT_SIZE];
    size = 0;
  }

 /* private void initializeHeap() {
    this.heap = new T[DEFAULT_SIZE];
  }
*/
  @Override
  public int[] resize() {
    return heap = Arrays.copyOf(heap, heap.length * 2);
  }

  @Override
  public void push(int value) {
    if(size + 1 >= heap.length){
      heap = resize();
    }

    for(int i = size; i > 1;  i /= 2){
      if(heap[i] > parent(parentIndex(i))){
        swap(i, parentIndex(i));
      }else {
        break;
      }
    }
  }

  protected void bubbleDown2(){

  }

  protected int parent(int i){
    return heap[i/2];
  }

  protected int parentIndex(int i){
    return i / 2;
  }

  protected int leftIndex(int i){
    return i * 2;
  }

  protected int rightIndex(int i){
    return i * 2 + 1;
  }

  protected boolean hasParent(int i){
    return (i != 1 && parentIndex(i) >= 1);
  }

  protected boolean hasLeftChild(int i){
    return leftIndex(i) <= size;
  }

  protected boolean hasRightChild(int i){
    return rightIndex(i) <= size;
  }

  protected void swap(int index1l, int index2){
    int temp = heap[index1l];
    heap[index1l] = heap[index2];
    heap[index2]= temp;
  }

  @Override
  public int pop(int value) {
    int ans = heap[1];
    heap[1] = heap[size];
    heap[size--] = 0;

    for(int i = 1; i * 2 + 1 <= size; ){
      if(heap[leftIndex(i)] < heap[rightIndex(i)] &&
          heap[i] < heap[leftIndex(i)]){
        break;
      } else if(heap[leftIndex(i)] < heap[rightIndex(i)]){
        swap(i, leftIndex(i));
      }else{
        swap(i, rightIndex(i));
      }
      i *= 2;
    }
    return ans;
  }

  @Override
  public int compareTo(Object o) {
    return 0;
  }
}
