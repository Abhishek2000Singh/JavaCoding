package Part9_Hashing;

import java.util.ArrayList;
import java.util.LinkedList;

public class Ch3_HashMap2Code {

    static class HashMap<K, V> { //generics
        private class Node {
            K key;
            V value;

            public Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        private int n; // no. of node
        private int N; // No. of bucket or buckets.length
        private LinkedList<Node> buckets[]; // similar as intialising of array like int arr[] ..here inplace of arr we use bucket[] and for datatype we use linkedlist<Node> instead of int

        @SuppressWarnings("unchecked")
        public HashMap() {
            this.N = 4;
            this.buckets = new LinkedList[4];

            for (int i = 0; i < 4; i++) {
                this.buckets[i] = new LinkedList<>();
            }
        }

        private int hashFunction(K key) {
            int bi = key.hashCode(); // it can return any + or - value but we need positive value bi should lie between 0 to N-1

            return Math.abs(bi) % N; // make it positive
        }

        private int searchinLL(K key, int bi) {
            LinkedList<Node> ll = buckets[bi];
            for (int i = 0; i < ll.size(); i++) {
                if (ll.get(i).key == key) { // ll.get(i) will return node and node.key will be matched with key
                    return i; // di = i
                }
            }
            return -1; // value doesnt
        }

        private void rehash() {
            LinkedList<Node>[] oldBuckets = buckets;
            buckets = new LinkedList[N * 2];

            // creating empty linkedlist
            for (int i = 0; i < N * 2; i++) {
                buckets[i] = new LinkedList<>();
            }

            // picking value of old index to the new bucket
            for (int i = 0; i < oldBuckets.length; i++) {
                LinkedList<Node> ll = oldBuckets[i]; // every bucket index will store the linked list
                for (int j = 0; j < ll.size(); j++) {
                    Node node = ll.get(j); // pick all nodes from each linklist
                    put(node.key, node.value); // then put the key value
                }
            }
        }

        public void put(K key, V value) {
            int bi = hashFunction(key);
            int di = searchinLL(key, bi); // return data index if val = 0+ data exist
            if (di == -1) { // key doesn't exist
                buckets[bi].add(new Node(key, value));
                n++; // value of n is increased
            } else {
                Node node = buckets[bi].get(di);
                node.value = value;
            }

            double lambda = (double) n / N;
            if (lambda > 2.0) { // that is K=2.0
                // rehashing
                rehash();
            }
        }

        public boolean containsKey(K key) {
            int bi = hashFunction(key);
            int di = searchinLL(key, bi);
            if (di == -1) { // key doesn't exist
                return false;
            } else {
               return true;
            }
        }

        public V remove(K  key) {
            int bi = hashFunction(key);
            int di = searchinLL(key, bi); // return data index if val = 0+ data exist
            if (di == -1) { // key doesn't exist
                return null;
            } else {
                Node node = buckets[bi].remove(di);
                n--;
                return node.value;
            }

        }

        public V get(K key) {
            int bi = hashFunction(key);
            int di = searchinLL(key, bi); // return data index if val = 0+ data exist
            if (di == -1) { // key doesn't exist
                return null;
            } else {
                Node node = buckets[bi].get(di);
                return node.value;
            }

        }

        public ArrayList<K> keySet(){
            ArrayList<K> keys = new ArrayList<>();

            for (int i = 0; i < buckets.length; i++) { //bi =i
                LinkedList<Node> ll = buckets[i];
                for (int j = 0; j < ll.size(); j++) {
                    Node node = ll.get(j);
                    keys.add(node.key);
                }
            }
            return keys;
        }

        public boolean isEmpty(){
            return n==0;
        }

    }

    public static void main(String[] args) {
        // we are not using the inbuilt java coll framework here we are using the class we created above and its method
         

        HashMap<String, Integer> map = new HashMap<>();
        map.put("India", 190);
        map.put("China", 200);
        map.put("US", 50);

        ArrayList<String> keys = map.keySet();

        for (int i = 0; i < keys.size(); i++) {
            System.out.println(keys.get(i)+" "+map.get(keys.get(i)));
        }
        
        System.out.println(map.get("India"));
        map.remove("India");
        System.out.println(map.get("India"));
    }

}
