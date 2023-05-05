package Helpers;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GenerateTreeNodesFromStringTest {
    @Test
    void testTrue() {
        assertTrue(true);
    }

    @Test
    void testSingleNode() {
        // [1]
        TreeNode root = GenerateTreeNodesFromString.fromIntegerArray(new Integer[]{1});
        assertNotNull(root);
        assertEquals(1, root.val);
    }

    @Test
    void testHeightOfTwo() {
        // [1, 2, 3]
        TreeNode root = GenerateTreeNodesFromString.fromIntegerArray(new Integer[]{1, 2, 3});
        assertNotNull(root);
        assertEquals(1, root.val);
        assertNotNull(root.left);
        assertEquals(2, root.left.val);
        assertNotNull(root.right);
        assertEquals(3, root.right.val);
    }

    @Test
    void testLeetCodeTreeNode() {
        // [979,3,2997,null,null,1254,null,null,2048]
        TreeNode root = GenerateTreeNodesFromString.fromIntegerArray(new Integer[]{979, 3, 2997, null, null, 1254, null, null, 2048});
        assertNotNull(root);
        assertEquals(979, root.val);

        assertNotNull(root.left);
        assertEquals(3, root.left.val);
        assertNull(root.left.left);
        assertNull(root.left.right);

        assertNotNull(root.right);
        assertEquals(2997, root.right.val);
        assertNotNull(root.right.left);
        assertEquals(1254, root.right.left.val);
        assertNull(root.right.right);

        assertNull(root.right.left.left);
        assertNotNull(root.right.left.right);
        assertEquals(2048, root.right.left.right.val);

        String rootToString = root.toString();
        assertEquals("Hello", rootToString);
    }
}