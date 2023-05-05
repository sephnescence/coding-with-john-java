package InsertIntoBinaryTree;

import Helpers.GenerateTreeNodesFromString;
import Helpers.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InsertIntoBinaryTreeTest {
    @Test
    void testLeetcodeScenarioOne() {
        // [4,2,7,1,3]

        TreeNode root = GenerateTreeNodesFromString.fromIntegerArray(new Integer[]{4,2,7,1,3});
        assertTrue(root.isValidBST());

        InsertIntoBinaryTree solution = new InsertIntoBinaryTree();
        TreeNode newRoot = solution.insertIntoBST(root, 5);

        System.out.println(newRoot);
        assertTrue(newRoot.isValidBST());

        // Acceptable answer is [4,2,7,1,3,5,null]
        // Alternative acceptable answer is [5,2,7,1,3,null,null,null,null,null,4]
        //  ^ I think this is what Prime was referring to with re-balancing trees
        //  However, I don't think it's appropriate here because it's not balanced
    }

    @Test
    void testLeetcodeScenarioTwo() {
        // [40,20,60,10,30,50,70]

        TreeNode root = GenerateTreeNodesFromString.fromIntegerArray(new Integer[]{40,20,60,10,30,50,70});
        assertTrue(root.isValidBST());

        InsertIntoBinaryTree solution = new InsertIntoBinaryTree();
        TreeNode newRoot = solution.insertIntoBST(root, 25);

        System.out.println(newRoot);
        assertTrue(newRoot.isValidBST());

        // Acceptable answer is [40,20,60,10,30,50,70,null,null,25]
    }

    @Test
    void testLeetcodeScenarioThree() {
        // [4,2,7,1,3,null,null,null,null,null,null]
        // I wonder if this will work with my code lol

        TreeNode root = GenerateTreeNodesFromString.fromIntegerArray(new Integer[]{4,2,7,1,3,null,null,null,null,null,null});
        assertTrue(root.isValidBST());

        InsertIntoBinaryTree solution = new InsertIntoBinaryTree();
        TreeNode newRoot = solution.insertIntoBST(root, 5);

        System.out.println(newRoot);
        assertTrue(newRoot.isValidBST());

        // Acceptable answer is [4,2,7,1,3,5,null]
    }

    @Test
    void testLeetcodeScenarioFour() {
        // []

        TreeNode root = GenerateTreeNodesFromString.fromIntegerArray(new Integer[]{});
        assertNull(root);

        InsertIntoBinaryTree solution = new InsertIntoBinaryTree();
        TreeNode newRoot = solution.insertIntoBST(null, 5);

        System.out.println(newRoot);
        assertTrue(newRoot.isValidBST());
    }
}