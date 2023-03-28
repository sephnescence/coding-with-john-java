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

            try {
                currentGuess = input.nextInt();
            } catch (Exception e) {
                String flush = input.nextLine();
                System.out.println("Please enter a valid number. Flushing: " + flush);

                currentGuess = -1;
                continue;
            }

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
