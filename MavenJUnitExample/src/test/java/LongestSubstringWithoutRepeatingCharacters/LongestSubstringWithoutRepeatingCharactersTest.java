package LongestSubstringWithoutRepeatingCharacters;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestSubstringWithoutRepeatingCharactersTest {
    @Test
    void testAssertTrue() {
        LongestSubstringWithoutRepeatingCharacters solution = new LongestSubstringWithoutRepeatingCharacters();

        int result = solution.lengthOfLongestSubstring("pwwkew");

        assertEquals(3, result);
    }
}