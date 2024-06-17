package Part4A_LINKEDlLIST;

public class Pq3_deletionInsertion {
    static Node head;

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private static Node convertArr2LL(int[] arr) {
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

    public static void printList(Node head) {
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

    private static Node removeHead(Node head) {
        if (head == null) {
            return head;
        }
//        Node temp = head;
        head = head.next;
        return head;
    }

    private static Node lastRemove(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
        return head;
    }

    private static Node removeK(Node head, int k) {
        if (head == null|| head.next==null) {
            return head;
        }

        if (k==1){
            head = head.next;
            return head;
        }
        Node temp = head;
        Node prev = null;
        int cnt = 0;
        while (temp != null) {
            cnt++;
            if (cnt == k) {
                prev.next = prev.next.next;
                break;
            }
            prev = temp ;
            temp = temp.next;
        }

        return head;
    }

    private static Node removeEle(Node head, int el) {
        if (head == null|| head.next==null) {
            return head;
        }

        if (head.data==el){
            head = head.next;
            return head;
        }
        Node temp = head;
        Node prev = null;

        while (temp != null) {

            if (temp.data == el) {
                prev.next = prev.next.next;
                break;
            }
            prev = temp ;
            temp = temp.next;
        }

        return head;
    }

    public static void main(String[] args) {
        int arr[] = {12, 5, 6, 8};

        Node head = convertArr2LL(arr);
//        head = removeHead(head);
//        head = lastRemove(head);
//        head = removeK(head,1);
//        head = removeEle(head,6);
        head = removeEle(head,16);
        printList(head);
    }
}
