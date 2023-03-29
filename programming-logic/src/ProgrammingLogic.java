import java.util.Random;
import java.util.Scanner;

public class ProgrammingLogic {
    public static void main(String[] args) {
        Random rand = new Random();
        int theNumberToGuess = rand.nextInt(100) + 1;

        System.out.println("This is the number I want you to guess - " + theNumberToGuess);

        Scanner input = new Scanner(System.in);
        int currentGuess = -1;
        while (currentGuess != theNumberToGuess) {
            System.out.println("Guess the number...");

            // Apparently try, catch and finally appear on new lines
            try {
                currentGuess = input.nextInt();
            }
            catch (Exception e) {
                // e.printStackTrace(); // You may wish to print the stack trace
                String flush = input.nextLine();
                System.out.println("Please enter a valid number. Flushing: " + flush);

                currentGuess = -1;
                continue;
            }
//            finally {
//                System.out.println("There's no need to actually run this example");
//            }

            if (currentGuess < theNumberToGuess) {
                System.out.print("Your guess was too low. ");
            } else if (currentGuess > theNumberToGuess) {
                System.out.print("Your guess was too high. ");
            } else {
                System.out.println("Your guess was just right! Well done!");
                break; // Probably don't need to break, but it can't hurt
            }
        }
    }
}
