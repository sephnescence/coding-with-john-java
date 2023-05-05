package MinimumAbsoluteDifferenceInBST;

import Helpers.TreeNode;

// Borrowing the editorial approach which beats 100%|92%
// I see. This approach relies on hitting nulls, and has a reference to the previous node so that it can check the previous node instead of checking if it's a leaf node byt checking either side
public class MinimumAbsoluteDifferenceInBST {
    int minDifference = Integer.MAX_VALUE;
    // Initially, it will be null.
    TreeNode prevNode;

    void inorderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }

        inorderTraversal(node.left);
        // Find the difference with the previous value if it is there.
        if (prevNode != null) {
            // minDifference = Math.min(minDifference, node.val - prevNode.val); // Interesting to note there's no abs here...
            // This means my personal scenario hits a negative and wins cos it's the smallest
            minDifference = Math.min(minDifference, Math.abs(node.val - prevNode.val)); // But then we're back to the 275 issue
            // I see. It can't see the 978 because it can only look left, despite 978 being in a valid location
            // I wonder if there's just an issue with the test data on leetcode?
        }
        prevNode = node;
        inorderTraversal(node.right);
    }

    int getMinimumDifference(TreeNode root) {
        inorderTraversal(root);
        return minDifference;
    }
}
