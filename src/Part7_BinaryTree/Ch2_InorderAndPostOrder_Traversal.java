package Part7_BinaryTree;

public class Ch2_InorderAndPostOrder_Traversal {
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
        static int idx = -1;
        public static Node buildTree(int nodes[]) {

            idx++;
            if (nodes[idx] == -1) {
                return null;
            }

            Node newnNode = new Node(nodes[idx]);
            newnNode.left = buildTree(nodes);
            newnNode.right = buildTree(nodes);

            return newnNode;
        }

    }
    public static void inorder(Node  root) {
        if (root == null) {
            // System.out.print("-1 "); // Print -1 if root is null
            return ;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }

    public static void postorder(Node  root) {
        if (root == null) {
            // System.out.print("-1 "); // Print -1 if root is null
            return ;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data+" ");
    }

    public static void main(String[] args) {
        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        BinaryTree tree = new BinaryTree();

        Node Root = tree.buildTree(nodes);
        System.out.println(Root.data + ""); // Output:  1
        inorder(Root);
        System.out.println();
        postorder(Root);
    }
}
