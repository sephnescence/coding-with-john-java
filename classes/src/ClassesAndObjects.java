import java.sql.Array;
import java.util.List;
import java.util.Scanner;

public class ClassesAndObjects {
    public static void main(String[] args) {
        Dog myDog = new Dog();

        Scanner dogInput = new Scanner(System.in);

        System.out.println("What is your dog's name?");
        String dogName = dogInput.nextLine();

        System.out.println("How old is " + dogName + "?");
        int dogAge = dogInput.nextInt();

//        Scanners have a whole bunch of ways to get input, so you don't need to cast anything. Nice
//        dogInput.nextLine()
//        dogInput.nextInt()
//        dogInput.nextBigDecimal()
//        dogInput.nextBigInteger()
//        dogInput.nextBoolean()
//        dogInput.nextInt()
//        dogInput.nextByte()
//        dogInput.nextDouble()
//        dogInput.nextFloat()
//        dogInput.nextLong()
//        dogInput.nextShort()

        myDog.name = "Doug";
        myDog.bark();

        Dog yourDog = Dog.makeDog(
            dogName,
            dogAge
        );

        System.out.println("Great! Welcome, " + yourDog.name + "!");
        yourDog.bark();
    }
}
