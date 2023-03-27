public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Blake's Hello World!");

        double float1 = 8.4;
        double float2 = 4.6;

        System.out.println(float1 / float2); // 1.8260869565217392
        System.out.println(Math.round(float1) / float2); // 1.7391304347826089
        System.out.println(Math.round(float1) / Math.round(float2)); // 1

//         John goes over the primitives

//         byte: -128 to 127 // So 256 numbers. 8 bit / 1 byte. As advertised
//         short: -32,768 to 32,767
//         int: -2,147,483,648 to 2,147,483,647
//         long: -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807
            /*
                Alternatively, you can specify 1234l (The letter L, much like the letter F below for floats. However,
                    it's not required for longs. Without the F for floats, Java apparently thinks it's a double
             */
//         float: 6 decimal place. e.g. 6.3f
//         double: about 15 decimal digits... "about"? BTTODO e.g. 45.21343434343434
//         boolean: true or false // Doesn't appear to have t/f counterpart, and TRUE/FALSE don't work either
//         char: one character. e.g. 'W' // Assuming this isn't going to support unicode

//         String is not a primitive. However in contrast to the the character above 'W', "Strings must be wrapped in double quotes"

//         Given the String exampleString = "example"
//         exampleString.length() returns 7
//         exampleString.charAt(0) returns the character at the position. 0 based. i.e. 'e'
//         exampleString.charAt(100) throws StringIndexOutOfBoundsException

//        String exampleString = "example";
//        System.out.println(exampleString.charAt(100));

//         Randomly, the type of a String appears to be StringLatin1 under the hood? I wonder what a Japanese string would look like?
//         String japaneseString = "辞典"; // (じてん / dictionary)
//         System.out.println(japaneseString);
//         System.out.println(japaneseString.charAt(2)); // Ah, it's a StringUTF16

//         String concatenatedString = "concatenated" + " " + "string"

//        String camelString = "upperCaseThis";
//        camelString.toUpperCase(); // Doesn't mutate camelString. In fact, this line shows a warning since it is a noop
//        System.out.println(camelString); // upperCaseThis

//        final String exampleFinal = "This is final"; // Equivalent of const in JS
    }
    
    public static void toUpperCaseByReference(String stringToUpperCase) {

    }
}
