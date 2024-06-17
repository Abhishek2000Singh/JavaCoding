package Part4A_LINKEDlLIST;

public class Pq5_Add2Numbers {
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

    private static Node add2Num(Node l1, Node l2) {
        Node dummyHead = new Node(-1);
        Node temp = dummyHead;
        int carry = 0;

        while (l1 != null || l2 != null || carry!=0) {
            int sum = 0;
            if (l1 != null) {
                sum = sum + l1.data;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum = sum + l2.data;
                l2 = l2.next;
            }

            sum = sum+carry;
            carry = sum/10;
            Node node = new Node(sum%10);
            temp.next = node;
            temp = temp.next;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        int arr1[] = {12, 5, 6, 8};
        Node l1= convertArr2LL(arr1);
        int arr2[] = {2, 7, 1, 4};
        Node l2 =convertArr2LL(arr2);

        Node head = add2Num(l1,l2);
        printList(head);




    }
}
