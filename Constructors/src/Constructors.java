public class Constructors {
    public static void main(String[] args) {
        /*
            Assuming here that in MyCat.java, there is a constructor with the signature `private Cat() {}`

            MyCat cat = new MyCat();
            // IDE says: Cannot resolve symbol 'Cat'.
            // Java says: java: constructor MyCat in class MyCat cannot be applied to given types;
        */

        // Even though the constructor with no params is private, you can still access other constructors like this
        MyCat cat = new MyCat("Erasmus"); // Cannot resolve symbol 'Cat'
        System.out.println("Your cat's name is: " + cat.name);
    }
}
