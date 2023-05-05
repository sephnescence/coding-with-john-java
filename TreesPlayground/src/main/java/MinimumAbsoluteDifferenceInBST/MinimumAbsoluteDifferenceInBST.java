package MinimumAbsoluteDifferenceInBST;

import Helpers.TreeNode;

// This solution beats 19% in runtime and 46% in memory usage
// When submitting to leetcode, just be sure to rename this class to "Solution"
// I'm not naming it Solution because the test files begin to go crazy if there are multiple packages with classes called "Solution"
// Also, only copy from the next line down
public class MinimumAbsoluteDifferenceInBST {
    private int minimumDifference = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        // For example, given [979,3,2997,null,null,1254,null,null,2048]
        // the result in 275. abs(979 - 1254)
        // Somehow, however, I get 794 all the time, which is 1254-2048

        if (root == null) {
            return 0;
        }

        // Brute forcing should be relatively easy. Traverse the whole tree for every tree and see where the min difference is
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

        // Visit left
        _getMinimumDifference(root, node.left);

        // Visit right
        _getMinimumDifference(root, node.right);
    }
}
