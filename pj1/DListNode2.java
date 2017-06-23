/* DListNode2.java */

/**
 *  A DListNode2 is a node in a DList2 (doubly-linked list).
 */

public class DListNode2 {

  /**
   *  item references the item stored in the current node.
   *  prev references the previous node in the DList.
   *  next references the next node in the DList.
   *
   *  DO NOT CHANGE THE FOLLOWING FIELD DECLARATIONS.
   */

  public RLEComponent item;
  public DListNode2 prev;
  public DListNode2 next;

  /**
   *  DListNode2() constructor.
   */
  DListNode2() {
    item = new RLEComponent();
    prev = null;
    next = null;
  }

  DListNode2(RLEComponent i) {
    item = i;
    prev = null;
    next = null;
  }

}
