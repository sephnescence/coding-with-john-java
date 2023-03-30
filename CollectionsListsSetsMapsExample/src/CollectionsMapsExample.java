import java.util.*;

public class CollectionsMapsExample {
    public static void main(String[] args) {
        /*
        The advantage of Collections is that they don't need to have their lengths defined ahead of time
        John refers to them as "size flexible"

        There are differences between the three. Check the other two files

        Maps
        - An interface, so cannot be instantiated directly, but there are classes we can use, such as
            - HashMap
            - TreeMap
            - LinkedHashMap
        - Have no order (though LinkedHashMap if FIFO. TreeMap has a "natural" order. They do sacrifice some performance)
        - Cannot contain duplicate KEYS, but won't raise an exception if a duplicate is added. Instead, it will replace the old value
        - It CAN contain duplicate VALUES, so long as the key is different
        - Keys cannot be primitives
        */

        // Example Map
//        Map<Integer, String> namesHashMap = new HashMap<Integer, String>(); // Apparently you do not need to have HashSet<String> these days
        Map<String, FruitsBasketCharacter> furubaHashMap = new HashMap<>(); // More recent way of instantiating an HashSet. AKA the "diamond" operator
        System.out.println(furubaHashMap); // Output: {} // Note that it's not [] like the others

        furubaHashMap.clear();
        System.out.println(furubaHashMap); // Output: {}}

        furubaHashMap.put("Tohru", new FruitsBasketCharacter("Tohru", null));
        furubaHashMap.put("Kyo", new FruitsBasketCharacter("Kyo", "Cat"));
        furubaHashMap.put("Yuki", new FruitsBasketCharacter("Yuki", "Rat"));
        System.out.println(furubaHashMap); // Output: {Kyo=Cat, Yuki=Rat, Tohru=null} // Note I've got to toString method returning their zodiac animal

        // BTTODO - TreeMap example
        // BTTODO - LinkedHashMap example
        /*
        Other HashMap methods of interest according to John
        - containsValue(Object value)
        - containsKey(Object key)
        - replace(Object key, Object value) // Will only put the item into the map if it's actually replacing what's at the desired key
        - putIfAbsent(Object key, Object value) // As advertised
        - remove(Object key) // Removes what's at the desired key
        - remove(Object key, Object value) // Removes the desired value IF it's at the desired key
        - get(Object key) // will return what's at the desired key, or null
        - keySet() // Get all the keys in the map

        Other notes
        - null is a valid entry to put into a map
        */
    }
}

class FruitsBasketCharacter {
    public String name;
    public String zodiacAnimal;
    public FruitsBasketCharacter(
            String name,
            String zodiacAnimal
    ) {
        this.name = name;
        this.zodiacAnimal = zodiacAnimal;
    }

    public String toString() {
        return zodiacAnimal;
    }
}