public class LambdaExpressionsExample {
    public static void main(String[] args) {
        /*
         A lambda method is a shortcut to defining an implementation of a Functional Interface

         Functional Interfaces are where you have an interface, but it only has one abstract method to define
            It may contain static implementations and default implementations

         There is an Annotation for it as well - @FunctionalInterface. This is best practice, and your IDE will
         enforce that there's only one abstract method in there
        */

        Printable printable = () -> "";
        // printThing(printable); // Where does this come from though?
    }
}

@FunctionalInterface
interface Printable { // For the sake of this example, Printable cannot be a public interface
    String print();
    /*
     String print2(); // If this were uncommented, IntelliJ would highlight the annotation above and say
     "Multiple non-overriding abstract methods found in interface Printable"
    */

    static String getString() {
        return "This is allowed";
    }

    // public String getString() { return "This is not allowed"; }
}