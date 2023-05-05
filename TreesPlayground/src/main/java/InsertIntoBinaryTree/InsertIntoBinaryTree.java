package InsertIntoBinaryTree;

import Helpers.TreeNode;

public class InsertIntoBinaryTree {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        // For example, adding 5 to [4,2,7,1,3]
        // For example, adding 25 to [40,20,60,10,30,50,70]
        // For example, adding 5 to [4,2,7,1,3,null,null,null,null,null,null] (This is exactly the same scenario as the first though)

        _findTargetLeafNode(root, val);
        return root;
    }

    private void _findTargetLeafNode(TreeNode node, Integer val) {
        if (val < node.val && node.left == null) {
            node.left = new TreeNode(val);
            return;
        }

        if (val > node.val && node.right == null) {
            node.right = new TreeNode(val);
            return;
        }

        if (val < node.val) {
            _findTargetLeafNode(node.left, val);
        }

        if (val > node.val) {
            _findTargetLeafNode(node.right, val);
        }
    }
}
