package Part4A_LINKEDlLIST;

import java.util.HashSet;

public class Pq12_FindIntersectionPtOfYLL {
   static class Node {
        int num;
        Node next;
        Node(int val) {
            num = val;
            next = null;
        }
    }

    private static Node insertNode(Node head, int val){
       Node newNode = new Node(val);
       if (head ==null){
           head = newNode;
           return head;
       }
       Node temp = head;
       while (temp.next!= null){
           temp= temp.next;

       }
       temp.next = newNode;
       return head;
    }

    static void printList(Node head) {
        while(head.next != null) {
            System.out.print(head.num+"->");
            head = head.next;
        }
        System.out.println(head.num);
    }
    private static Node findIntersection(Node head1, Node head2){

       if (head1 ==null || head2 == null){
           return null;
       }
       Node temp1 = head1;
       Node temp2 = head2;

       while (temp1!= temp2){
           temp1 = temp1.next;
           temp2 = temp2.next;

           if (temp1 == temp2)return temp1;

           if (temp1==null) temp1 = head2;
           if (temp2==null) temp2 = head1;
       }
       return temp1;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> set = new HashSet<>();
        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            if (set.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;

    }

    public static void main(String[] args) {
        Node head = null;
        head=insertNode(head,1);
        head=insertNode(head,3);
        head=insertNode(head,1);
        head=insertNode(head,2);
        head=insertNode(head,4);
        Node head1 = head;
        head = head.next.next.next;
        Node headSec = null;
        headSec=insertNode(headSec,3);
        Node head2 = headSec;
        headSec.next = head;
        //printing of the lists
        System.out.print("List1: "); printList(head1);
        System.out.print("List2: "); printList(head2);
        //checking if intersection is present
        Node answerNode = findIntersection(head1,head2);
        if(answerNode == null)
            System.out.println("No intersection\n");
        else
            System.out.println("The intersection point is "+answerNode.num);

    }
}
