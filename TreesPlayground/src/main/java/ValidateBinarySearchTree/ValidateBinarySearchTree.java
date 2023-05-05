package ValidateBinarySearchTree;

import Helpers.TreeNode;

// Beats 6%|88%
// Probably low because I feel like the the stack is big
public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return false;
        }
        // Inorder Traversal seems good to me?
        // Make a note of the root's value and whether it's supposed to be less than or greater than?
        return _isValidBST(root);
    }

    private boolean _isValidBST(TreeNode node) {
        if (node.left != null) {
            if (!_isValidBSTLeft(node.left, node) || !_isValidBST(node.left)) {
                return false;
            }
        }

        if (node.right != null) {
            return _isValidBSTRight(node.right, node) && _isValidBST(node.right);
        }

        return true;
    }

    private boolean _isValidBSTLeft(TreeNode node, TreeNode root) {
        // I don't think the order really matters here
        // Recurse left
        // Visit Node
        // Recurse Right

        if (node.left != null && !_isValidBSTLeft(node.left, root)) {
            return false;
        }
        if (node.val >= root.val) {
            return false;
        }
        return node.right == null || _isValidBSTLeft(node.right, root);
    }

    private boolean _isValidBSTRight(TreeNode node, TreeNode root) {
        // I don't think the order really matters here
        // Recurse left
        // Visit Node
        // Recurse Right

        if (node.left != null && !_isValidBSTRight(node.left, root)) {
            return false;
        }
        if (node.val <= root.val) {
            return false;
        }
        return node.right == null || _isValidBSTRight(node.right, root);
    }
}
