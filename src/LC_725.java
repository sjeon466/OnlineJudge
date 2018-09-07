import java.util.ArrayList;
import java.util.List;

public class LC_725 {
  public static void main(){
    LC_725 l = new LC_725();
    ListNode root = l.generateHead();
  }

  private ListNode generateHead() {
    ListNode root = new ListNode(1);
    ListNode second = new ListNode(2);
    root.next = second;
    ListNode third = new ListNode(3);
    second.next = third;
    ListNode fourth = new ListNode(4);
    third.next = fourth;
    ListNode fifth = new ListNode(5);
    fourth.next = fifth;
    ListNode sixth = new ListNode(6);
    fifth.next = sixth;
    ListNode seventh = new ListNode(7);
    sixth.next = seventh;
    ListNode eigth = new ListNode(8);
    seventh.next = eigth;
    ListNode ninth = new ListNode(9);
    eigth.next = ninth;
    ListNode tenth = new ListNode(10);
    ninth.next = tenth;
    return root;
  }

  public ListNode[] splitListToParts(ListNode root, int k) {
    if(root == null || k == 0) return null;

    int count = 0;
    ListNode curNode = root;
    while(curNode != null){
      count++;
      curNode = curNode.next;
    }
    System.out.println(count);

    List<List<ListNode>> resList = new ArrayList<>(k);
    ListNode[] ansArr = new ListNode[k];

    int sizeOfEachGroup = count / k, rem = count % k;

    ListNode iterNode = root;

    for(int groupNum = 0; groupNum < k; ++groupNum){
      ListNode head = new ListNode(0), write = head;
      for(int j = 0; j < sizeOfEachGroup + (groupNum < rem ? 1: 0); j++){
        write = write.next = new ListNode(iterNode.val);
        if(iterNode != null) iterNode = iterNode.next;
      }
      ansArr[groupNum] = head.next;
    }
    return ansArr;

  }
}
