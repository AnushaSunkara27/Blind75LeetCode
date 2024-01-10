package Trees;

import java.util.LinkedList;
import java.util.Queue;

import javax.swing.tree.TreeNode;

public class BuildTree {

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

    static class BinaryTree {
        static int index = -1;
        public static Node buildTree(int[] nodes) {
            index++;
            
            if(nodes[index] == -1) {
                return null;
            }

            Node newNode = new Node(nodes[index]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }
    }

    public static void preorder(Node root) {
        if(root == null) {
            return;
        }

        System.out.println(root.data);
        preorder(root.left);
        preorder(root.right);
    }

    public static void inOrder(Node root) {
        if(root == null) {
            return;
        }

        inOrder(root.left);
        System.out.println(root.data);
        inOrder(root.right);
    }

    public static void postOrder(Node root) {
        if(root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.data);
    }

    public static void levelOrder(Node root) {
        Queue<Node> queue = new LinkedList<>();

        if(root == null) {
            return;
        }

        queue.add(root);
        queue.add(null);
        while(!queue.isEmpty()) {
            Node current  = queue.remove();
            if(current == null) {
                System.out.println();
                if(queue.isEmpty()) {
                    break;
                } else {
                    queue.add(null);
                }

            } else {
                System.out.println(current.data);
                if(current.left != null) {
                    queue.add(current.left);
                } 
                if(current.right != null) {
                    queue.add(current.right);
                }
            }
        }
    }

    public static int noofNodes(Node root) {
        if(root == null)
            return 0;
        int leftCount = noofNodes(root.left);
        int rightCount = noofNodes(root.right);
        return leftCount + rightCount + 1;
    }

    public static int sumOfNodes(Node root) {
        if(root == null) {
            return 0;
        }

        int leftsum = sumOfNodes(root.left);
        int rightSum = sumOfNodes(root.right);
        return leftsum+rightSum+root.data;
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

      
    
    public static void main(String[] args) {
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        // System.out.println(root.data);

        levelOrder(root);

        System.out.println(noofNodes(root));

        System.out.println(sumOfNodes(root));
    }
}
