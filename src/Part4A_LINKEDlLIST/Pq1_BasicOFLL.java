package Part4A_LINKEDlLIST;


class Node {
    int data;
    Node next;

    Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Pq1_BasicOFLL {
    private static Node convertArr2LL(int []arr){
        Node head = new Node(arr[0]);
        Node mover = head;

        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i]);
            mover.next = temp;
            mover = temp; //or mover.next
        }
        return head;
    }
    public static void main(String[] args) {
        int arr[] = {12, 5, 6, 8};
//        Node y = new Node(arr[3]);
//        System.out.println(y.data);

        Node head = convertArr2LL(arr);
        System.out.println(head.data);
    }
}
