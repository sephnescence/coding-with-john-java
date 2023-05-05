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

    @Test
    void testPersonalScenario() {
        // Ok so strictly speaking this isn't valid. Confirmed
        // Borrowing from MinimumAbsoluteDifferenceInBSTTest
        // [979,3,2997,null,978,1254,null,null,2048]

        TreeNode root = GenerateTreeNodesFromString.fromIntegerArray(new Integer[]{979,3,2997,null,978,1254,null,null,2048});
        ValidateBinarySearchTree solution = new ValidateBinarySearchTree();

        assertFalse(solution.isValidBST(root));
    }

    @Test
    void testPersonalScenarioBasedOnLeetcode() {
        // Borrowing from MinimumAbsoluteDifferenceInBSTTest
        // [979,3,2997,null,null,1254,null,null,2048]

        TreeNode root = GenerateTreeNodesFromString.fromIntegerArray(new Integer[]{979,3,2997,null,null,1254,null,null,2048});
        ValidateBinarySearchTree solution = new ValidateBinarySearchTree();

        assertTrue(solution.isValidBST(root));
    }

    @Test
    void testLeetcodeScenarioThree() {
        // Borrowing from MinimumAbsoluteDifferenceInBSTTest
        // [2,2,2]

        TreeNode root = GenerateTreeNodesFromString.fromIntegerArray(new Integer[]{2,2,2});
        ValidateBinarySearchTree solution = new ValidateBinarySearchTree();

        assertFalse(solution.isValidBST(root));
    }
}