import java.io.*;

public class Nuke2 {
    public static void main(String[] args) throws Exception {
        BufferedReader keyboard;
        String inputString;

        keyboard = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Please enter the string: ");
        System.out.flush();        /* Make sure the line is printed immediately. */
        inputString = keyboard.readLine();

        int index = 2;
        String result = inputString.substring(0, index-1) + inputString.substring(index);
        System.out.println(result);
    }
}
