/* HashTableChained.java */

package dict;
import list.*;

/**
 *  HashTableChained implements a Dictionary as a hash table with chaining.
 *  All objects used as keys must have a valid hashCode() method, which is
 *  used to determine which bucket of the hash table an entry is stored in.
 *  Each object's hashCode() is presumed to return an int between
 *  Integer.MIN_VALUE and Integer.MAX_VALUE.  The HashTableChained class
 *  implements only the compression function, which maps the hash code to
 *  a bucket in the table's range.
 *
 *  DO NOT CHANGE ANY PROTOTYPES IN THIS FILE.
 **/

public class HashTableChained implements Dictionary {

  /**
   *  Place any data fields here.
   **/
   private int size;
   private int N;
   private int numCollision;
   private SList[] table;


  /**
   *  Construct a new empty hash table intended to hold roughly sizeEstimate
   *  entries.  (The precise number of buckets is up to you, but we recommend
   *  you use a prime number, and shoot for a load factor between 0.5 and 1.)
   **/

  public int getSize() { return size; }
  public int getN() { return N; }
  public int getNumCollision() { return numCollision; }


  public HashTableChained(int sizeEstimate) {
    // Your solution here.
    while (!isPrime(sizeEstimate))
      sizeEstimate++;
    table = new SList[sizeEstimate];
    size = 0;
    numCollision = 0;
    N = sizeEstimate;
    for (int i = 0; i < N ; i++ ) {
      table[i] = new SList();
    }
  }

  private static boolean isPrime(int n)
  {
    if (n < 2) return false;
    for (int i = 2; i < n; i++)
      if (n % i == 0) return false;
    return true;
  }


  /**
   *  Construct a new empty hash table with a default size.  Say, a prime in
   *  the neighborhood of 100.
   **/

  public HashTableChained() {
    // Your solution here.
    this(101);
  }

  /**
   *  Converts a hash code in the range Integer.MIN_VALUE...Integer.MAX_VALUE
   *  to a value in the range 0...(size of hash table) - 1.
   *
   *  This function should have package protection (so we can test it), and
   *  should be used by insert, find, and remove.
   **/

  int compFunction(int code) {
    // Replace the following line with your solution.
	  //System.out.println((code % 16908799) % N);
    return Math.abs((code % 16908799) % N);
  }

  /**
   *  Returns the number of entries stored in the dictionary.  Entries with
   *  the same key (or even the same key and value) each still count as
   *  a separate entry.
   *  @return number of entries in the dictionary.
   **/

  public int size() {
    // Replace the following line with your solution.
    return size;
  }

  /**
   *  Tests if the dictionary is empty.
   *
   *  @return true if the dictionary has no entries; false otherwise.
   **/

  public boolean isEmpty() {
    // Replace the following line with your solution.
    return size == 0;
  }

  /**
   *  Create a new Entry object referencing the input key and associated value,
   *  and insert the entry into the dictionary.  Return a reference to the new
   *  entry.  Multiple entries with the same key (or even the same key and
   *  value) can coexist in the dictionary.
   *
   *  This method should run in O(1) time if the number of collisions is small.
   *
   *  @param key the key by which the entry can be retrieved.
   *  @param value an arbitrary object.
   *  @return an entry containing the key and value.
   **/

  public Entry insert(Object key, Object value) {
    // Replace the following line with your solution.
    Entry en = new Entry();
    en.key = key;
    en.value = value;
    int n = compFunction(key.hashCode());
    SList l = table[n];
    if (l.length() > 0) numCollision++;
    l.insertBack(en);
    size++;
    return en;
  }

  /**
   *  Search for an entry with the specified key.  If such an entry is found,
   *  return it; otherwise return null.  If several entries have the specified
   *  key, choose one arbitrarily and return it.
   *
   *  This method should run in O(1) time if the number of collisions is small.
   *
   *  @param key the search key.
   *  @return an entry containing the key and an associated value, or null if
   *          no entry contains the specified key.
   **/

  public Entry find(Object key) {
    // Replace the following line with your solution.
    SList l = table[compFunction(key.hashCode())];
    if (l.length() < 1) {
      return null;
    } else {
      for (int i = 1; i <= l.length(); i++ ) {
        if (((Entry) l.nth(i).item()).key == key) {
          return (Entry) l.nth(i).item();
        }
      }
    }
    return null;
  }

  /**
   *  Remove an entry with the specified key.  If such an entry is found,
   *  remove it from the table and return it; otherwise return null.
   *  If several entries have the specified key, choose one arbitrarily, then
   *  remove and return it.
   *
   *  This method should run in O(1) time if the number of collisions is small.
   *
   *  @param key the search key.
   *  @return an entry containing the key and an associated value, or null if
   *          no entry contains the specified key.
   */

  public Entry remove(Object key) {
    // Replace the following line with your solution.
    SList l = table[compFunction(key.hashCode())];
    if (l.length() < 1) {
      return null;
    } else {
      for (int i = 1; i <= l.length(); i++ ) {
        if (((Entry) l.nth(i).item()).key == key) {
          Entry en = new Entry();
          en = (Entry) l.nth(i).item();
          try {
            l.nth(i).remove();
            size--;
          } catch (InvalidNodeException lbe) {
            System.err.println("Caught InvalidNodeException that should not happen.");
          }
          return en;
        }
      }
    }
    return null;
  }

  /**
   *  Remove all entries from the dictionary.
   */
  public void makeEmpty() {
    // Your solution here.
    for (int i = 0; i < N ; i++ ) {
      table[i] = new SList();
    }
    size = 0;
  }

  public double collision(){
	  return (double) (size - N + N *
      Math.pow((double) (1 - 1.0 / (double) N), (double) size));
  }

  public String toString() {
    String result = new String();
    for (int i = 0; i < N; i++) {
      result += "[" + table[i].length() + "]";
      if ((i+1) % 20 == 0) {
        result += "\n";
      }
    }
    return result;
  }
  /*
  public static void main(String[] argv) {
	  System.out.println("testing");
      // test prime number function
      //test basic hash table function
      System.out.println("======================basic insert,find,remove=====================");
      HashTableChained table = new HashTableChained(99);
      System.out.println("table's size is: " + table.size());
      System.out.println("table is Empty: " + table.isEmpty());

      System.out.println("=====================insert================================");
      table.insert("1", "The first one");
      table.insert("2", "The second one");
      table.insert("3", "The third one");
      table.insert("what", "nani?");
      table.insert("the","Eh-heng");
      table.insert("hell!","impolite");
      System.out.println("table's size is: " + table.size());
      System.out.println("table is Empty: " + table.isEmpty());

      System.out.println("====================find, remove===========================");
      Entry e1 = table.find("what");
      if(e1 != null){
    	   System.out.println("The item found is: [ " + e1.value + " ]");
      }else{
    	   System.out.println("The is no such item in the table to be found.");
      }

      Entry e2 = table.remove("3");
      if(e2 != null){
    	  System.out.println("The item deleted is: [ " + e2.value + " ]");
      }else{
    	  System.out.println("The is no such item in the table to be deleted.");
      }
      System.out.println(table);

      // testing makeEmpty, isEmpty, size
      System.out.println("===============test makeEmpty===================");
      System.out.println("Is empty?: "+table.isEmpty());
      System.out.println("Size before empty: "+table.size());
      table.makeEmpty();
      System.out.println("Size after empty: "+table.size());
  }
  */
}
