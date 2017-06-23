/* LockDListNode.java */

package list;

public class LockDListNode extends DListNode {

  protected boolean locked;

  LockDListNode (Object i, DListNode p, DListNode n) {
    super(i, p, n);
    locked = false;
  }
}
