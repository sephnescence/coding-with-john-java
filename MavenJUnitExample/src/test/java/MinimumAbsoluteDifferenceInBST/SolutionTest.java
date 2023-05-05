package MinimumAbsoluteDifferenceInBST;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    @Test
    void testScenarioOne() {
//        [979,3,2997,null,null,1254,null,null,2048]

        TreeNode nodeNine = new TreeNode(2048, null, null);
        TreeNode nodeEight = null;
        TreeNode nodeSeven = null;
        TreeNode nodeSix = new TreeNode(1254, nodeEight, nodeNine);
        TreeNode nodeFive = null;
        TreeNode nodeFour = null;
        TreeNode nodeThree = new TreeNode(2997, nodeSix, nodeSeven);
        TreeNode nodeTwo = new TreeNode(3, nodeFour, nodeFive);
        TreeNode nodeOne = new TreeNode(979, nodeTwo, nodeThree);

        Solution solution = new Solution();
        int result = solution.getMinimumDifference(nodeOne);

        assertEquals(9, result);
    }
}