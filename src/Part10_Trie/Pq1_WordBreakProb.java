package Part10_Trie;

public class Pq1_WordBreakProb {
    static class Node{
        Node [] children;
        boolean eow;//endOfWords;

        public Node(){
            children = new Node[26]; //a to z
            for (int i = 0; i < 26; i++) {
                children[i]= null; //bcz we created a node and tried to create object of different  nodes of array inside it. So,here we created object which will occupy some space so here we initialised with null as we dont know the memory size
            }
            eow = false;
        }
    }

    static Node root = new Node(); //root of trie

    //Inserting 
    public static void insert(String word){

        Node curr = root; //since root is static var and changing it will leads to permanent change

        for (int i = 0; i < word.length(); i++) { //O(L)
            int idx = word.charAt(i)-'a';
            if (curr.children[idx] == null) {
                //adding new node
                curr.children[idx] = new Node();
            }

            if (i== word.length()-1) {
                curr.children[idx].eow = true;
            }
            //updating the root
            curr = curr.children[idx];
        }
    }
 
    public static boolean  search(String key){
        
        Node curr = root;
        for (int i = 0; i < key.length(); i++) {
            int idx  = key.charAt(i)-'a';
            Node node = curr.children[idx];

            if (node==null) {
                return false;
            }
            if (i==key.length()-1 && node.eow==false) {
                return false;
            }
            curr = curr.children[idx];

        }
        
        return true;
    }


    public static boolean wordbreak(String key){
        if (key.length()==0) {
            return true;
        }
        for (int i = 1; i <= key.length(); i++) {
            String firstPart = key.substring(0, i);
            String secPart = key.substring( i);
            if (search(firstPart)&& wordbreak(secPart)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String words[] = {"i", "like", "sam", "samsung", "mobile"};
        // String key = "ilikesamsung";
        String key = "ilikesamsun";

        for (int i = 0; i < words.length; i++) {
            insert(words[i]);
        }

        System.out.println(wordbreak(key));
    }
}
