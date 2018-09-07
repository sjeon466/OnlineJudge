import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class ListNod{
  String str;
  ListNod next;
  public ListNod(){};
  public ListNod(String str){
    this.str = str;
    next = null;
  }
}

public class LC_160 {
  public static void main(){
    List<ListNod> heads = generateHeads();
    LC_160 l = new LC_160();
    System.out.println(l.getIntersectionNode(heads.get(0), heads.get(1)));
  }


  public ListNod getIntersectionNode(ListNod headA, ListNod headB) {

    if(headA == null || headB == null) return null;

    ListNod cur1 = headA;
    ListNod cur2 = headB;

    while(cur1 != cur2){
      if(cur1 == null) cur1 = headB;
      else cur1 = cur1.next;

      if(cur2 == null) cur2 = headA;
      else cur2 = cur2.next;
    }
    return cur1;
  }


  public ListNod getIntersectionNode3(ListNod headA, ListNod headB) {
    Set<ListNod> set = new HashSet<ListNod>();
    ListNod curA = headA;
    ListNod curB = headB;
    while(curA != null){
      set.add(curA);
      curA = curA.next;
    }

    while(curB != null){
      if(set.contains(curB)){
        return curB;
      }
    }
    return null;
  }


  private static List<ListNod> generateHeads() {
    ListNod a1 = new ListNod("a1");
    ListNod a2 = new ListNod("a2");
    ListNod c1 = new ListNod("c1");
    ListNod c2 = new ListNod("c2");
    ListNod c3 = new ListNod("c3");
    ListNod b1 = new ListNod("b1");
    ListNod b2 = new ListNod("b2");
    ListNod b3 = new ListNod("b3");
    a1.next = a2;
    a2.next = c1;
    c1.next = c2;
    c2.next = c3;
    b1.next = b2;
    b2.next = b3;
    b3.next = c1;
    ArrayList<ListNod> list = new ArrayList<>();
    list.add(a1);
    list.add(b1);
    return list;
  }


}

