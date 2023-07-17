/* Java program to check if linked list is palindrome
* recursively */
import java.util.*;

class StackQ {
    public static boolean isPalindrome(String str){
        Stack<Character> s = new Stack<Character>();
        boolean isPalin = true;
        char ch ;
        for(int i = 0 ; i< str.length();i++){
             ch = str.charAt(i);
            //push on stack
            s.push(ch);
        }
        // pop
        if(ch == s.peek()){

        }
    }
	public static void main(String args[]){
	String str = "ABA";
	}


}
