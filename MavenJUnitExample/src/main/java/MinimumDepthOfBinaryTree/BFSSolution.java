package MinimumDepthOfBinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class BFSSolution {
    // Trying the breadth first search now

    Queue<QueuedTreeNode> bfs = new LinkedList<>();

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        QueuedTreeNode qtn = new QueuedTreeNode(root, 1);
        bfs.add(qtn);

        while (bfs.size() > 0) {
            QueuedTreeNode current = bfs.poll();

            TreeNode left = current.getTreeNode().left;
            TreeNode right = current.getTreeNode().right;

            if (left == null && right == null) {
                return current.getDepth();
            }

            if (left != null) {
                QueuedTreeNode queuedLeft = new QueuedTreeNode(left, current.getDepth() + 1);
                bfs.add(queuedLeft);
            }

            if (right != null) {
                QueuedTreeNode queuedRight = new QueuedTreeNode(right, current.getDepth() + 1);
                bfs.add(queuedRight);
            }
        }

        return 0;
    }
}

class QueuedTreeNode {
    TreeNode treeNode;

    int depth;

    QueuedTreeNode(TreeNode treeNode, int depth) {
        this.treeNode = treeNode;
        this.depth = depth;
    }

    public TreeNode getTreeNode() {
        return treeNode;
    }

    public int getDepth() {
        return depth;
    }
}

