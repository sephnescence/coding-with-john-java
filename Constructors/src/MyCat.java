public class MyCat {
    String name;
//    String breed;

    private MyCat() {} // This means you cannot instantiate MyCat. You must use a factory kind of thing instead
//    public MyCat() {}

    public MyCat(String name) {
        this.name = name;
    }

/*
    The following is invalid because the signature is the same as `public MyCat(String name)`
    Despite the name of the attribute being different, it's impossible for Java to know if you're providing
            a name or a breed
    public MyCat(String breed) {
        this.breed = breed;
    }
*/
}
