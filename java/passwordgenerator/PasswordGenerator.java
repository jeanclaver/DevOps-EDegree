import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author vagrant
 */
public class PasswordGenerator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // Giving advice to user
        System.out.println(" Please enter the number of characters should your password have? ");
        try (// Get user input
        Scanner scanner = new Scanner(System.in)) {
            int length = scanner.nextInt();
            // Declaring available characters
            String characters = "1234567890!§$%&/()=?QWERTZUIOPASDFGHJKLYXCVBNMqwertzuiopasdfghjklyxcvbnm.:,;-_#+^<>";
            // Generate random password
            Random random = new Random();
            char[] password = new char[length];
            for (int i = 0; i < length; i++) {
                password[i] = characters.charAt(random.nextInt(characters.length()));
            }
            // Print out the password
            System.out.println("Your Password is:"+password);
        }
    }

}
