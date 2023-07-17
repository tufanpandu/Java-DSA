import java.util.*;
import java.util.LinkedList;

public class QueueBasic1 {

    //////////// Q1️⃣ Queue useing 2 stack //////////////////////////////
    // static class Queue {
    //     static Stack<Integer> s1 = new Stack();
    //     static Stack<Integer> s2 = new Stack();

    //     //isEmpty
    //     public static boolean isEmpty() {
    //         return s1.isEmpty(); // if s1 is empty then stack also empty
    //     }

    //     //add TC  O(n)
    //     public static void add(int data) {
    //         while (!s1.isEmpty()) {
    //             s2.push(s1.pop());
    //         }
    //         s1.push(data);
    //         while (!s2.isEmpty()) {
    //             s1.push(s2.pop());
    //         }
    //     }

    //     // remove TC O(1)
    //     public static int remove() {
    //         if (isEmpty()) {
    //             System.out.println("Queue is empty");
    //             return -1;
    //         }

    //         return s1.pop();
    //     }

    //     //peek TC O(1)
    //     public static int peek() {
    //         if (isEmpty()) {
    //             System.out.println("Queue is empty");
    //             return -1;
    //         }

    //         return s1.peek();
    //     }

    // }
     

    /////////////// Q2️⃣  Stack useing 2 Queue //////////////////////////////////

    // static class stack {
    //     static Queue<Integer> q1 = new LinkedList<>();
    //     static Queue<Integer> q2 = new LinkedList<>();

    //     //// isEmpty
    //     public static boolean isEmpty() {
    //         return q1.isEmpty() && q2.isEmpty(); // check both queue is empty or not 
    //     }

    //     ////Push or add
    //     public static void push(int data) {
    //         if (q1.isEmpty()) {
    //             q1.push(data);
    //         } else {
    //             q2.push(data);
    //         }
    //     }

    //     ///// Pop or remove
    //     public static int pop() {
    //         if (isEmpty()) { // check Queue is empty or not 
    //             System.out.println("Stack is Empty");
    //             return -1;
    //         }

    //         int top = -1; // queue is empty then top  return -1
    //         /// case 1
    //         if (!q1.isEmpty()) {
    //             while (!q1.isEmpty()) {
    //                 top = q1.remove();
    //                 if (q1.isEmpty()) {
    //                     break;
    //                 }
    //                 q2.add(top);
    //             }
    //         } else { // case 2
    //             while (!q2.isEmpty()) {
    //                 top = q2.remove();
    //                 if (q2.isEmpty()) {
    //                     break;
    //                 }
    //                 q1.add(top);
    //             }
    //         }
    //         return top;
    //     }

    //     ///////////////  Peek
    //     public static int peek() {
    //         if (isEmpty()) {
    //             System.out.println("Stack is Empty");
    //             return -1;
    //         }

    //         int top = -1;
    //         if (!q1.isEmpty()) {
    //             while (!q1.isEmpty()) {
    //                 top = q1.remove();
    //                 q2.add(top);
    //             }
    //         } else {
    //             while (!q2.isEmpty()) {
    //                 top = q2.remove();
    //                 q1.add(top);
    //             }
    //         }
    //         return top;

    //     }

    //}
    

    //////////Q3️⃣  First non-repeating letter in a stream of characters   /////////////////
    public static void nonRepeatingLetter(String str) {
        int freq[] = new int[26]; // Declar the size which is between "a" to "z".
        Queue<Character> q = new LinkedList<>(); // Create a Queue

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i); // Get a character from str string 
            q.add(ch); // Add character on Queue
            freq[ch - 'a']++; // update the frequence by one.

            while (!q.isEmpty() && freq[q.peek() - 'a'] > 1) { // check inside the queue of front is exsits non repeating letter or not.
                q.remove();
            }
            if (q.isEmpty()) {
                System.out.print(-1 + " ");
            } else {
                System.out.print(q.peek() + " ");
            }

        }
        System.out.println();

    }
    

    ////////////Q4️⃣  Interleave 2 Halves of a Queue(even length) /////////////////////////////////

    public static void interLeave(Queue<Integer> q) {
        Queue<Integer> firstHalf = new LinkedList<>();
        int size = q.size();
        for (int i = 0; i < size / 2; i++) {
            firstHalf.add(q.remove());
        }

        while (!firstHalf.isEmpty()) {
            q.add(firstHalf.remove());
            q.add(q.remove());
        }
    }
    

    /////// Q6️⃣  Queue Reversal /////////
    public static void reversalQueue(Queue<Integer> q) {
        Stack<Integer> s = new Stack<>();
        while (!q.isEmpty()) {
            if (q.isEmpty()) {
                System.out.println("Queue is Empty");
                return;
            }
            s.push(q.remove());
        }

        while (!s.isEmpty()) {
            if (s.isEmpty()) {
                System.out.println("Stack is Empty");
                return;
            }
            q.add(s.pop());
        }
    }


    public static void main(String agrs[]) {
        //Queue<Integer> q = new LinkedList<>();  //// You can use any of this class
        //   Queue<Integer> q = new ArrayDeque<>();

        // Stack s = new Stack();
        // s.push(1);
        // s.push(2);
        // s.push(3);
        // while (!s.isEmpty()) {
        //     System.out.println(s.peek());
        //     s.pop();
        // }
        /////////Q3️⃣  First non-repeating letter in a stream of characters   /////////////////
        // String str = "aabccxb";
        // nonRepeatingLetter(str);

        ////////////Q4️⃣  Interleave 2 Halves of a Queue(even length) /////////////////////////////////
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);
        q.add(9);
        q.add(10);
      // interLeave(q);
       reversalQueue(q);

        while (!q.isEmpty()) {
            System.out.print(q.remove() + " ");
        }
        System.out.println();

    
    }
}
