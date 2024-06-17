package Part8_BinarySearchTree;

public class Ch1_BST {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    public static Node insert(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }

        if (root.data > val) {
            // left subtree
            root.left = insert(root.left, val);
        } else if (root.data < val) {
            // right subtree
            root.right = insert(root.right, val);
        }
        return root;

    }

    // for inorder traversal

    public static void inorder(Node root) {

        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    // Search a bst
    public static boolean search(Node root, int key) {

        if (root==null) {
            return false;
        }
       if (root.data>key) { //left subtree
        return search(root.left, key);
       }
       else if (root.data==key) {
        return true;
       }
       else{
        return search(root.right, key); //right subtree
       }
    }

    public static void main(String[] args) {
        int values[] = { 5, 1, 3, 4, 2, 7 };

        Node root = null;
        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }

        inorder(root);
        System.out.println();

        if (search(root, 8)) {
            System.out.println("Found");
        }
        else{
            System.out.println("Not  Found");
        }
    }
}
