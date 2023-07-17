
import java.util.*;
class Trie_1 {
    static class Node {
        Node children[] = new Node[26]; // Create an Node array  of size 26 .
        boolean endOfWord = false; //End of Word is by default set false.

       public Node() { //Constroctor
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }
    }

    public static Node root = new Node(); //Set root as new empty node.
    
    public static void insert(String word) {
        Node curr = root;

        for (int level = 0; level < word.length(); level++) {
            int idx = word.charAt(level) - 'a'; ////// Find the index of Character inside the array.

            // agar Node nehi hai ta node create karlo
            if (curr.children[idx] == null) { // If root of children is null.than
                curr.children[idx] = new Node(); // Create a new Node().
            }
            /// agar root ki children Node hai ta children node ko root banalo.
            curr = curr.children[idx];
        }

        //Every Node main jo End of Word false the by default usko agar word khatam hota hai tha End of Word ko true kar denge.
        curr.endOfWord = true;

    }
     

    // /////Search

    public static boolean search(String key) {
        Node curr = root;

        for (int level = 0; level < key.length(); level++) {
            int idx = key.charAt(level) - 'a';

            if (curr.children[idx] == null) { //if character index is not present in root children then we simpley return false.
                return false;
            }

            /// if not null then we update the  children index as root.
            curr = curr.children[idx];
        }

        return curr.endOfWord == true;
    }
    


    // /////   Word Break Problem   ////////
    public static boolean wordBreak(String key) {

        // Check if the input string is empty, then return true
        if (key.length() == 0) {
            return true;
        }
    
        // Loop through the input string starting from the first character
        for (int i = 1; i <= key.length(); i++) {
    
            // Check if the substring from 0 to i is present in the trie and if the rest of the string can be broken down into words
            if (search(key.substring(0, i)) && wordBreak(key.substring(i))) {
                return true;
            }
        }
    
        // If the string cannot be broken down into words, return false
        return false;
    }
    
    
    public static void main(String[] args) {
        // String words[] = { "the", "a", "there", "their", "any", "three" };
        String arr[] = { "i", "like", "sam", "samsung", "mobile", "ice" };

        String key = "ilikesamsung";
      for(int i = 0 ;i< arr.length;i++){
        insert(arr[i]);
      }
  
    //   System.out.println(search("the"));
    //   System.out.print(search("thea"));
    System.out.println(wordBreak(key));
      
    }
  }
