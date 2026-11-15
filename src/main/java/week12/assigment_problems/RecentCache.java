package week12.assigment_problems;

import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

// Stores pages in least-recently-used eviction order.
public class RecentCache {
    private final int capacity;
    private final Map<Integer, Node> nodes = new HashMap<>();
    private final Node head = new Node(0, "");
    private final Node tail = new Node(0, "");
    private Integer lastEvictedKey;
    private boolean lastPutUpdated;

    public RecentCache(int capacity) {
        if (capacity < 1 || capacity > 10000) {
            throw new IllegalArgumentException("Capacity must be between 1 and 10000");
        }
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public String get(int key) {
        Node node = nodes.get(key);
        if (node == null) {
            return "-1";
        }
        remove(node);
        insertFirst(node);
        return node.page;
    }

    public void put(int key, String page) {
        if (page == null) {
            throw new IllegalArgumentException("Page cannot be null");
        }
        lastEvictedKey = null;
        Node node = nodes.get(key);
        lastPutUpdated = node != null;
        if (node != null) {
            node.page = page;
            remove(node);
        } else {
            if (nodes.size() == capacity) {
                Node evicted = tail.prev;
                remove(evicted);
                nodes.remove(evicted.key);
                lastEvictedKey = evicted.key;
            }
            node = new Node(key, page);
            nodes.put(key, node);
        }
        insertFirst(node);
    }

    public Integer getLastEvictedKey() {
        return lastEvictedKey;
    }

    public boolean wasLastPutUpdated() {
        return lastPutUpdated;
    }

    public String describe() {
        StringJoiner result = new StringJoiner(", ");
        for (Node node = head.next; node != tail; node = node.next) {
            result.add(node.key + "=" + node.page);
        }
        return result.toString();
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insertFirst(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    // Links one cached page to its recency neighbors.
    private static class Node {
        private final int key;
        private String page;
        private Node prev;
        private Node next;

        Node(int key, String page) {
            this.key = key;
            this.page = page;
        }
    }
}
