package MinimumAbsoluteDifferenceInBST;

import Helpers.GenerateTreeNodesFromString;
import Helpers.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinimumAbsoluteDifferenceInBSTTest {
    @Test
    void testLeetCodeScenario() {
        MinimumAbsoluteDifferenceInBST solution = new MinimumAbsoluteDifferenceInBST();
        TreeNode root = GenerateTreeNodesFromString.fromIntegerArray(new Integer[]{979,3,2997,null,null,1254,null,null,2048});

        int result = solution.getMinimumDifference(root);

        assertEquals(275, result);
    }

    @Test
    void testPersonalScenarioBasedOffLeetCode() {
        MinimumAbsoluteDifferenceInBST solution = new MinimumAbsoluteDifferenceInBST();
        TreeNode root = GenerateTreeNodesFromString.fromIntegerArray(new Integer[]{979,3,2997,null,978,1254,null,null,2048});

        int result = solution.getMinimumDifference(root);

        assertEquals(1, result);
    }

    @Test
    void testAnotherLeetCodeScenario() {
        MinimumAbsoluteDifferenceInBST solution = new MinimumAbsoluteDifferenceInBST();
        TreeNode root = GenerateTreeNodesFromString.fromIntegerArray(new Integer[]{236,104,701,null,227,null,911});

        int result = solution.getMinimumDifference(root);

        assertEquals(9, result);
    }
}