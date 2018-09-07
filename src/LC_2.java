public class LC_2 {

  class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

  public static void main(){
    LC_2 l = new LC_2();

    ListNode l1 = l.generatehead1();
    ListNode l2 = l.generatehead2();
    ListNode headOfSum = l.addTwoNumbers(l1,l2);
  }

  private ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    int carryOver = 0;
    ListNode dummy, p = new ListNode(0);
    dummy = p;

    while(l1 != null || l2 != null || carryOver != 0){
      if(l1 != null){
        carryOver += l1.val;
        l1 = l1.next;
      }

      if(l2 != null){
        carryOver += l2.val;
        l2 = l2.next;
      }
      p.next = new ListNode(carryOver % 10);
      carryOver /= 10;
      p = p.next;

    }
    return dummy;
  }



  private ListNode addTwoNumbers4(ListNode l1, ListNode l2) {
    StringBuilder num1 = new StringBuilder();
    ListNode curL1 = l1;
    while(curL1 != null){
      num1.append(curL1.val);
      curL1 = curL1.next;
    }
    int num1Val = Integer.valueOf(num1.reverse().toString());

    StringBuilder num2 = new StringBuilder();
    ListNode curL2 = l2;
    while(curL2 != null){
      num2.append(curL2.val);
      curL2 = curL2.next;
    }
    int num2Val = Integer.valueOf(num2.reverse().toString());
    int sum = num1Val + num2Val;
    ListNode sumHead = generateSumHead(sum);
    return sumHead;

  }

  private ListNode generateSumHead(int sum) {
    String sumStr = String.valueOf(sum);

  ListNode sumHead = new ListNode(  sumStr.charAt( sumStr.length()-1 ) - '0');
    ListNode curSumNode = sumHead;
    for(int i = sumStr.length() - 2; i >= 0; i--){
      curSumNode.next = new ListNode(Integer.valueOf(sumStr.charAt(i) - '0'));
      curSumNode = curSumNode.next;
    }
    System.out.println("done");
    return sumHead;
  }

  public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
    ListNode curL1 = l1;
    ListNode curL2 = l2;

    boolean isCarriedOver = ((l1.val + l2.val) / 10 > 0) ? true : false;

    ListNode sumHead = new ListNode((l1.val + l2.val)% 10);
    ListNode curSumNode = sumHead;

    // keep constructing as long as there is stuff to add
    while(l1 == null || l2 == null){
      int curSumVal = (isCarriedOver) ? 1: 0;

      if(l1 != null && l2 != null){
        //both lists are not null;
        curSumVal = curL1.val + curL2.val;
        if(isCarriedOver){
          curSumVal++;
        }
        curSumNode.next = new ListNode(curSumVal % 10);
        isCarriedOver = curSumVal / 10  > 0 ? true : false;
        continue;
      }else if(l1 == null){
        // if there is only l2 left
        curSumNode.next = l2;
        if(isCarriedOver){
         // curSumVal = cu
        }
      } else if(l2 == null) {
        // if there is only l1 left
        curSumNode.next = l1;
        curSumNode = curSumNode.next;
      }
      //taking care of carry over num, if there is any
      //int sumVal =
      if(isCarriedOver){

      }

      isCarriedOver = ((l1.val + l2.val) / 10 > 0) ? true : false;

    }


    return null;
  }

  private ListNode generatehead1() {
    ListNode head = new ListNode(2);
    head.next = new ListNode(4);
    head.next.next = new ListNode(3);
    return head;
  }

  private ListNode generatehead2() {
    ListNode head = new ListNode(5);
    head.next = new ListNode(6);
    head.next.next = new ListNode(4);
    return head;
  }


}
