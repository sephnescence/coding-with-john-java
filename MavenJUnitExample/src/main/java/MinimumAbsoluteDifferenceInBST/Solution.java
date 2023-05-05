package MinimumAbsoluteDifferenceInBST;

class Solution {
    int minDifference = Integer.MAX_VALUE; // This is really the only reliable way of making sure the first match is counted correctly

    public int getMinimumDifference(TreeNode root) {
        // This puzzle says "Absolute difference" directly, but this has been mentioned by other ways
        //  For example, either a or b when comparing the two nodes

        // This was also posed as a challenge when dealing with a standard DFS problem
        //  so there must be a clue as to BST posing a difference... Not sure what, though
        // Perhaps when calculating the difference, the left gets subtracted from the node value
        //  and the node value gets subtracted from the right

        if (root == null) {
            return 0;
        }

        _getMinimumDifference(root);

        return minDifference;
    }

    private void _getMinimumDifference(TreeNode node) {
        if (node == null) {
            return;
        }

        int knownMin = node.val;
        int knownMax = node.val;

        if (node.left != null) {
            knownMax = Math.max(
                    node.left.val,
                    _getMaximumChildValue(node.left, node.left.val)
            );

            System.out.println("Known Max (Left) - " + knownMax);
            minDifference = Math.min(minDifference, Math.abs(node.val - knownMax));
            System.out.println("Min Difference (Left) - " + minDifference);

            _getMinimumDifference(node.left);
        }

        if (node.right != null) {
            knownMin = Math.min(
                    node.right.val,
                    _getMinimumChildValue(node.right, node.right.val)
            );

            System.out.println("Known Min (Right) - " + knownMin);
            minDifference = Math.min(minDifference, Math.abs(knownMin - node.val));
            System.out.println("Min Difference (Right) - " + minDifference);

            _getMinimumDifference(node.right);
        }
    }

    private int _getMinimumChildValue(TreeNode node, int knownMin) {
        if (node.left == null && node.right == null) {
            return Math.min(knownMin, node.val);
        }

        if (node.left != null) {
            int left = _getMinimumChildValue(node.left, knownMin);
            knownMin = Math.min(knownMin, left);
        }

        if (node.right != null) {
            int right = _getMinimumChildValue(node.right, knownMin);
            knownMin = Math.min(knownMin, right);
        }

        return knownMin;
    }

    private int _getMaximumChildValue(TreeNode node, int knownMax) {
        if (node.left == null && node.right == null) {
            return Math.max(knownMax, node.val);
        }

        if (node.left != null) {
            int left = _getMaximumChildValue(node.left, knownMax);
            knownMax = Math.max(knownMax, left);
        }

        if (node.right != null) {
            int right = _getMaximumChildValue(node.right, knownMax);
            knownMax = Math.max(knownMax, right);
        }

        return knownMax;
    }
}
