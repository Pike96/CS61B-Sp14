/* BadTransactionException.java */

/**
 *  Implements an exception that should be thrown for invalid amount.
 **/
public class BadTransactionException extends Exception {

  public int amountNumber;  // The invalid account number.

  /**
   *  Creates an exception object for invalid amount "badAmtNumber".
   **/
  public BadTransactionException(int badAmtNumber) {
    super("Invalid amount: " + badAmtNumber);

    amountNumber = badAmtNumber;
  }
}
