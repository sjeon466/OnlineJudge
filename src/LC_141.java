/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int r) {
 *         val = r;
 *         next = null;
 *     }
 * }
 */

import java.util.*;

class ListNode{
  int val;
  ListNode next;
  ListNode(int x){
    this.val = x;
    next = null;
  }

  public ListNode() {

  }
}

class Test{
  public final List foo;

  public Test(){
    foo = new ArrayList();
    foo.add("foot");

  }

  public Test(String tr){
    foo = new ArrayList();
    foo.add("foot3ee");
  }

  public void setFoo(List foo){
    //this.foo = foo;
  }

  public void modifyFoo(String str){
    foo.add(str);
  }
}


public class LC_141 {

  public static void main(){

    Test t1 = new Test();
    Test t2 = new Test();
    //t1 = new Test();
    t1.modifyFoo("44");
    t1.modifyFoo("55");
    t1 = new Test("%%%");
    System.out.println(Arrays.toString(t1.foo.toArray()));
    System.out.println(Arrays.toString(t2.foo.toArray()));

  }



  public boolean hasCycle1(ListNode head) {
    if (head == null) return false;
    ListNode tortoise = head, hare = head;

    while (hare.next != null && hare != null) {
      tortoise = tortoise.next;
      hare = hare.next.next;
      if (tortoise == hare) return true;
    }
    return false;
  }
  public boolean hasCycle2(ListNode head) {
    Set<ListNode> set = new HashSet<ListNode>();

    ListNode cur = head;
    while(cur != null){
      if(set.contains(cur)){
        return true;
      }else{
        set.add(cur);
      }
      cur = cur.next;
    }
    return false;
  }
}