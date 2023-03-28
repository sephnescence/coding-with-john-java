public class Arrays {
    public static void main(String[] args) {
        String[] stringsFromArray = new String[4];
        stringsFromArray[0] = "one";
        stringsFromArray[1] = "two";
        stringsFromArray[2] = "three";
        stringsFromArray[3] = "four";
        printArray(stringsFromArray);

        String[] stringsFromJson = {"One", "Two", "Three", "Four"};
        printArray(stringsFromJson);
    }

    private static void printArray(String[] stringArray) {
        for (int i = 0; i < stringArray.length; i++) {
            System.out.println(stringArray[i]);
        }

        for (String str : stringArray) {
            System.out.println(str);
        }
    }
}
