import java.util.Map;
import java.util.HashMap;

class RandomListNode{
  //int label;
  int label;
  RandomListNode next, random;
  /*RandomListNode(int label){
    this.label = label;
  } */
  RandomListNode(int label){
    this.label = label;
  }
}

public class LC_138 {
  public static void main(){
    LC_138 l = new LC_138();
    RandomListNode head = generateSinglyLL();


/*    System.out.println("TESTING");
    Map<Integer, Integer> mymap = new HashMap<Integer, Integer>();
    mymap.put(3,null);
    int hi = mymap.get(3);
    System.out.println(hi);*/


    RandomListNode cur = head;
    System.out.println("Printing");
    System.out.println();
    while(cur != null){
      System.out.println("\t (_"+ cur.label + "_)_OWN_ADDR = " + cur.toString());
      System.out.println("\t (_"+ cur.label + "_)_Next_ADDR = " + ((cur.next == null) ? "NULL" : cur.next.toString()));
      System.out.println("\t (_"+ cur.label + "_)_Rand_ADDR = " + ((cur.random == null) ? "NULL" : cur.random.toString()));
      cur = cur.next;
      System.out.println();
      System.out.println();
    }


    System.out.println();    System.out.println();    System.out.println();


    RandomListNode rHead =  l.copyRandomList(head);
    System.out.println("Printing Copy");
    System.out.println();
    while(rHead != null){
      System.out.println("\t (_"+ rHead.label + "_)_OWN_ADDR = " + rHead.toString());
      System.out.println("\t (_"+ rHead.label + "_)_Next_ADDR = " + ((rHead.next == null) ? "NULL" : rHead.next.toString()));
      System.out.println("\t (_"+ rHead.label + "_)_Rand_ADDR = " + ((rHead.random == null) ? "NULL" : rHead.random.toString()));
      rHead = rHead.next;
      System.out.println();
      System.out.println();
    }
  }

  public RandomListNode copyRandomList(RandomListNode head) {
    if(head == null) return head;

    RandomListNode iter = head, next;

    final Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();

    RandomListNode cur = head;
    while(cur != null){
      map.put(cur, new RandomListNode(cur.label));
      cur = cur.next;
    }

    for(Map.Entry<RandomListNode, RandomListNode> entry : map.entrySet()){
      final RandomListNode newNode = entry.getValue();
      newNode.next = map.get(entry.getKey().next );
      newNode.random = map.get(entry.getKey().random);
    }
    return map.get(head);
  }

  public RandomListNode copyRandomList2(RandomListNode head) {
    Map<Integer, Integer> curToNext = new HashMap<>();
    Map<Integer, Integer> curToRand = new HashMap<>();
    Map<Integer, RandomListNode> visitedRandomsMap = new HashMap<>();

    // make the hashmaps first using original head.
    RandomListNode current = head;
    while(current != null){
      curToNext.put(current.label, (current.next == null) ?  null : current.next.label);
      curToRand.put(current.label, (current.random == null) ?  null : current.random.label);
      current = current.next;
    }

    // create the deep copy.
    RandomListNode rHead = new RandomListNode(head.label);
    //RandomListNode rCurr = rHead;
    int curChar = rHead.label;


    while(curChar != -1   /*!visitedRandomsMap.containsKey(curChar)*/ ){

      int nextChar = curToNext.get(curChar) == null ? -1 : curToNext.get(curChar);

      // rand can be zero
      int randChar = curToRand.get(curChar) == null ? -1 : curToRand.get(curChar);

      RandomListNode rCurr = null;
      if(!visitedRandomsMap.containsKey(curChar)){
         rCurr = new RandomListNode(curChar);
        //put as visited.
        visitedRandomsMap.put(curChar, rCurr);
      }else{
         rCurr = visitedRandomsMap.get(curChar);
      }

      /*
      rCurr.next = visitedRandomsMap.containsKey(nextChar) ?
              visitedRandomsMap.get(nextChar) : new RandomListNode(nextChar);
      */

      // make  next AND random Node,  if they already exist, use it from the visitedRMaps.
      if(nextChar != -1) {
        if (visitedRandomsMap.containsKey(nextChar)) {
          rCurr.next = visitedRandomsMap.get(nextChar);
        } else {
          rCurr.next = new RandomListNode(nextChar);
          visitedRandomsMap.put(nextChar, rCurr.next);
        }
      }
      // make  next AND random Node,  if they already exist, use it from the visitedRMaps.
      if(randChar != -1) {
        if (visitedRandomsMap.containsKey(randChar)) {
          rCurr.random = visitedRandomsMap.get(randChar);
        } else {
          rCurr.random = new RandomListNode(randChar);
          visitedRandomsMap.put(randChar, rCurr.random);
        }
      }

      // move to the next reference
      //curChar = curToNext.get(curChar) == null ? -1 : curToNext.get(curChar);

      //if reached the end
      if(curToNext.get(curChar) == null){
        curChar = -1;
      }else{
        curChar = curToNext.get(curChar);
      }
    }
    return visitedRandomsMap.get(head.label);
  }

  private static RandomListNode generateSinglyLL(){
    RandomListNode One = new RandomListNode(1);
    RandomListNode Two = new RandomListNode(2);
    RandomListNode Three = new RandomListNode(3);
    RandomListNode Four = new RandomListNode(4);

    One.next = Two;
    Two.next = Three;
    Three.next = Four;

    One.random = Three;
    Two.random = One;
    Three.random = null;
    Four.random = One;

    return One;
  }
}
