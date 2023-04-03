import java.util.ArrayList;
import java.util.Random;

public class AdvancedGenericsExample {
    public static void main(String[] args) {
        /*
         Interesting to note that these two methods don't collide / clash (The IDE refers to it as a clash)
         - private static <T> void genericMethodPrintTheThing(T thingToPrint)
         - private static <T extends Animal & AnimalNoises> void genericMethodPrintTheThing(T thingToPrint)
         I guess that there is a CSS like thing going on where Java will determine the more specific method to call?
        */
        genericMethodPrintTheThing(new Cat());
        genericMethodPrintTheThing(new Dog());

        // You can also define methods with two generics
        Animal animal = genericDetermineMyFavouriteOfTwoAnimals(new Cat(), new Dog());
        animal.makeNoise();

        Animal animal2 = genericDetermineMyFavouriteOfTwoAnimals(new Dog(), new Cat());
        animal2.makeNoise();

        Animal animal3 = genericDetermineMyFavouriteOfTwoAnimals(new Cat(), new Cat());
        animal3.makeNoise();

        ArrayList<Cat> cats = new ArrayList<>();
        cats.add(new Cat());
        cats.add(new Cat());
        genericWithTheUnknownWildcard(cats);

        ArrayList<Cat> alCats = new ArrayList<>();
        alCats.add(new Cat());
        alCats.add(new Cat());

        ArrayList<Dog> alDogs = new ArrayList<>();
        alDogs.add(new Dog());
        alDogs.add(new Dog());

        ArrayList<Animal> alAnimals = new ArrayList<>();
        alAnimals.add(new Cat());
        alAnimals.add(new Cat());
        alAnimals.add(new Dog());
        alAnimals.add(new Dog());

        genericWithABoundUnknownWildcard(alCats);
        genericWithABoundUnknownWildcard(alDogs);
        genericWithABoundUnknownWildcard(alAnimals);
    }

    // This doesn't clash with the signature below
    private static <T> void genericMethodPrintTheThing(T thingToPrint) {
        System.out.println("genericMethodPrintTheThing: " + thingToPrint);
    }

    // But this one does
    // private static <T extends Animal> void genericMethodPrintTheThing(T thingToPrint) {
    //    System.out.println("genericMethodPrintTheThing: " + thingToPrint);
    // }

    private static <T extends Animal & AnimalNoises> void genericMethodPrintTheThing(T thingToPrint) {
        System.out.println("genericMethodPrintTheThing: " + thingToPrint);
    }

    private static <T extends Animal, V extends Animal> Animal genericDetermineMyFavouriteOfTwoAnimals(T animal1, V animal2) {
        if (animal1 instanceof Cat && animal2 instanceof Dog) {
            return animal1;
        } else if (animal2 instanceof Cat && animal1 instanceof Dog) {
            return animal2;
        }

        Random rand = new Random();
        boolean animal1Or2 = rand.nextBoolean();

        return animal1Or2 ? animal1 : animal2;
    }

    /*
     Sadly this one won't work. "Wildcards may only be used as reference parameters"
     private static void genericWithTheUnknownWildcard(? whatIsThis) {}
     Neither does this. "Parameter expected"
     private static void genericWithTheUnknownWildcard(<?> whatIsThis) {}
    */

    // But this will. ? means that we don't know what the ArrayList will have in it
    private static void genericWithTheUnknownWildcard(ArrayList<?> whatIsThis) {
        System.out.println("genericWithTheUnknownWildcard...");
        int length = whatIsThis.size();
        for (int i = 0; i < length; i++) {
            System.out.println(whatIsThis.get(i));
        }
    }

    // Note that unlike in these two methods
    // - private static <T> void genericMethodPrintTheThing(T thingToPrint)
    // - private static <T extends Animal & AnimalNoises> void genericMethodPrintTheThing(T thingToPrint)
    // The following two definitely do clash
    // - private static void genericWithTheUnknownWildcard(ArrayList<?> whatIsThis)
    // - private static void genericWithTheUnknownWildcard(ArrayList<? extends Animal> whatIsThis)
    private static void genericWithABoundUnknownWildcard(ArrayList<? extends Animal> whatIsThis) {
        System.out.println("genericWithABoundUnknownWildcard...");
        int length = whatIsThis.size();
        for (int i = 0; i < length; i++) {
            System.out.println(whatIsThis.get(i));
        }
    }
}
