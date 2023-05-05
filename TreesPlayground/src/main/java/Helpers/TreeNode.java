package Helpers;

import java.util.LinkedList;

public class TreeNode {
    public TreeNode left;
    public TreeNode right;
    public Integer val; // This is where my implementation of TreeNode differs from leetcode. I use a nullable value here to print null when toString is called

    public TreeNode() {}
    public TreeNode(Integer val) {
        this.val = val;
    }

    // To avoid making tree nodes in reverse order like I have been in tests, I'll leave out the constructor
    // that specifies the left and right nodes so I'm forced to use GenerateTreeNodesFromString::fromIntegerArray

    @Override
    public String toString() {
        // I'm not sure what happens if you call toString on a null
        // We essentially just perform a depth first search across all nodes

        LinkedList<TreeNode> workingNodes = new LinkedList<>();

        StringBuilder output = new StringBuilder("[" + this.val);

        if (this.left != null) {
            workingNodes.addLast(this.left);
        }

        if (this.right != null) {
            workingNodes.addLast(this.right);
        }

        while (!workingNodes.isEmpty()) {
            TreeNode current = workingNodes.removeFirst();

            output.append(", ");

            if (current.val == null) {
                output.append("null");
                continue;
            }

            output.append(current.val); // For some reason my IDE preferred this over +=
            if (current.left == null && current.right == null) {
                if (!workingNodes.isEmpty()) {
                    workingNodes.addLast(new TreeNode());
                    workingNodes.addLast(new TreeNode());
                }
                continue;
            }

            if (current.left == null) { // IDE notes a Objects.requireNonNullElseGet
                workingNodes.addLast(new TreeNode());
            } else {
                workingNodes.addLast(current.left);
            }

            if (current.right == null) { // IDE notes a Objects.requireNonNullElseGet
                workingNodes.addLast(new TreeNode());
            } else {
                workingNodes.addLast(current.right);
            }
        }
        return output + "]";
    }

    public boolean isValidBST() {
        LinkedList<Integer> unfoldedBST = new LinkedList<>();
        _unfoldBST(this, unfoldedBST);

        if (unfoldedBST.isEmpty()) {
            return true;
        }

        Integer prev = unfoldedBST.removeFirst();
        while (!unfoldedBST.isEmpty()) {
            Integer nextInt = unfoldedBST.removeFirst();
            if (nextInt == null) {
                continue;
            }
            if (nextInt <= prev) {
                return false;
            }
            prev = nextInt;
        }

        return true;
    }

    private void _unfoldBST(TreeNode node, LinkedList<Integer> unfoldedBST) {
        if (node == null) {
            return;
        }

        _unfoldBST(node.left, unfoldedBST);
        unfoldedBST.addLast(node.val);
        _unfoldBST(node.right, unfoldedBST);
    }
}
