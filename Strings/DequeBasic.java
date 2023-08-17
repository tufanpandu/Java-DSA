package Strings;

import java.util.*;
import java.util.LinkedList;

public class DequeBasic {

    ////// Implemntation Stack using Deque /////////////////////
    static class Stack {
        Deque<Integer> deque = new LinkedList<>();

        public void push(int data) {
            deque.addLast(data);
        }

        public int pop() {
            return deque.removeLast();
        }

        public int peek() {
            return deque.getLast();
        }
    }

    /////////// Implimentation Queue using Deque /////////////////

    static class Queue {
        Deque<Integer> deque = new LinkedList<>();

        public void add(int data) {
            deque.addLast(data);
        }

        public int remove() {
            return deque.removeFirst();
        }

        public int peek() {
            return deque.getFirst();
        }

    }

    public static void main(String args[]) {
        // Stack s = new Stack(); // create a object
        // s.push(1);
        // s.push(2);
        // s.push(3);

        // System.out.print(s.peek());
        // s.pop();
        // System.out.print(s.peek());,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,
        // System.out.print(s.peek());

        /////////// Implimentation Queue using Deque /////////////////

        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        System.out.println(q.peek() + " ");
        q.remove();
        System.out.println(q.peek() + " ");
        q.remove();
        System.out.println(q.peek() + " ");
        q.remove();
        System.out.println(q.peek() + " ");
        q.remove();
        System.out.println(q.peek() + " ");

    }
}
