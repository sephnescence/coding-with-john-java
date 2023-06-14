package LongestSubstringWithoutRepeatingCharacters;

import java.util.LinkedList;

// This got 84%|79% - O(2n), which is fine, really
public class LongestSubstringWithoutRepeatingCharacters {
    int longestSubstring = 0;
    LinkedList<Character> fifo = new LinkedList<>();

    public int lengthOfLongestSubstring(String s) {
        // Make a reference to the longest substring. Start it at 0
        // Make a reference to the current string of text it's looking at. Likely a linkedlist or queue (fifo)
        // if s is of length 0 then return 0
        // for each character in s
        //  if the character is in the fifo queue
        //      remove characters from the start of the queue and decrement the longest subtring count by 1 until
        //      the character that was collided with is removed
        // add the character to the end of the queue

        char[] sChars = s.toCharArray();
        for (char sChar : sChars) {
            if (fifo.contains(sChar)) {
                while (fifo.removeFirst() != sChar && !fifo.isEmpty()) continue;
//                Character lastRemoved = fifo.removeFirst();
//                while (lastRemoved != sChar && !fifo.isEmpty()) {
//                    lastRemoved = fifo.removeFirst();
//                }
            }

            fifo.addLast(sChar);
            longestSubstring = Math.max(longestSubstring, fifo.size());
        }

        return longestSubstring;
    }
}
