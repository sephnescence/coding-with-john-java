public class Dog {
    String name;
    int age;
    String breed;
    String colour;
    int numberOfLegs;

    void bark() {
        System.out.println("Woof! My name is: " + name + "! I am " + age + " years old!"); // Seemingly don't have to say this.name
    }

    public static Dog makeDog(String name, int age) {
        Dog newDog = new Dog();

        newDog.name = name;
        newDog.age = age;

        return newDog;
    }
}
