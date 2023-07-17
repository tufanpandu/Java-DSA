public class Doublell {
    public class Node {
      int data;
      Node next;
      Node prev;

      public Node(int data){ // Constroctor
        this.data = data;
        this.next = null;
        this.prev = null;

      }
    }
    // Variables
    public static Node head;
    public static Node tail;
    public static int size;

    /// 👉👉👉Add First 
    public void addFirst(int data){
        Node newNode = new Node(data);
        size++;
        // Corner case
        if(head ==  null){
            head = tail =  newNode;
            return;   
        }
     newNode.next = head;
     head.prev = newNode;
     head = newNode;
        
    }

    //print
    public void print(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + " <->");
            temp = temp.next;
        }
       System.out.println("null");
    }

    ///👉👉👉👉 Remove First
 public int removeFirst(int data){
    // Corner case
    if(head == null){
        System.out.println(" Double Linked list have empty Node");
        return Integer.MIN_VALUE;
    }
// If Node size is 1 then this condition will apply
    if(size == 1){
        int val = head.data;
        head = tail = null;
        size--;
        return val;
    }
   int val = head.data;
    head = head.next;
    head.prev = null;
    size--; 
    return val;
 }

 /// Add Last
 public void addLast(int data){
    Node newNode = new Node(data);
    size++;
    // Corner case
    if(head == null){
        head = tail = newNode;

    }
    tail.next = newNode;
    newNode.next = null;
    tail = newNode;

 }

// 👉👉👉 public int removeLast(){
    
//     if(head == null){
//         System.out.println("Double linked list is empty");
//         return 0;
//     }
  
//     if(size ==1){
//         int val = head.data;
//         head = tail = null;
//         size--;
//         return val;
//     }
//     int val = head.data;
//     tail = tail.prev;
   
//     size--;
//     return val;
//  }

///  👉👉👉👉👉 Reverse a Double Linked List
    
  public static void reverseDll(int data){
    Node curr = head;
    Node prev = null;
    Node next;

    while(curr!= null){
        next = curr.next;
        curr.next = prev;
        curr.prev = next;
        prev = curr;
        curr = next;
    }
    head = prev;
  }
    public static void main(String args[]) {
    Doublell dll = new Doublell();
    dll.addFirst(3);
    dll.addFirst(2);
    dll.addFirst(1);
    dll.addLast(4);
    dll.addLast(5);
    dll.addLast(6);
    dll.print();
    dll.reverseDll(size);
    dll.print();
    
    }
}
