public class GettersAndSetters {
    public static void main(String[] args) {
        SomeClass someClass = new SomeClass();

        try {
            someClass.setSomeNumber(2);
        } catch (IllegalArgumentException e) {
            System.out.println("Shouldn't have run into an exception trying to set the number," +
                    "but here we are. This catch statement had to be here because the method signature" +
                    "says that this particular exception can be thrown");
            System.out.println(e.getMessage());
        }

        System.out.println("someClass' someNumber value: " + someClass.getSomeNumber());

        try {
            someClass.setSomeNumber(2);
        } catch (IllegalArgumentException e) {
            System.out.println("This exception was definitely expected");
            System.out.println(e.getMessage());
        }

        System.out.println("someClass' someNumber value: " + someClass.getSomeNumber());
    }
}
