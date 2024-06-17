package Part4B_DoubleLinkedList;

import java.util.ArrayList;
import java.util.List;

public class Pq6_findPAirWithSum {

    public static class Node {
        // Data stored in the node
        public int data;

        public Node next;

        public Node back;

        // Constructor for a Node with both data,
        //a reference to the next node, and a
        //reference to the previous node
        public Node(int data1, Node next1, Node back1) {
            data = data1;
            next = next1;
            back = back1;
        }


        //Constructor for a Node with data,
        //and no references to the next and
        //previous nodes (end of the list)
        public Node(int data1) {
            data = data1;
            next = null;
            back = null;
        }
    }

    public static class Pair<K, V> {
        private final K key;
        private final V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }

    private static void print(Node head) {
        while (head != null) {
            // Print the data in the current node
            System.out.print(head.data + "->");
            // Move to the next node
            head = head.next;
        }
        System.out.println("null");
    }

    private static Node findTail(Node head) {
        Node tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        return tail;
    }

    private static List<Pair<Integer, Integer>> findPairSum(Node head, int k) {

        List<Pair<Integer, Integer>> ans = new ArrayList<>();
        Node left = head;

        Node right = findTail(head);
        if (head == null) {
            return ans;
        }
        while (left.data < right.data) {
            if (left.data + right.data == k) {
                ans.add(new Pair<>(left.data, right.data));
                left = left.next;
                right = right.back;
            } else if (left.data + right.data < k) {
                left = left.next;
            } else {
                right = right.back;
            }
        }
        return ans;

    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.back = head;

        head.next.next = new Node(3);
        head.next.next.back = head.next;

        head.next.next.next = new Node(4);
        head.next.next.next.back = head.next.next;

        head.next.next.next.next = new Node(9);
        head.next.next.next.next.back = head.next.next.next;

        List<Pair<Integer,Integer>> pair = findPairSum(head,5);
        for (Pair<Integer,Integer> p:pair){
            System.out.println("(" + p.getKey() + ", " + p.getValue() + ")");
//            System.out.println(p.getKey()+","+p.getValue());
        }

    }
}
