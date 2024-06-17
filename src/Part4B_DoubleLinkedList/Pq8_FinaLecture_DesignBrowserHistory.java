package Part4B_DoubleLinkedList;

public class Pq8_FinaLecture_DesignBrowserHistory {
    public static class Node {
        // Data stored in the node
        public String data;
        public Node next;
        public Node back;

        public Node(String data1, Node next1, Node back1) {
            data = data1;
            next = next1;
            back = back1;
        }

        public Node(String data1) {
            data = data1;
            next = null;
            back = null;
        }
    }

    static class Browser{
        Node currentPage;
        public Browser(String homepage){
            currentPage = new Node(homepage);
        }

        void visit(String url){
            Node newNode = new Node(url);
            currentPage.next = newNode;
            newNode.back = currentPage;
            currentPage = newNode;
        }

        String back(int steps){
            while (steps>0){
                if (currentPage.back!= null){
                    currentPage = currentPage.back;
                }else{
                    break;
                }
            }
            return currentPage.data;
        }
        String forward(int steps){
            while (steps>0){
                if (currentPage.next!= null){
                    currentPage = currentPage.next;
                }
                else{
                    break;
                }
                steps--;
            }
            return currentPage.data;
        }
    }
    public static void main(String[] args) {
        Browser browser = new Browser("homepage.com");

        // Visit a few websites
        browser.visit("google.com");
        browser.visit("facebook.com");
        browser.visit("youtube.com");
        browser.visit("instagram.com");
        browser.visit("twitter.com");
        browser.visit("github.com");



        // Go back twice
        System.out.println("Moving back :"+browser.back(2)); // Expected: google.com

        // Go forward once
        System.out.println("Moving forward :"+browser.forward(1)); // Expected: facebook.com

        // Visit a new website
        browser.visit("linkedin.com");

        // Try to go forward (should not move because we're at the latest page)
        System.out.println("Moving forward :"+browser.forward(1)); // Expected: linkedin.com

        // Go back three times
        System.out.println("Moving back :"+browser.back(3)); // Expected: homepage.com
    }
}
