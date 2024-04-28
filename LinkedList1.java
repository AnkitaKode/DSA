class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList1 {
    private Node head;

    public LinkedList1() {
        this.head = null;
    }

    // Insert a new node at the front of the linked list
    public void insertAtFront(int newData) {
        Node newNode = new Node(newData);
        newNode.next = head;
        head = newNode;
    }

    // Remove the first node
    public void removeFirstNode() {
        if (head == null) {
            System.out.println("List is empty. No node to remove.");
            return;
        }
        head = head.next;
    }

    // Print the contents of the linked list
    public void printList() {
        Node current = head;
        System.out.print("Linked List: ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedList1 list = new LinkedList1(); // Corrected to use LinkedList1

        // Insert nodes at the front of the list
        list.insertAtFront(6);
        list.insertAtFront(5);
        list.insertAtFront(4);
        list.insertAtFront(3);
        list.insertAtFront(2);
        list.insertAtFront(1);

        list.printList();

        // Remove the first node
        list.removeFirstNode();
        System.out.println("After removing the first node:");
        list.printList();

        // Attempt to remove from an empty list
        LinkedList1 emptyList = new LinkedList1();
        emptyList.removeFirstNode(); // This will print a message indicating the list is empty
    }
}
