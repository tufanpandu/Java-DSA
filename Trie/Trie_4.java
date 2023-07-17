public class Trie_4 {

    ///////////    Find Prifix Problem   /////////////////

    static class Node {
        Node children[] = new Node[26];
        boolean eow = false;
        int freq;

        public Node() {
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
            freq = 1;
        }
    }

    public static Node root = new Node();

    public static void insert(String word) {
        Node curr = root;

        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';

            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }else{
                curr.children[idx].freq++;
            }
            curr = curr.children[idx];
        }

        curr.eow = true;
    }


    public static void findPrefix(Node root, String ans) {
        if (root.children == null) {//The current node has no children so finding prefix is not have any mening
            return; // So we return and end the recursion.
        }

        if (root.freq == 1) {// If root node have frequency 1 then it have the unique prefix and we print the  prefix and return.
            System.out.print(ans);
            return;
        }
        for (int i = 0; i < root.children.length; i++) { // Iterate over the current root children node .
            if (root.children[i] != null) {
                // Recursively call the function for each non-null children node.
                 //  // appending the character corresponding to the child index (i + 'a') to the prefix.
              findPrefix(root.children[i], ans + (char)(i + 'a'));
            }
        }
    }
    public static void main(String[] args) {
        String arr[] = { "zebra", "dog", "duck", "dove" };

        for (int i = 0; i < arr.length; i++) {
            insert(arr[i]);
        }
        root.freq = -1;

      findPrefix(root, " ,");


    }
}
