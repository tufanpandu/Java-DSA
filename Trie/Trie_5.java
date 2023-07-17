public class Trie_5 {

    ///// Start with problem  //////
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

        for (int i = 0; i < word.length(); i++) { /// Iterate the character of each word.
            int idx = word.charAt(i) - 'a'; //Find the word charcter index .

            if (curr.children[idx] == null) { //Check if the current node child have charcter index or not .
                curr.children[idx] = new Node(); // If not then create new Node .

            }

            curr = curr.children[idx]; // If yes then update the current node child as current node. 
        }
        curr.eow = true;
    }
   
    public static boolean startWith(String prefix) { //This function is little bit similar with search functions.
        Node curr = root;

        for (int i = 0; i < prefix.length(); i++) { //Iterate the whole prefix length.
            int idx = prefix.charAt(i) - 'a'; // fint the char index.
            if (curr.children[idx] == null) { // if current node child index is null then return false because they don't have characters.
                return false;
            }
            curr = curr.children[idx]; //If yes then update the current node child as current node. 

        }
        return true; // if all preifx char is present in the trie then return true.
  }
 

    public static void main(String[] args) {
        String words[] = { "apple", "app", "mango", "man", "woman" };
        String prefix1 = "app";
        String prefix2 = "moon";
        
        for (int i = 0; i < words.length; i++) {
            insert(words[i]);
        }
       
      System.out.println(startWith(prefix2));

    }
}
