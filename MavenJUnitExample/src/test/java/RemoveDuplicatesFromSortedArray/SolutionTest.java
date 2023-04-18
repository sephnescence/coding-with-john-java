package RemoveDuplicatesFromSortedArray;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class SolutionTest {
    @Test
    void testRemoveDuplicatesFromSortedArray() {
        Solution solution = new Solution();
        int[] nums = {1, 1, 2};
        int[] expectedNums = {1, 2};

        assertTrue(Arrays.equals(expectedNums, solution.removeDuplicatesFromSortedArray(nums)));
    }

    @Test
    void testRemoveDuplicatesFromSortedArray2() {
        Solution solution = new Solution();

        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int[] expectedNums = {0, 1, 2, 3, 4};

        assertTrue(Arrays.equals(expectedNums, solution.removeDuplicatesFromSortedArray(nums)));
    }
}
