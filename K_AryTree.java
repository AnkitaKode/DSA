public class K_AryTree {

    static class Node {
        Node[] children;
        boolean isEnd;

        public Node() {
            children = new Node[26];
            isEnd = false;
        }
    }

    static Node root = new Node();

    // INSERT
    public static void insert(String word) {
        Node curr = root; 

        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';

            if (curr.children[index] == null) {
                curr.children[index] = new Node();
            }

            curr = curr.children[index];
        }

        curr.isEnd = true;  
    }

    // SEARCH
    public static boolean search(String key) {
        Node curr = root; 

        for (int i = 0; i < key.length(); i++) {
            int index = key.charAt(i) - 'a';

            if (curr.children[index] == null) {
                return false;
            }

            curr = curr.children[index];
        }

        return curr.isEnd;
    }

    public static void main(String[] args) {
        String[] words = { "hello", "world", "hi", "her", "hero" };

        for (String word : words) {
            insert(word);
        }

        System.out.println(search("hero"));   // true
        System.out.println(search("her"));    // true
        System.out.println(search("hiii"));   // false
        System.out.println(search("he"));     // false
    }
}
