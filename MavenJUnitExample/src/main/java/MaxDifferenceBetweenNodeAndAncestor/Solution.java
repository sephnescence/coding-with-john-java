package MaxDifferenceBetweenNodeAndAncestor;


class Solution { // Editorial 1
    // record the required maximum difference
    int result = 0;

    public int maxAncestorDiff(TreeNode root) {
        if (root == null) {
            return 0;
        }
        result = 0;
        helper(root, root.val, root.val);
        return result;
    }

    void helper(TreeNode node, int curMax, int curMin) {
        if (node == null) {
            return;
        }
        // update `result`
        int possibleResult = Math.max(Math.abs(curMax - node.val), Math.abs(curMin - node.val));
        result = Math.max(result, possibleResult);
        // update the max and min
        curMax = Math.max(curMax, node.val);
        curMin = Math.min(curMin, node.val);
        helper(node.left, curMax, curMin);
        helper(node.right, curMax, curMin);
        return;
    }
}
//
//class Solution {
//    int maxDiff = -1;
//
//    public int maxAncestorDiff(TreeNode root) {
//        if (root == null || (root.left == null && root.right == null)) {
//            return 0; // In either case there's no number to compare to, and x-x=0
//        }
//
//        _maxAncestorDiff(root);
//
//        return maxDiff;
//    }
//
//    public void _maxAncestorDiff(TreeNode node) {
//        if (node == null) {
//            return;
//        }
//
//        traverseChildren(node, node.val);
//
//        _maxAncestorDiff(node.left);
//        _maxAncestorDiff(node.right);
//    }
//
//    private void traverseChildren(TreeNode node, int ancestorValue) {
//        if (node == null) {
//            return;
//        }
//
//        maxDiff = Math.max(maxDiff, ancestorValue - node.val);
//        maxDiff = Math.max(maxDiff, node.val - ancestorValue);
//
//        traverseChildren(node.left, ancestorValue);
//        traverseChildren(node.right, ancestorValue);
//    }
//}