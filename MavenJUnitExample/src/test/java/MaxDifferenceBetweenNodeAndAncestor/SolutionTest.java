package MaxDifferenceBetweenNodeAndAncestor;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    @Test
    void testScenarioOne() {
//        [8,3,10,1,6,null,14,null,null,4,7,13]

        TreeNode nodeTwelve = new TreeNode(13, null, null);
        TreeNode nodeEleven = new TreeNode(7, null, null);
        TreeNode nodeTen = new TreeNode(4, null, null);
        TreeNode nodeNine = null;
        TreeNode nodeEight = null;
        TreeNode nodeSeven = new TreeNode(14, nodeTwelve, null);
        TreeNode nodeSix = null;
        TreeNode nodeFive = new TreeNode(6, nodeTen, nodeEleven);
        TreeNode nodeFour = new TreeNode(1, nodeEight, nodeNine);
        TreeNode nodeThree = new TreeNode(10, nodeSix, nodeSeven);
        TreeNode nodeTwo = new TreeNode(3, nodeFour, nodeFive);
        TreeNode nodeOne = new TreeNode(8, nodeTwo, nodeThree);

        Solution solution = new Solution();
        int result = solution.maxAncestorDiff(nodeOne);

        assertEquals(7, result);
    }

    @Test
    void testScenarioTwo() {
//        [1,null,2,null,0,3]

        TreeNode nodeSix = new TreeNode(3, null, null);
        TreeNode nodeFive = new TreeNode(0, nodeSix, null);
        TreeNode nodeFour = null;
        TreeNode nodeThree = new TreeNode(2, nodeFour, nodeFive);
        TreeNode nodeTwo = null;
        TreeNode nodeOne = new TreeNode(1, nodeTwo, nodeThree);

        Solution solution = new Solution();
        int result = solution.maxAncestorDiff(nodeOne);
//        int result = solution.maxAncestorDiff(nodeFive);

        assertEquals(3, result);

//        ArrayDe
    }
}