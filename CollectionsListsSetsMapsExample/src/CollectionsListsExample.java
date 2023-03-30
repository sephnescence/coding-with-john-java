import java.util.ArrayList;
import java.util.List;

public class CollectionsListsExample {
    public static void main(String[] args) {
        /*
        The advantage of Collections is that they don't need to have their lengths defined ahead of time
        John refers to them as "size flexible"

        There are differences between the three. Check the other two files

        Lists
        - Is an interface, so cannot be instantiated directly, but there are classes we can use, such as
            - ArrayList - John reckons you'll use this 99% of the time
            - LinkedList - I used these a lot at uni, but this was 15 years ago. From memory, they just have a reference to
                the next and previous items. John mentioned it might be faster to use this in some cases
        - Have a guaranteed order
        - Can contain duplicates
        - Cannot be used with primitives
        - You call .size() instead of .length() like you would have for Arrays
        - Used more than Sets in John's experience
        */

        // Example List
//        List<String> names = new ArrayList<String>(); // Apparently you do not need to have ArrayList<String> these days
        List<String> names = new ArrayList<>(); // More recent way of instantiating an ArrayList. AKA the "diamond" operator
        System.out.println(names); // Output: []

        // Always add things at the beginning of the list (Don't actually do this)
        names.add(0, "Tohru");
        names.add(0, "Kyo");
        names.add(0, "Yuki");
        System.out.println(names); // Output: [Yuki, Kyo, Tohru]

        names.clear();
        System.out.println(names); // Output: []

        // Always add things at the end (No need to provide an index)
        names.add("Tohru");
        names.add("Kyo");
        names.add("Yuki");
        System.out.println(names); // Output: [Tohru, Kyo, Yuki]

        /*
        Other ArrayList methods of interest according to John
        - set(index, value) // Overwrite something at the specified index
        - contains(Object value) // Whether the specified object appears in the ArrayList
        - remove(int index) // Removes something at the specified index
        - remove(Object value) // Will remove the first occurrence of the specified value
        - isEmpty() // As advertised

        You can use methods directly from Collections, such as
        - Collections.reverse(arraylist)
        - Collections.sort(arraylist) // Not sure why Comparators weren't mentioned though

        Not sure why you'd need to do this, but to bounce back and forth between Array and ArrayList
        - arrayListVariable.toArray() // Will return an array of Objects. Not sure how it deals with custom classes
        - arrayListVariable.toArray(new String[0]) // To coerce to an array of Strings
        - Arrays.asList(arrayVariable) // Returns a list that you cannot change
        - new ArrayList<String>(Arrays.asList(arrayVariable)) // Returns a list that you can change
        */
    }
}
