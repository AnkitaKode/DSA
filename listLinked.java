class LinkedList {
    Node head;

    // Node class
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Insert at Beginning
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    // Insert at End
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }

        curr.next = newNode;
    }

    // Insert at Position (1-based index)
    public void insertAtPosition(int data, int position) {

        if (position == 1) {
            insertAtBeginning(data);
            return;
        }

        Node newNode = new Node(data);
        Node curr = head;

        for (int i = 1; i < position - 1 && curr != null; i++) {
            curr = curr.next;
        }

        if (curr == null) {
            System.out.println("Position out of range");
            return;
        }
        // this is the only line that is different from insertAtEnd, we are inserting
        // the new node in between two nodes, so we need to update the next pointer of
        // the new node to point to the next node of the current node, and then update
        // the next pointer of the current node to point to the new node.
        newNode.next = curr.next;
        curr.next = newNode;
    }

    // Delete Beginning
    public void deleteAtBeginning() {
        if (head == null)
            return;
        head = head.next;
    }

    // Delete End
    public void deleteAtEnd() {

        if (head == null)
            return;

        if (head.next == null) {
            head = null;
            return;
        }

        Node curr = head;

        while (curr.next.next != null) {
            curr = curr.next;
        }

        curr.next = null;
    }

    // Delete at Position
    public void deleteAtPosition(int position) {

        if (head == null)
            return;

        if (position == 1) {
            head = head.next;
            return;
        }

        Node curr = head;

        for (int i = 1; i < position - 1 && curr != null; i++) {
            curr = curr.next;
        }

        if (curr == null || curr.next == null)
            return;

        curr.next = curr.next.next;
    }

    // Search Element
    public boolean search(int key) {

        Node curr = head;

        while (curr != null) {
            if (curr.data == key)
                return true;
            curr = curr.next;
        }

        return false;
    }

    // Display List
    public void display() {

        Node curr = head;

        while (curr != null) {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }

        System.out.println("null");
    }
}

public class listLinked {

    public static void main(String[] args) {

        LinkedList list = new LinkedList();

        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);
        list.display();

        list.insertAtBeginning(5);
        list.display();

        list.insertAtPosition(15, 3);
        list.display();

        list.deleteAtBeginning();
        list.display();

        list.deleteAtEnd();
        list.display();

        list.deleteAtPosition(2);
        list.display();

        System.out.println("Search 20: " + list.search(20));
        System.out.println("Search 50: " + list.search(50));
    }
}
