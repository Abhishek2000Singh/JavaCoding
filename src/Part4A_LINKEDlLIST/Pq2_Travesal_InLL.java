package Part4A_LINKEDlLIST;

public class Pq2_Travesal_InLL {
    Node head;

    class Node {
        int data;
        Node next;

//        Node(int data, Node next) {
//            this.data = data;
//            this.next = next;
//        }

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node convertArr2LL(int[] arr) {
        if (arr.length == 0) {
            head = null;

        }
        head = new Node(arr[0]);
        Node mover = head;

        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i]);
            mover.next = temp;
            mover = temp; //or mover.next
        }
return head;
    }

    public void printList() {
        Node temp = head;
        if (head == null) {
            System.out.println("list is empty");
            return;
        }
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null"); // To indicate the end of the list
    }

    private static int LengthOfLL(Node head){
        int cnt = 0;
        Node temp = head;
        while (temp!=null){
            temp = temp.next;
            cnt++;
        }
        return cnt;
    }

    public static int checkIfpresent(Node head, int val){
        Node temp = head;
        while (temp!= null){
            if (temp.data==val){
                return 1;
            }
            temp = temp.next;
        }
        return 0;
    }

    public static void main(String[] args) {
        int arr[] = {12, 5, 6, 8};
//        Node y = new Node(arr[3]);
//        System.out.println(y.data);

        Pq2_Travesal_InLL list = new Pq2_Travesal_InLL();
        list.convertArr2LL(arr);
        list.printList();
        System.out.println(LengthOfLL(list.head));
        System.out.println(checkIfpresent(list.head, 5));
    }
}
