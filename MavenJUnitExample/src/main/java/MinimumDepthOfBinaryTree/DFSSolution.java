package MinimumDepthOfBinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class DFSSolution {
    // Assuming depth first search. LOL I was coding thing like a breadth first search. Yikes
    // Doing it with a queue presents its own challenges in that you need to figure out a way to store the depth

    int intMinDepth = Integer.MAX_VALUE;

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        _minDepth(root, 1);

        return intMinDepth;
    }

    public void _minDepth(TreeNode node, int currentDepth) {
        if (node.left == null && node.right == null) {
            intMinDepth = Math.min(intMinDepth, currentDepth);
        }

        if (node.left != null) {
            _minDepth(node.left, currentDepth + 1);
        }

        if (node.right != null) {
            _minDepth(node.right, currentDepth + 1);
        }
    }
}
