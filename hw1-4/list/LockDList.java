/* LockDList.java */

package list;

public class LockDList extends DList{

  public void lockNode(DListNode node) {
    ((LockDListNode) node).locked = true;
  }

  protected DListNode newNode(Object item, DListNode prev, DListNode next) {
    return new LockDListNode(item, prev, next);
  }

  public void remove(DListNode node) {
    if (node == null || ((LockDListNode) node).locked == true) {
      return;
    }
    super.remove(node);
  }

  public static void main(String[] args) {
    LockDList l = new LockDList();
    System.out.println("Empty list is " + l);

    l.insertFront(9);
    System.out.println("\nInserting 9 at front.\nList with 9 is " + l);

    l.insertFront(8);
    System.out.println("\nInserting 8 at front.\nList with 8 and 9 is " + l);

    l.insertBack(5);
    System.out.println("\nInserting 5 at back.\nList with 8, 9, 5 is " + l);

    System.out.println("\nTest front(): " + l.front().item);
    System.out.println("Test back(): " + l.back().item);
    System.out.println("Test next() of head: " + l.next(l.head).item);
    System.out.println("Test prev() of head: " + l.prev(l.head).item);

    l.insertAfter(3, l.head.next);
    System.out.println("Test insert 3 after the 1st node: " + l);
    l.insertBefore(2, l.head.prev);
    System.out.println("Test insert 2 after the last node: " + l);
    l.remove(l.head.prev);
    System.out.println("Test remove the last node: " + l);
    l.lockNode(l.head.next);
    l.remove(l.head.next);
    System.out.println("Test remove the first node after locked: " + l);

  }
}
