package MinimumAbsoluteDifferenceInBST;

import Helpers.GenerateTreeNodesFromString;
import Helpers.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinimumAbsoluteDifferenceInBSTTest {
    @Test
    void testTrue() {
        assertTrue(true);
        MinimumAbsoluteDifferenceInBST solution = new MinimumAbsoluteDifferenceInBST();
        TreeNode root = GenerateTreeNodesFromString.fromIntegerArray(new Integer[]{979,3,2997,null,null,1254,null,null,2048});

        int result = solution.getMinimumDifference(root);

        assertEquals(275, result);
    }
}