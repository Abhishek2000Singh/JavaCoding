package Part7_BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class Ch4_CountNSumOfNodes {
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


    public static int countOfNodes(Node root) {
      if (root==null) {
        return 0;
      }

      int leftNodes = countOfNodes(root.left);
      int rightNodes = countOfNodes(root.right);
      return leftNodes+rightNodes+1;
    }


    public static int sumOfNodes(Node root) {
        if (root == null) {
            return 0;
        }
        int leftSum = sumOfNodes(root.left);
        int rightSum = sumOfNodes(root.right);

        return leftSum + rightSum + root.data;
    }

    public static void main(String[] args) {
        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        BinaryTree tree = new BinaryTree();

        Node Root = tree.buildTree(nodes);
        System.out.println(countOfNodes(Root)); // 6
        System.out.println(sumOfNodes(Root)); // 21
    }
}
