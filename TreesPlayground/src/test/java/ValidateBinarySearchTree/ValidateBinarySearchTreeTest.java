package ValidateBinarySearchTree;

import Helpers.GenerateTreeNodesFromString;
import Helpers.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidateBinarySearchTreeTest {
    @Test
    void testLeetcodeScenarioOne() {
        // [2,1,3]

        TreeNode root = GenerateTreeNodesFromString.fromIntegerArray(new Integer[]{2, 1, 3});
        ValidateBinarySearchTree solution = new ValidateBinarySearchTree();

        assertTrue(solution.isValidBST(root));
    }

    @Test
    void testLeetcodeScenarioTwo() {
        // [5,1,4,null,null,3,6]

        TreeNode root = GenerateTreeNodesFromString.fromIntegerArray(new Integer[]{5,1,4,null,null,3,6});
        ValidateBinarySearchTree solution = new ValidateBinarySearchTree();

        assertFalse(solution.isValidBST(root));
    }
}