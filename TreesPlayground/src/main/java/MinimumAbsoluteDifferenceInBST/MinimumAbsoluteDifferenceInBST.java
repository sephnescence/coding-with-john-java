package MinimumAbsoluteDifferenceInBST;

import Helpers.TreeNode;

// This solution beats 58% in runtime and 37% in memory usage
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
        _getMinimumDifference(node, node.left);
        _getMinimumDifference(node, node.right);

        // Visit left
        _dfsTraverseTree(node.left);

        // Visit right
        _dfsTraverseTree(node.right);
    }

    private void _getMinimumDifference(TreeNode root, TreeNode node) {
        if (node == null) {
            return;
        }

        // Visit self
        minimumDifference = Math.min(minimumDifference, Math.abs(root.val - node.val));

        // for example, 236 is the root, and the left side's value is 104, and has a child on the right with a value of 227
        // 104 might have moved the difference, but literally any other value on the right will tighten the gap, so maybe keep going right
        // Likewise, when on the right, keep going left

        // I think this behaviour flips depending on the side you're on
        if (node.val >= root.val) { // i.e. on the right
            // Visit left conditionally
            _getMinimumDifference(root, node.left);
        } else { // i.e. on the left
            // Visit right conditionally
            _getMinimumDifference(root, node.right);
        }
    }
}
