/* DList2.java */

/**
 *  A DList2 is a mutable doubly-linked list.  Its implementation is
 *  circularly-linked and employs a sentinel (dummy) node at the head
 *  of the list.
 */

public class DList2 {

  /**
   *  head references the sentinel node.
   *
   *  DO NOT CHANGE THE FOLLOWING FIELD DECLARATIONS.
   */

  protected DListNode2 head;
  protected long size;

  /* DList2 invariants:
   *  1)  head != null.
   *  2)  For any DListNode2 x in a DList2, x.next != null.
   *  3)  For any DListNode2 x in a DList2, x.prev != null.
   *  4)  For any DListNode2 x in a DList2, if x.next == y, then y.prev == x.
   *  5)  For any DListNode2 x in a DList2, if x.prev == y, then y.next == x.
   *  6)  size is the number of DListNode2s, NOT COUNTING the sentinel
   *      (denoted by "head"), that can be accessed from the sentinel by
   *      a sequence of "next" references.
   */

  /**
   *  DList2() constructor for an empty DList2.
   */
  public DList2() {
    head = new DListNode2();
    head.item = new RLEComponent();
    head.next = head;
    head.prev = head;
    size = 0;
  }

  /**
   *  DList2() constructor for a one-node DList2.
   */
  public DList2(RLEComponent a) {
    head = new DListNode2();
    head.item = new RLEComponent();
    head.next = new DListNode2();
    head.next.item = a;
    head.prev = head.next;
    head.next.prev = head;
    head.prev.next = head;
    size = 1;
  }

  /**
   *  DList2() constructor for a two-node DList2.
   */
  public DList2(RLEComponent a, RLEComponent b) {
    if (a.intensity == b.intensity) {
      RLEComponent c = new RLEComponent(a.intensity, a.length + b.length)
      this(c);
    } else {
      head = new DListNode2();
      head.item = new RLEComponent();
      head.next = new DListNode2();
      head.next.item = a;
      head.prev = new DListNode2();
      head.prev.item = b;
      head.next.prev = head;
      head.next.next = head.prev;
      head.prev.next = head;
      head.prev.prev = head.next;
      size = 2;
      ]
    }

  /**
   *  insertFront() inserts an item at the front of a DList2.
   */
   public void insertFront(RLEComponent i) {
     // Your solution here.
     if (size > 0 & i.intensity == head.next.item.intensity) {
       head.next.item.length += i.length;
     } else {
       DListNode2 newNode = new DListNode2(i);
       newNode.next = head.next;
       head.next.prev = newNode;
       head.next = newNode;
       newNode.prev = head;
       size++;
     }
  }
  public void insertEnd(RLEComponent i) {
    // Your solution here.
    if (size > 0 & i.intensity == head.prev.item.intensity) {
      head.prev.item.length += i.length;
    } else {
      DListNode2 newNode = new DListNode2(i);
      newNode.prev = head.prev;
      head.prev.next = newNode;
      head.prev = newNode;
      newNode.next = head;
      size++;
    }
  }
  public void attach(DList2 other) {
    if (this.head.prev.item.intensity == other.head.next.item.intensity) {
      this.head.prev.item.leghth += other.head.next.item.length;
      other.removeFront();
    }
    other.head.next.prev = this.head.prev;
    this.head.prev.next = other.head.next;
    this.head.prev = other.head.prev;
    other.head.prev.next = this.head;
  }

  /**
   *  removeFront() removes the first item (and first non-sentinel node) from
   *  a DList2.  If the list is empty, do nothing.
   */
  public void removeFront() {
    // Your solution here.
    if (size > 0) {
      head.next = head.next.next;
      head.next.prev = head;
      size--;
    }
  }
  public void removeEnd() {
    // Your solution here.
    if (size > 0) {
      head.prev = head.prev.prev;
      head.prev.next = head;
      size--;
    }
  }

  public long getSize() {
    return size;
  }

  /**
   *  toString() returns a String representation of this DList.
   *
   *  DO NOT CHANGE THIS METHOD.
   *
   *  @return a String representation of this DList.
   */
  public String toString() {
    String result = "[ ";
    DListNode2 current = head.next;
    while (current != head) {
      result = result + current.item + "  ";
      current = current.next;
    }
    return result + "]";
  }

  public static void main(String[] args) {
    // DO NOT CHANGE THE FOLLOWING CODE.

    DList2 l = new DList2();
    System.out.println("### TESTING insertFront ###\nEmpty list is " + l);

    l.insertFront(9);
    System.out.println("\nInserting 9 at front.\nList with 9 is " + l);
    if (l.head.next.item != 9) {
      System.out.println("head.next.item is wrong.");
    }
    if (l.head.next.prev != l.head) {
      System.out.println("head.next.prev is wrong.");
    }
    if (l.head.prev.item != 9) {
      System.out.println("head.prev.item is wrong.");
    }
    if (l.head.prev.next != l.head) {
      System.out.println("head.prev.next is wrong.");
    }
    if (l.size != 1) {
      System.out.println("size is wrong.");
    }

    l.insertFront(8);
    System.out.println("\nInserting 8 at front.\nList with 8 and 9 is " + l);
    if (l.head.next.item != 8) {
      System.out.println("head.next.item is wrong.");
    }
    if (l.head.next.prev != l.head) {
      System.out.println("head.next.prev is wrong.");
    }
    if (l.head.prev.item != 9) {
      System.out.println("head.prev.item is wrong.");
    }
    if (l.head.prev.next != l.head) {
      System.out.println("head.prev.next is wrong.");
    }
    if (l.head.next.next != l.head.prev) {
      System.out.println("l.head.next.next != l.head.prev.");
    }
    if (l.head.prev.prev != l.head.next) {
      System.out.println("l.head.prev.prev != l.head.next.");
    }
    if (l.size != 2) {
      System.out.println("size is wrong.");
    }



    l = new DList2(1, 2);
    System.out.println("\n\n### TESTING removeFront ###\nList with 1 and 2 is "
                       + l);

    l.removeFront();
    System.out.println("\nList with 2 is " + l);
    if (l.head.next.item != 2) {
      System.out.println("head.next.item is wrong.");
    }
    if (l.head.next.prev != l.head) {
      System.out.println("head.next.prev is wrong.");
    }
    if (l.head.prev.item != 2) {
      System.out.println("head.prev.item is wrong.");
    }
    if (l.head.prev.next != l.head) {
      System.out.println("head.prev.next is wrong.");
    }
    if (l.size != 1) {
      System.out.println("size is wrong.");
    }

    l.removeFront();
    System.out.println("\nEmpty list is " + l);
    if (l.head.next != l.head) {
      System.out.println("head.next is wrong.");
    }
    if (l.head.prev != l.head) {
      System.out.println("head.prev is wrong.");
    }
    if (l.size != 0) {
      System.out.println("size is wrong.");
    }

    l.removeFront();
    System.out.println("\nEmpty list is " + l);
    if (l.head.next != l.head) {
      System.out.println("head.next is wrong.");
    }
    if (l.head.prev != l.head) {
      System.out.println("head.prev is wrong.");
    }
    if (l.size != 0) {
      System.out.println("size is wrong.");
    }
    DList2 la = new DList2()
  }

}
