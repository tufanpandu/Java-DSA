
public class LinkedList {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }

    }

    public static Node head;
    public static Node tail;
    public static int size; // it declar for calculat the size

    //// 👉👉👉 addFirst Function

    public void addFirst(int data) {
        // Step 1 -Create new node
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        // Step 2 - newNodes next = head.
        newNode.next = head; // Link

        // Step 3 - Head = newNode.
        head = newNode;
    }

    //// 👉👉👉 addLast Function
    public void addLast(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    /// 👉👉👉👉Print all Function
    public void print() {
        if (head == null) {
            System.out.println(" LinkedList is Empty");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "-> ");
            temp = temp.next;
        }
        System.out.println("Null ");
    }

    ///// 👉👉👉👉👉👉 Add a Middle Function
    public void add(int index, int data) {
        if (index == 0) {
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i = 0;
        while (i < index - 1) {
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    ////// 👉👉👉👉 Remove First
    public int removeFirst() {
        if (size == 0) {
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    ////// 👉👉👉👉👉Remove Last
    public int removeLast() {
        if (size == 0) {
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        Node prev = head;
        for (int i = 0; i < size - 2; i++) {
            prev = prev.next;
        }
        int val = prev.next.data;
        prev.next = null;
        tail = prev;
        size--;
        return val;
    }

    ///// ✅✅✅✅✅ Intarativ Search
    public int itarSearch(int key) {
        Node temp = head;
        int i = 0;
        while (temp != null) {
            if (temp.data == key) { // found case
                return i;
            }
            temp = temp.next;
            i++;

        }
        // Key not found case
        return -1;
    }

    //// 👉👉👉👉 Recursive Search
    public int helper(Node head, int key) {
        if (head == null) { // Not found case
            return -1;
        }
        if (head.data == key) {// Found Case
            return 0;
        }
        int idx = helper(head.next, key);
        if (idx == -1) {
            return -1;
        }
        return idx + 1;

    }

    public int recuSearch(int key) {
        return helper(head, key);
    }

    ///// 👉👉👉👉👉 Reverse Linked list
    public void reverse() {
        Node prev = null;
        Node curr = tail = head;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    ///// 👉👉👉👉 Remove Nth node from end
    public void removeNthnode(int n) {
        // Calculatin size
        int size = 0;
        Node temp = head;
        while (temp != null) {
            temp = temp.next;
            size++;
        }
        if (n == size) {
            head = head.next; // remove First or head remove condition
            return;
        }

        // size - n // find previous of n number
        int i = 1;
        int iToFind = size - n;
        Node prev = head;
        while (i < iToFind) {
            prev = prev.next;
            i++;
        }

        prev.next = prev.next.next;
        return;
    }

    ///// ✅✅✅✅✅ Check if linked list is Palindrome or note
    public Node findMid(Node head) { // Find the middle node of the linked list .
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next; // +1 move
            fast = fast.next.next; // +2 move
        }
        return slow;
    }

    public boolean checkPalindrome() {
        // Base Case
        if (head == null || head.next == null) {
            return true;
        }
        // Find Middle
        Node mid = findMid(head);

        // Reverse 2nd Half
        Node curr = mid;
        Node prev = null;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node right = prev;
        Node left = head;
        // Check if equal
        while (right != null) {
            if (left.data != right.data) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }

    ///// 👉👉👉👉👉 Detect a Loop / Cycle in a LinkedList
    public static boolean isCycle() {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next; // +1 move
            fast = fast.next.next; // +2 move
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    ////// Remove Loop/Cycle in a LinkedList
    public static void removeCycle() {
        /// Detect Cycle
        Node slow = head;
        Node fast = head;
        boolean cycle = false;
        while (fast != null && fast.next != null) {
            slow = slow.next; // +1 move
            fast = fast.next.next; // +2 move
            if (slow == fast) {
                cycle = true;
                break;
            }
        }
        if (cycle == false) {
            return;
        }

        /// Find Meeting point
        slow = head;
        Node prev = null; // Last node
        while (slow != fast) {
            prev = fast;
            slow = slow.next; // +1 move
            fast = fast.next; // +1 move
        }

        /// remove cycle last.next = null;
        prev.next = null;

    }

    ///// ✅✅✅👉👉Merge Sort on a LinkedList
    private Node getMid(Node head) {
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next; // +1 Move
            fast = fast.next.next; // +2 move
        }
        return slow;
    }

    private Node merge(Node head1, Node head2) {
        Node mergell = new Node(-1);
        Node temp = mergell;
        while (head1 != null & head2 != null) {
            if (head1.data <= head2.data) {
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            } else {
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
        }

        while (head1 != null) {
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }

        while (head2 != null) {
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }

        return mergell.next;
    }

    public Node mergeSort(Node head) {
        // Corner case
        if (head == null || head.next == null) {
            return head;
        }
        // Find Mid
        Node mid = getMid(head);
        // Left Head1 and Right Head2
        Node rightHead = mid.next;
        mid.next = null;
        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(rightHead);
        // MergeLL
        return merge(newLeft, newRight);

    }

    ////// 👉👉👉👉👉 ZigZag Linked List
    public void zigZag() {
        // find mid
        Node slow = head;
        Node fast = head.next; // helps to find Even Case
        while (fast != null && fast.next != null) {
            slow = slow.next; // +1 move
            fast = fast.next.next; // +2 move
        }
        Node mid = slow;
        // Reverse 2nd Half
        Node curr = mid.next;
        mid.next = null;
        Node prev = null;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node left = head;
        Node right = prev;
        Node nextLeft, nextRight;
        // Zig Zag merge
        while (left != null && right != null) {
            nextLeft = left.next;
            left.next = right;
            nextRight = right.next;
            right.next = nextLeft;

            // Update
            left = nextLeft;
            right = nextRight;
        }

    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        ll.print();
        ll.zigZag();
        ll.print();
    }
}
