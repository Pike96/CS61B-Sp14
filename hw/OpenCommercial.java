import java.net.*;
import java.io.*;

/**  A class that provides a main function to read five lines of a commercial
*   Web page and print them in reverse order, given the name of a company.
*/

class OpenCommercial {

    /** Prompts the user for the name X of a company (a single string), opens
    *  the Web site corresponding to www.X.com, and prints the first five lines
    *  of the Web page in reverse order.
    *  @param arg is not used.
    *  @exception Exception thrown if there are any problems parsing the
    *             user's input or opening the connection.
    */
    public static void main(String[] arg) throws Exception {

        BufferedReader keyboard;
        String inputLine;

        keyboard = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Please enter the name of a company (without spaces): ");
        System.out.flush();        /* Make sure the line is printed immediately. */
        inputLine = keyboard.readLine();

        String inputURL = "http://www." + inputLine + ".com/";

        URL address = new URL(inputURL);
        BufferedReader in = new BufferedReader(
        new InputStreamReader(address.openStream()));

        int numLines = 5;
        String[] webLine = new String[numLines];
        for (int i=0; i < numLines; i++) {
            webLine[i] = in.readLine();
        }
        for (int i=0; i < numLines; i++) {
            System.out.println(webLine[numLines-1-i]);
        }
        in.close();
    }
}
