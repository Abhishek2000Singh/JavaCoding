package Part4B_DoubleLinkedList;



public class Pq1_BasicOfDLL {

   static class Node {
        int data;
        Node next;
        Node back;

        Node(int data, Node next, Node back) {
            this.data = data;
            this.next = next;
            this.back = back;
        }

        Node(int data){
            this.data = data;
            this.next = null;
            this.back = null;
        }
    }

    private static Node convert2Dll(int []arr){
        Node head = new Node(arr[0]);
        Node prev = head;
        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i], null,prev);
            prev.next = temp;
            prev = temp;
        }
        return head;
    }

    public static void printDList(Node head){
        Node temp = head;
        if (head == null) {
            System.out.println("list is empty");
        }
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null"); // To indicate the end of the list
    }
    public static void main(String[] args) {
        int arr[] = {12, 5, 8, 7};
        Node head = convert2Dll(arr);
       printDList(head);
    }
}
