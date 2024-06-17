package Part7_BinaryTree;

public class Ch7_SubtreeOfTree {
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
        static int idx = -1;;

        public static Node buildTree(int nodes[]) {
            idx++;
            if (idx >= nodes.length || nodes[idx] == -1) {
                return null;
            }

            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }

    }

    public boolean isIdentical(Node root, Node subRoot) {
        if (root == null && subRoot == null) {
            return true;
        }
        if (root == null || subRoot == null) {
            return false;
        }
     
        if (root.data == subRoot.data) {
            return isIdentical(root.left, subRoot.left) && isIdentical(root.right, subRoot.right);
        }

        return false;
       
    }

    public boolean isSubTree(Node root, Node subRoot) {

        if (subRoot == null) {
            return true;
        }

        if (root == null) {
            return false;
        }
        /*
         * Check if the tree with root as root has a node that can be the root of
         * the tree with root as subRoot
         */
        if (root.data == subRoot.data) {
            if (isIdentical(root, subRoot)) {
                return true;
            }
        }
        return isSubTree(root.left, subRoot) || isSubTree(root.right, subRoot);
    }

    public static void main(String[] args) {
        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        int subNode[] = { 2, 4, -1, -1, 5, -1, -1 };
        BinaryTree tree = new BinaryTree();
        
        Node root = tree.buildTree(nodes);
        Node subRoot = tree.buildTree(subNode);

        Ch7_SubtreeOfTree solution = new Ch7_SubtreeOfTree();
        boolean isSubtree = solution.isSubTree(root, subRoot);

        if (isSubtree) {
            System.out.println("The second tree is a subtree of the first tree.");
        } else {
            System.out.println("The second tree is not a subtree of the first tree.");
        }
    }
}
