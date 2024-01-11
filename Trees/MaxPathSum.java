package Trees;

public class MaxPathSum {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public int maxSumPath(Node root) {
        int[] maxSum = new int[1];
        maxSum[0] = Integer.MIN_VALUE;
        maxDepthSum(root, maxSum);
        return maxSum[0];
    }

    public int maxDepthSum(Node root, int[] maxSum) {
        if(root == null) {
            return 0;
        }

        int leftSum = Math.max(0, maxDepthSum(root.left, maxSum));
        int rightSum = Math.max(0, maxDepthSum(root.right, maxSum));
        maxSum[0] = Math.max(maxSum[0], leftSum+rightSum+root.data);

        return Math.max(leftSum, rightSum) + root.data;
    }
}
