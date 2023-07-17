import java.util.*;

class Trie_3 {

  // Defining a static class Node to represent each node of the Trie data structure
  static class Node{
    Node children[] = new Node[26]; // An array of 26 children nodes to represent each letter of the English alphabet
    boolean eow = false; // A flag to indicate if the node represents the end of a word
    int freq; // A frequency counter to keep track of how many times a word is inserted into the trie

    // Constructor to initialize each node with null children nodes and a frequency of 1
    public Node(){
      for(int i =0 ;i< 26;i++){
        children[i] = null;
      }
      freq = 1;
    }
  }

  // Initializing the root node of the Trie data structure
  public static Node root  = new Node();

  // Function to insert a word into the Trie
  public static void insert(String word){
    Node curr = root; // Start at the root node
    for(int i = 0 ;i< word.length();i++){ // Loop through each letter in the word
      int idx = word.charAt(i) - 'a'; // Get the index of the current letter in the children array of the current node
      if(curr.children[idx] == null){ // If there is no child node for the current letter, create a new node for it
        curr.children[idx] = new Node();
      }else{ // If there is already a child node for the current letter, increment its frequency counter
        curr.children[idx].freq++;
      }

      curr = curr.children[idx]; // Move to the child node for the current letter
    }
    curr.eow = true; // Mark the last node as the end of the word
  }

  // Function to find all unique prefixes in the Trie
  public static void findPrefix(Node root , String ans){
    if(root.children == null){ // If the children array of the current node is null, return
      return;
    }
    if(root.freq == 1){ // If the frequency counter of the current node is 1, print the current prefix
      System.out.println(ans);
      return;
    }
    for(int i = 0 ;i < root.children.length;i++){ // Loop through each child node of the current node
      if(root.children[i] != null){ // If the child node is not null, recursively call the findPrefix function for it
        findPrefix(root.children[i] , ans + (char)(i + 'a')); // Pass the child node and the current prefix as arguments to the function
      }
    }
  }

  public static void main(String[] args) {

    // Array of words to insert into the Trie
    String arr[] = { "zebra", "dog", "duck", "dove" };

    // Insert each word into the Trie
    for(int i = 0 ;i < arr.length;i++){
      insert(arr[i]);
    }

    root.freq = -1; // Set the frequency counter of the root node to -1

    // Call the findPrefix function to find all unique prefixes in the Trie
    findPrefix(root, " ");

  }
}
