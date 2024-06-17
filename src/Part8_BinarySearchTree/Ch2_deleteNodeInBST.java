package Part8_BinarySearchTree;

public class Ch2_deleteNodeInBST {
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

    // deleting the node

    public static Node delete(Node root, int val) {
        if (root.data > val) {
            root.left = delete(root.left, val);
        } 
        else if (root.data < val) {
            root.right = delete(root.right, val);
        } 
        else // root.data == val
        { // case1
            if (root.left == null && root.right == null) {
                return null; // no child
            }

            // case2
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } 

            // case 3
            Node IS = inOrderSuccesor(root.right);
            root.data = IS.data;
            root.right = delete(root.right, IS.data);
        }
        return root;
       }
    

    public static Node inOrderSuccesor(Node root) {

        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public static void main(String[] args) {
        int values[] = { 5, 1, 3, 4, 2, 7 };

        Node root = null;
        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }

        inorder(root);
        System.out.println();

        delete(root, 4);
        inorder(root);
    }
}
