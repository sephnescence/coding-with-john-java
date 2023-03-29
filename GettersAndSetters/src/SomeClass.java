public class SomeClass {
    public int getSomeNumber() {
        return someNumber;
    }

    public void setSomeNumber(int someNumber) throws IllegalArgumentException {
        if (someNumber < 0) {
            throw new IllegalArgumentException("Some");
        }
        this.someNumber = someNumber;
    }

    private int someNumber = 0;


}
