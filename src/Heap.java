public interface Heap {
  public Object resize();
  public int pop(int value);
  public void push(int value);

  int compareTo(Object o);
}
