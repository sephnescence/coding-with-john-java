package MinimumDepthOfBinaryTree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinimumDepthOfBinaryTreeTest {
    @Test
    void testItWorks() {
        TreeNode nodeFive = new TreeNode(5, null, null);
        TreeNode nodeFour = new TreeNode(4, null, null);
        TreeNode nodeThree = new TreeNode(3, null, null);
        TreeNode nodeTwo = new TreeNode(2, nodeFour, nodeFive);
        TreeNode nodeOne = new TreeNode(1, nodeTwo, nodeThree);

        DFSSolution dfsSolution = new DFSSolution();

        int minDepth = dfsSolution.minDepth(nodeOne);
        assertEquals(2, minDepth);

        BFSSolution bfsSolution = new BFSSolution();

        minDepth = bfsSolution.minDepth(nodeOne);
        assertEquals(2, minDepth);
    }

    @Test
    void testItWorks2() {
//        [2,null,3,null,4,null,5,null,6]

        TreeNode nodeFive = new TreeNode(6, null, null);
        TreeNode nodeFour = new TreeNode(5, null, nodeFive);
        TreeNode nodeThree = new TreeNode(4, null, nodeFour);
        TreeNode nodeTwo = new TreeNode(3, null, nodeThree);
        TreeNode nodeOne = new TreeNode(2, null, nodeTwo);

        DFSSolution dfsSolution = new DFSSolution();

        int minDepth = dfsSolution.minDepth(nodeOne);
        assertEquals(5, minDepth);

        BFSSolution bfsSolution = new BFSSolution();

        minDepth = bfsSolution.minDepth(nodeOne);
        assertEquals(5, minDepth);
    }
}