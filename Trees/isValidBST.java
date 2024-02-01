package Trees;

public class isValidBST {

    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public boolean isValidBinaryST(TreeNode root) {
        return isValidBinaryST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBinaryST(TreeNode root, long minValue, long maxValue) {
        if (root == null) {
            return true;
        }

        long value = root.val;

        if (value <= minValue || value >= maxValue) {
            return false;
        }

        return isValidBinaryST(root.left, minValue, value) && isValidBinaryST(root.right, value, maxValue);
    }
}
