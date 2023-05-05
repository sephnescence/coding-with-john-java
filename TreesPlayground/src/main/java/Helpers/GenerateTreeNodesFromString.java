package Helpers;

import java.util.LinkedList;

public class GenerateTreeNodesFromString {
    static LinkedList<TreeNode> nodes = new LinkedList<>();
    static LinkedList<TreeNode> workingNodes = new LinkedList<>();
    static TreeNode root = null;
    public static TreeNode fromIntegerArray(Integer[] arr) {
        // This is a static method so these must be reset
        nodes = new LinkedList<>();
        workingNodes = new LinkedList<>();
        root = null; // Will return the root for an older executions if not nulled here

        /*
        e.g. given an input like [1,2,3,null,null], return a binary tree

        The algorithm goes like this
        - BTTODO
         */
        for (Integer val : arr) {
            TreeNode node = null;
            if (val != null) {
                node = new TreeNode(val);
            }
            if (root == null) {
                root = node;
                workingNodes.addLast(node);
            } else {
                nodes.addLast(node);
            }
        }

        while (!workingNodes.isEmpty()) {
            TreeNode current = workingNodes.removeFirst();

            if (!nodes.isEmpty()) {
                TreeNode left = nodes.removeFirst();
                if (left != null) {
                    current.left = left;
                    workingNodes.addLast(left);
                }
            }

            if (!nodes.isEmpty()) {
                TreeNode right = nodes.removeFirst();
                if (right != null) {
                    current.right = right;
                    workingNodes.addLast(right);
                }
            }
        }

        return root;
    }
}
