package Part4A_LINKEDlLIST;

public class Pq6_OddEvenList {
      static class Node {
      int val;
      Node next;
      Node() {}
      Node(int val) { this.val = val; }
      Node(int val, Node next) { this.val = val; this.next = next; }
  }
  
  private static Node oddEvenList(Node head){
          if (head == null || head.next==null){
              return head;
          }

          Node even = head.next;
          Node odd = head;
          Node evenHead = even;
          Node oddHead = odd;

          while (even!= null && even.next != null){
              odd.next = even.next;
              odd = odd.next;
              even.next = odd.next;
              even = even.next;
          }
          odd.next = evenHead;
          return oddHead;
  }
    public static void main(String[] args) {

    }
}
