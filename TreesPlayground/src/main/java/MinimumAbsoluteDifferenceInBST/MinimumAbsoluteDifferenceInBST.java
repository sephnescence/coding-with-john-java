package MinimumAbsoluteDifferenceInBST;

import Helpers.TreeNode;

// This solution also beats 59% in runtime and 89% in memory usage (Though memory usage swings a lot apparently, but the highest I've seen was 98% so that is technically the best so far)
// When submitting to leetcode, just be sure to rename this class to "Solution"
// I'm not naming it Solution because the test files begin to go crazy if there are multiple packages with classes called "Solution"
// Also, only copy from the next line down
public class MinimumAbsoluteDifferenceInBST {
    private int minimumDifference = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        // I have two tests running across this now...
        // One - [979,3,2997,null,null,1254,null,null,2048] - the result in 275. abs(979 - 1254)
        // Two - [979,3,2997,null,978,1254,null,null,2048] - the result in 1. abs(979 - 978)
        // Three - [236,104,701,null,227,null,911] - the result is 9. abs(236, 227)

        if (root == null) {
            return 0;
        }

        // So how do we leverage the fact that this is a BST...?
        // I think all we can do is not traverse left the value of the node didn't move the minimum difference?
        _dfsTraverseTree(root);

        return minimumDifference;
    }

    private void _dfsTraverseTree(TreeNode node) {
        if (node == null) {
            return;
        }

        // Visit self
        // Improving again, you just want the highest value from the left, and the lowest value from the right
        // You only need to check the minimum difference after each of these return
        if (node.left != null) {
            int highestLeft = _getMaximumDifferenceRight(node.left);
            minimumDifference = Math.min(minimumDifference, Math.abs(node.val - highestLeft));
            _dfsTraverseTree(node.left);
        }

        if (node.right != null) {
            int lowestRight = _getMinimumDifferenceLeft(node.right);
            minimumDifference = Math.min(minimumDifference, Math.abs(node.val - lowestRight));
            _dfsTraverseTree(node.right);
        }
    }

    private int _getMinimumDifferenceLeft(TreeNode node) {
        if (node.left == null) {
            return node.val;
        }

        // Keep visiting left
        return _getMinimumDifferenceLeft(node.left);
    }

    private int _getMaximumDifferenceRight(TreeNode node) {
        if (node.right == null) {
            return node.val;
        }

        // Keep visiting right
        return _getMaximumDifferenceRight(node.right);
    }
}
