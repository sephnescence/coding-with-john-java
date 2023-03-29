// You don't need to specify an import if you're using the fully qualified name
//import net.sephnescence.Cat; // This is commented because it's unnecessary

public class PackageProtectionExample {
    public static void main(String[] args) {
        net.sephnescence.Cat kitty = new net.sephnescence.Cat();
        kitty.meow();

        com.sephnescence.Cat queen = new com.sephnescence.Cat();
        queen.meow();

        // Standard Private Protection
        // If we were to have the following line uncommented, you'd get the below
        // kitty.hiss();
        // IDE: hiss() has private access in 'net.sephnescence.Cat'
        // Java itself: java: hiss() has private access in 'net.sephnescence.Cat'

        // Package Protection
        // If we were to have the following line uncommented, you'd get the below
        // kitty.knead();
        // IDE: hiss() is not public in 'net.sephnescence.Cat'. Cannot be accessed from outside package
        // Java itself: java: knead() is not public in net.sephnescence.Cat; cannot be accessed from outside package
    }
}
