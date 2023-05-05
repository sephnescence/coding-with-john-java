package ValidateBinarySearchTree;

import Helpers.TreeNode;

// Beats 100%|28%
// In order approach as advised by the editorial
public class ValidateBinarySearchTree {
    private Integer prev;
    public boolean isValidBST(TreeNode root) {
        prev = null;
        return _isValidBST(root);
    }

    private boolean _isValidBST(TreeNode node) {
        if (node == null) return true;
        if (
            !_isValidBST(node.left)
            || (prev != null && node.val <= prev)
        ) return false;
        prev = node.val;
        return _isValidBST(node.right);
    }
}
