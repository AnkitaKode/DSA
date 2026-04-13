import java.util.*;

// Class representing the LRU Cache
class LRUCacheDLL {
    // Doubly linked list node class
    class Node {
        int key;
        int val;
        Node next;
        Node prev;
        // Constructor to initialize node
        Node(int _key, int _val) {
            key = _key;
            val = _val;
        }
    }

    // Head and tail dummy nodes
    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);

    // Capacity of cache
    int cap;
    // Hash map to store key-node mapping
    HashMap<Integer, Node> m = new HashMap<>();

    // Constructor to initialize LRU cache
    public LRUCacheDLL(int capacity) {
        cap = capacity;
        head.next = tail;
        tail.prev = head;
    }

    // Function to add a node right after head
    void addNode(Node newNode) {
        Node temp = head.next;
        newNode.next = temp;
        newNode.prev = head;
        head.next = newNode;
        temp.prev = newNode;
    }

    // Function to remove a given node from list
    void deleteNode(Node delNode) {
        Node delPrev = delNode.prev;
        Node delNext = delNode.next;
        delPrev.next = delNext;
        delNext.prev = delPrev;
    }

    // Function to get value from cache
    public int get(int key_) {
        // If key exists in cache
        if (m.containsKey(key_)) {
            Node resNode = m.get(key_);
            int res = resNode.val;
            // Remove old mapping
            m.remove(key_);
            // Move accessed node to front
            deleteNode(resNode);
            addNode(resNode);
            // Update map
            m.put(key_, head.next);
            return res;
        }
        // If not found
        return -1;
    }

    // Function to put key-value into cache
    public void put(int key_, int value) {
        // If key already exists
        if (m.containsKey(key_)) {
            Node existingNode = m.get(key_);
            m.remove(key_);
            deleteNode(existingNode);
        }
        // If capacity reached
        if (m.size() == cap) {
            m.remove(tail.prev.key);
            deleteNode(tail.prev);
        }
        // Insert new node at front
        addNode(new Node(key_, value));
        m.put(key_, head.next);
    }
}


public class Main {
    public static void main(String[] args) {
        // Create cache with capacity 2
        LRUCacheDLL cache = new LRUCacheDLL(2);

        // Put values in cache
        cache.put(1, 1);
        cache.put(2, 2);

        // Get value for key 1
        System.out.println(cache.get(1));

        // Insert another key (evicts key 2)
        cache.put(3, 3);

        // Key 2 should be evicted
        System.out.println(cache.get(2));

        // Insert another key (evicts key 1)
        cache.put(4, 4);

        // Key 1 should be evicted
        System.out.println(cache.get(1));

        // Key 3 should be present
        System.out.println(cache.get(3));

        // Key 4 should be present
        System.out.println(cache.get(4));
    }
}
