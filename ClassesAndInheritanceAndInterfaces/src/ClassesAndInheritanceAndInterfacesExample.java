public class ClassesAndInheritanceAndInterfacesExample {
    public static void main(String[] args) {
        /*
        Note the below. IAnimalInterface -> (abstract) Animal
            -> Dog -> BorderCollie (final, so no further children possible)
            -> Cat (final, so no further children possible)

        Final classes cannot have children. If you look below, you'll see that Siamese had to be commented out

        Final methods cannot be overridden. Animal.speak() for example cannot be changed, but is available to Cats and Dogs

        If you want to reference something from a parent's implementation. You can use `super`. e.g. BorderCollie.speak()
            will also call Dog.speak()
        */

        Animal[] animals = new Animal[3];
        animals[0] = new Cat();
        animals[1] = new Dog();
        animals[2] = new BorderCollie();

        for (Animal animal : animals) {
            System.out.print(animal + " says: ");
            animal.speak();
        }

        System.out.println("Checking if a Cat and Dog are the same. Spoiler, no. I made it so that comparing to another Animal will always return false");

        // Without having defined equals() yet, intelliJ gives me a warning about this
        // It says 'equals' between objects of inconvertible type 'Cat' and 'Dog'
        // But it doesn't throw any errors
        System.out.println(animals[0].equals(animals[1]));

        /*
        It's worth noting that equals is just calling double equals. triple equals (===) is not a thing like js

        java/lang/Object.java has the equals and toString methods made already, so you don't have to

        public boolean equals(Object obj) { return (this == obj); }
        public String toString() { return getClass().getName() + "@" + Integer.toHexString(hashCode()); }
        */

        System.out.println("Checking if a Dog and BorderCollie are the same. Spoiler, yes. I updated Dog so that it will return true when compared to other dogs");
        System.out.println(animals[1].equals(animals[2]));

        /*
        Output:

        Cat says: Meow
        Dog says: Woof
        BorderCollie says: Woof
        Bark! (Border Collies are very excitable)
         */

        // In js you use let/const, you can have an equivalent of const by adding final to the variable name
    }

    interface IAnimalInterface {
        abstract public void makeNoise();
    }

    abstract static class Animal implements IAnimalInterface {
        final public void speak() {
            this.makeNoise();
        }

        final public String toString() {
//            return getClass().getName(); // Returns ClassesAndInheritanceAndInterfacesExample$Cat, ClassesAndInheritanceAndInterfacesExample$Dog, ClassesAndInheritanceAndInterfacesExample$BorderCollies
            return getClass().getSimpleName(); // Returns Cat/Dog/BorderCollie
        }

        public boolean equals(Animal otherAnimal) {
            return false; // Just blanket say no
        }
    }

    static class Dog extends Animal {
        @Override
        public void makeNoise() {
            System.out.println("Woof");
        }

        @Override
        public boolean equals(Animal otherAnimal) {
            return otherAnimal instanceof Dog;
        }
    }

    static final class BorderCollie extends Dog {
        @Override
        public void makeNoise() {
            super.makeNoise();
            System.out.println("Bark! (Border Collies are very excitable)");
        }
    }

    static final class Cat extends Animal {
        @Override
        public void makeNoise() {
            // Apparently you don't need the override here, but intelliJ put it in anyways
            // Odd given the method is abstract

            System.out.println("Meow");
        }
    }

//    class Siamese extends Cat {
        // IDE: Cannot inherit from final 'ClassesAndInheritanceAndInterfaces.Cat'
        // Though I've also seen: The type Siamese cannot subclass the final class Cat
//    }
}
