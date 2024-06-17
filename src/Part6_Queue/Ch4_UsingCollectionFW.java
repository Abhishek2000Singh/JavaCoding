package Part6_Queue;

import java.util.*;

public class Ch4_UsingCollectionFW {
    public static void main(String[] args) {
        Queue<Integer> q =new LinkedList<>(); //Queue is interface not class And interface object cant be created it can only be implemented using ArrayDequeue and linked list
        // Queue<Integer> q =new ArrayDeque<>(); //difference based on cache
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        System.out.println(q.remove() + " is removed from the queue");// 5 is removed from the queue
        q.add(6);
        System.out.println(q.remove() + " is removed from the queue");//  6 is removed from the queue
        q.add(7);

        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }
    }
}

/*ArrayDeque vs LinkedList Implementation:
-In Deque a small number of insertions run in Θ(n) time by doubling the array capacity and copying elements over.
-Accesse time -dynamic arrays are usually faster than linked lists.
-Memory -  Linked list usually take O(n) total extra memory due to the storage of an extra pointer in each element.
-Worst CAselinked list versions have better worst-case behavior 


Conclusion: If per operation time is not important, Deque implementation is better */