package data_structures.assigment_problems;

// Doubly linked list browser history with visit, back, and forward navigation.
public class BrowserHistory {

    private static class Node {
        String url;
        Node prev, next;
        Node(String url) { this.url = url; }
    }

    private Node current;

    public BrowserHistory(String homepage) {
        current = new Node(homepage);
    }

    public void visit(String url) {
        Node node = new Node(url);
        node.prev    = current;
        current.next = node;
        current      = node;
    }

    public String back(int steps) {
        while (steps-- > 0 && current.prev != null) {
            current = current.prev;
        }
        return current.url;
    }

    public String forward(int steps) {
        while (steps-- > 0 && current.next != null) {
            current = current.next;
        }
        return current.url;
    }
}
