package Trees;

public class HeightOfBinaryTree {

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

    public int maxDepth(Node root) {

        if(root == null) {
            return 0;
        }
        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);

        int height = Math.max(leftHeight, rightHeight) + 1;

        return height;
    }
}
