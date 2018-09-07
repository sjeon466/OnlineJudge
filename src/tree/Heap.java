package tree;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Heap<T extends Comparable<T>>{

  private ArrayList<T> items;

  public Heap(){
    items = new ArrayList<T>();
  }

  public int size(){
    return items.size();
  }
  private void siftUp(){
    int curPos = items.size() - 1;
    while(curPos > 1){
      int parentPos = (curPos - 1)/2;
      T curVal = items.get(curPos);
      T parentVal = items.get(parentPos);
      if(curVal.compareTo(parentVal) > 0){
        // swap
        items.set(curPos, parentVal);
        items.set(parentPos, curVal);

        curPos = parentPos;
        parentPos = (curPos - 1) / 2;
      }else{
        break;
      }
    }
  }

  public void insert(T item){
    items.add(item);
    siftUp();
  }

  private void siftDown(){
    int curPos = 0;
    int leftChildPos = curPos * 2 + 1;
    //int curVal = items.size() - 1;
    while(leftChildPos < items.size()){
      int maxPos = leftChildPos, rightChildPos = leftChildPos + 1;
      if(rightChildPos < items.size()) {
        if (items.get(rightChildPos).compareTo(items.get(leftChildPos)) > 0) {
          // switch
          T curVal = items.get(curPos);
          items.set(curPos, items.get(maxPos));
          items.set(maxPos, curVal);

          curPos = maxPos;
          leftChildPos = curPos * 2 + 1;
        } else {
          break;
        }
      }
    }
  }

  public T delete() throws NoSuchElementException{
    if(items.size() == 0){
      throw new NoSuchElementException();
    }
    if(items.size() == 1){
      return items.remove(0);
    }

    T tobeRemoved = items.get(0);
    items.set(0, items.remove(items.size() - 1));
    siftDown();
    return tobeRemoved;
  }

  public boolean isEmpty(){
    return items.isEmpty();
  }

  public String toString(){
    return items.toString();
  }

}
