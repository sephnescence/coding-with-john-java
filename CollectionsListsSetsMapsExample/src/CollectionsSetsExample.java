import com.sun.source.tree.Tree;

import java.util.*;

public class CollectionsSetsExample {
    public static void main(String[] args) {
        /*
        The advantage of Collections is that they don't need to have their lengths defined ahead of time
        John refers to them as "size flexible"

        There are differences between the three. Check the other two files

        Sets
        - Is an interface, so cannot be instantiated directly, but there are classes we can use, such as
            - HashSet - John reckons you'll use this 99% of the time as well
            - TreeSet - Slower than a HashSet because maintaining the order has overheads
        - Have no order (TreeSet has a "natural" order though)
        - Cannot contain duplicates, but won't raise an exception if a duplicate is added
        - Not used as often as Lists in John's experience
        */

        // Example Set
//        Set<String> names = new HashSet<String>(); // Apparently you do not need to have HashSet<String> these days
        Set<String> namesHashSet = new HashSet<>(); // More recent way of instantiating an HashSet. AKA the "diamond" operator
        System.out.println(namesHashSet); // Output: []

        namesHashSet.clear();
        System.out.println(namesHashSet); // Output: []

        namesHashSet.add("Tohru");
        namesHashSet.add("Kyo");
        namesHashSet.add("Yuki");
        System.out.println(namesHashSet); // Output: [Kyo, Yuki, Tohru] // Seemingly guaranteed in this order, but not the order I added in

        Set<String> namesTreeSet = new TreeSet<>();
        namesTreeSet.add("Tohru");
        namesTreeSet.add("Kyo");
        namesTreeSet.add("Yuki");
        System.out.println(namesTreeSet); // Output: [Kyo, Tohru, Yuki ]

        /*
        Other HashSet methods of interest according to John
        - remove(Object value)

        Not sure why you'd need to do this, but to bounce back and forth between Array and HashSet
        - hashSetVariable.toArray() // Will return an array of Objects. Not sure how it deals with custom classes
        - hashSetVariable.toArray(new String[0]) // To coerce to an array of Strings
        - new HashSet<String>(Arrays.asList(arrayVariable)) // Returns a set that you can change
        */
    }
}
