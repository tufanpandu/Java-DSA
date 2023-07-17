import java.util.*;

// public class StackBasic {
//     static class Node{
//         int data;
//         Node next;
//         Node(int data){
//             this.data = data;
//             this.next = null;
//         }
//     }
//     static class Stack {
        
//       // // -----------------------  👉👉 ArrayList ------------------
//         static ArrayList<Integer> list = new ArrayList<>();

//         // Check stack is empty of not
//         public static boolean isEmpty() {
//             return list.size() == 0;
//         }

//         // 👉👉Push()
//         public static void push(int data){
//             list.add(data);
//         }

//         // 👉👉 pop()
//         public static int pop(int data){
//             if(isEmpty()){
//                 return -1;
//             }
//             int top = list.get(list.size()-1);
//             list.remove(list.size()-1);
//             return top;

//         }

//         // 👉👉Peek
//         public static int peek(int data){
//             if(isEmpty()){
//                 return -1;
//             }
//             return list.get(list.size()-1);
//         }
      //// ------------------------------------------------------------
////------------------------ 👉👉Linked List -------------------------
       static Node head = null;

       // Check if Stack is Empty or Not
       public static boolean isEmpty(){
        return head == null;
       }

       // Push
       public static void push(int data){
        Node newNode = new Node(data);

        if(isEmpty()){ // if stack is null
            head = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
       }

       // pop
       public static int pop(){
        if(isEmpty()){
            return -1;
        }
        int top = head.data;
        head = head.next;
        return top;

       }

       // peek
       public static int peek(){
        if(isEmpty()){
            return -1;
        }
        return head.data;
       }
       public static void main(String args[]){
           Stack<Integer> sk = new Stack<>();
           sk.push(1);
           sk.push(2);
           sk.push(3);
           sk.push(4);
   
           while(!sk.isEmpty()){
               System.out.println(sk.peek());
               sk.pop();
           }
       }
    }

