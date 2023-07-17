public class Circularll{
    public class Node{
        int data;
        Node next;
        Node last;
        public Node(int data){
            this.data = data;
            this.next = null;
            this.last = null;
        }
    }

    /// AddToEmpty
    public static Node addToEmpty(Node last , int data){
        //Corner Case
        if(last != null){
            return last;
        }
        Node newNode = new Node();
        newNode.data = data;
        last = newNode;
        newNode.next = last;
        return last;

    }

    public static void main(String args[]){
      
        Circularll cll = new Circularll();
        
        cll.addToEmpty(last, 1);
    }
}