package Part4A_LINKEDlLIST;

class ListNode{

    int data;
    ListNode next;

    ListNode(int data){
        this.data = data;
        this.next = null;
    }
    ListNode(int data, ListNode next){
        this.data = data;
        this.next = next;
    }
}
public class Pq4_InsertionOfEle {

    static ListNode addFirst(ListNode head,int data){
        ListNode newListNode = new ListNode(data);
        if (head == null) {
            head = newListNode;
            return head;
        }
        newListNode.next = head;
        head = newListNode;
        return head;
    }

    static ListNode addLast(ListNode head, int data){
        ListNode newListNode = new ListNode(data);

        if (head==null){
            head = newListNode;
            return head;
        }
        ListNode temp = head;
        while (temp.next!=null){
            temp = temp.next;
        }
        temp.next = newListNode;
        return  head;
    }

    public static ListNode insertK(ListNode head, int data, int k) {
        // Case 1: If the list is empty
        if (head == null) {
            if (k == 1) {
                return new ListNode(data); // Insert at the first position in an empty list
            } else {
                return head; // k is invalid, return the unchanged list
            }
        }

        // Case 2: Insert at the head (position 1)
        if (k == 1) {
            return new ListNode( data,head); // New ListNode becomes the new head
        }

        // Traverse the list to find the (k-1)th ListNode
        ListNode temp = head;
        int cnt = 1;
        while (temp != null ) {
            cnt++;
            if(cnt==k){
                ListNode newListNode = new ListNode(data);
                newListNode.next = temp.next;
                temp.next = newListNode;
                break;
            }
            temp = temp.next;

        }
        return head;
    }

    public static ListNode insertBeforeValue(ListNode head, int data, int val) {
        // Case 1: If the list is empty
        if (head == null) {
            return null;
        }

        // Case 2: Insert at the head (position 1)
        if (head.data == val) {
            return new ListNode(data); // New ListNode becomes the new head
        }

        // Traverse the list to find the (k-1)th ListNode
        ListNode temp = head;

        while (temp.next != null ) {
            if(temp.next.data==val){
                ListNode newListNode = new ListNode(data,temp.next);
//                ListNode newListNode = new ListNode(data);
//                newListNode.next = temp.next;
                temp.next = newListNode;
                break;
            }
            temp = temp.next;

        }
        return head;
    }



    public static void printList(ListNode head) {
        ListNode temp = head;
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
    public static void main(String[] args) {
ListNode head = null;
head = addFirst(head,30);
head = addFirst(head,40);
head = addFirst(head,50);
head = addFirst(head,60);
head = addLast(head,70);
//head = insertK(head,100,3);
head = insertBeforeValue(head,100,70);
printList(head);
    }
}
