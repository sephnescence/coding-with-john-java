public class GenericsExample {
    public static void main(String[] args) {
        // Golden path example
        Printer<Integer> intPrinter = new Printer<>(31);
        Printer<Double> doublePrinter = new Printer<>(31.23);
        /*
         Note. You cannot stick a primitive in the diamond operator. e.g. <int> Won't work. You must use the class
         based version instead
        */

        System.out.println("Printing an Integer");
        intPrinter.print();
        System.out.println("Printing a Double");
        doublePrinter.print();

        Printer<Cat> catPrinter = new Printer<>(new Cat());
        System.out.println("Printing a Cat");
        catPrinter.print();

        /*
         The following would get this error
         - no instance(s) of type variable(s) exist so that Dog conforms to Cat inference variable T has incompatible bounds: equality constraints: Cat lower bounds: Dog

         You are forced to use the type that you passed in. So Cats can only go in a Printer<Cat> class
         You've already seen this with classes like ArrayList<Cat>

         Printer<Cat> catPrinterExceptItsADogPrinterInDisguise = new Printer<>(new Dog());

         If you do want to pursue being able to have Cats and Dogs in the same printer, you must instead define a different class
         - For example, with an abstract class
           `class ClassAnimalPrinter <A extends Animal>{`
           Note that `<A extends Animal>` makes it a Bound Generic
         - For example, with an interface
           `class InterfaceAnimalPrinter <A extends AnimalNoises>{`
           Note that we still use the `extends` syntax instead of `implements` even for interfaces
         - For example, BOTH a class that extends an interface
           `class InterfaceAnimalPrinter <A extends Animal & AnimalNoises>{`
           Note that the class name MUST come first
           Note that there can only be one class name
           Note that you can keep attaching as many interfaces as you like, so long as the class is listed first

         You will notice that this time, the class is defined with A instead of T. This is to illustrate that it really doesn't
           matter what it's called, but T is the standard convention. Think of it as referring to Type
        */
        ClassAnimalPrinter<Animal> classAnimalPrinter1 = new ClassAnimalPrinter<>(new Cat());
        ClassAnimalPrinter<Animal> classAnimalPrinter2 = new ClassAnimalPrinter<>(new Dog());
        System.out.println("[Class based] Printing an Cat");
        classAnimalPrinter1.print();
        System.out.println("[Class based] Printing a Dog");
        classAnimalPrinter2.print();

        InterfaceAnimalPrinter<Animal> interfaceAnimalPrinter1 = new InterfaceAnimalPrinter<>(new Cat());
        InterfaceAnimalPrinter<Animal> interfaceAnimalPrinter2 = new InterfaceAnimalPrinter<>(new Dog());
        System.out.println("[Interface based] Printing an Cat");
        interfaceAnimalPrinter1.print();
        System.out.println("[Interface based] Printing a Dog");
        interfaceAnimalPrinter2.print();

    }
}

class Printer <T>{
    T thingToPrint;

    Printer(T thingToPrint) {
        this.thingToPrint = thingToPrint;
    }

    public void print() {
        System.out.println(this.thingToPrint);
    }
}

class ClassAnimalPrinter <A extends Animal>{
    A animalToPrint;

    ClassAnimalPrinter(A animalToPrint) {
        this.animalToPrint = animalToPrint;
    }

    public void print() {
        System.out.println("[Class based] Animal print method...");
        animalToPrint.print(); // This comes from the Animal abstract class
        System.out.println("[Class based] AnimalNoises makeNoise method...");
        animalToPrint.makeNoise(); // This comes from the AnimalNoises interface, but Java knows Animal implements AnimalNoises
    }
}

interface AnimalNoises {
    void makeNoise();
}

abstract class Animal implements AnimalNoises {
    public void print() {
        System.out.print("I am of " + getClass() + "! Hear me ");
        this.makeNoise();
    }
}

class Cat extends Animal {
    @Override
    public void makeNoise() {
        System.out.println("Meow!");
    }
}

class Dog extends Animal {
    @Override
    public void makeNoise() {
        System.out.println("Woof!");
    }
}

class InterfaceAnimalPrinter <A extends AnimalNoises>{
    A animalToPrint;

    InterfaceAnimalPrinter(A animalToPrint) {
        this.animalToPrint = animalToPrint;
    }

    public void print() {
        // System.out.println("[Interface based] Animal print method...");
        // animalToPrint.print(); // This comes from the Animal abstract class, so it's not available here
        System.out.println("[Interface based] AnimalNoises makeNoise method...");
        animalToPrint.makeNoise(); // This comes from the AnimalNoises interface, but Java knows Animal implements AnimalNoises
    }
}