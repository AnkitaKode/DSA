class Node {
    int key;
    Node left, right;

    public Node(int item) {
        key = item;
        left = right = null;
    }
}

public class Tree {
    Node root;

    public Tree() {
        root = null;
    }

    // Method to insert a new node
    public void insert(int key) {
        root = insertRec(root, key);
    }

    private Node insertRec(Node root, int key) {
        // If the tree is empty, return a new node
        if (root == null) {
            root = new Node(key);
            return root;
        }

        /* Otherwise, recur down the tree */
        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);

        return root;
    }

    // Method to search for a key
    public boolean search(int key) {
        return searchRec(root, key);
    }

    // A recursive function to search for a key in BST
    private boolean searchRec(Node root, int key) {
        if (root == null)
            return false;

        if (root.key == key)
            return true;

        if (key < root.key)
            return searchRec(root.left, key);
        else
            return searchRec(root.right, key);
    }

    // To print the tree inorder
    public void inorder() {
        inorderRec(root);
    }

    private void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }

    public static void main(String[] args) {
        Tree tree = new Tree();

        tree.insert(8);
        tree.insert(4);
        tree.insert(2);

        System.out.print("Inorder traversal: ");
        tree.inorder();

        int searchKey = 4;
        if (tree.search(searchKey))
            System.out.println("\nKey " + searchKey + " found in the tree.");
        else
            System.out.println("\nKey " + searchKey + " not found in the tree.");
    }
}
