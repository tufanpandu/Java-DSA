public class QueueB {
    static class Queue{
        static int arr[];
        static int size;
        static int rear;

        Queue(int n) {
            arr = new int[n];
            size =n;
            rear =-1;// rear is empty
        }
     // 👉👉is Empty
        public static boolean isEmpty() {
            return rear == -1; //rear is empty
        }

        //👉👉 add  -> Time Complexity O(1) 
        public static void add(int data){
            if(rear == size -1){
                System.out.println("queue is full");
                return;
            }
            
            rear = rear +1; //khali rear main ek ek karke add karenge
            arr[rear] = data; //rear main store data ko arr main store karenge and usko equal to data karenge
        }

        //👉👉Remove -> Time Complexity O(n)
        public static int remove(){
            if(isEmpty()){ //check Queue is empty or not
                System.out.println("empty queue");
                return -1; // if empty then return -1
            }

            int front = arr[0]; // index zero th place is equal to front
            for(int i=0; i<rear; i++){
                arr[i] = arr[i+1];
                
            }
            rear = rear-1; // remove one by one element from queue
            return front; 
        }

        //👉👉peek
        public static int peek(){
            if(isEmpty()){
                System.out.println("empty queue");
                return -1;
            }
            return arr[0];// if queue is not empty then return 0th index of arr and arr[0] is also front.
        }
    }
 //////////////////// 👉👉👉 Circular Array Queue 
    static class CircularArrayQueue{
        static int arr[];
        static int size;
        static int rear;
        static int front;
        private static Object reutrn;
        CircularArrayQueue(int n){
            arr = new int[n];
            size = n;
            rear = -1;
            front = -1;
        }

        /// isEmpty

        public static boolean isEmpty(){
            return rear == -1 && front == -1; // if rear and front is equal to -1 then queue is empty.
        }

      //// isFull
      public static boolean isFull(){
        return (rear+1) % size == front; //if happen (rear+1)% size  that means our queue is full and rear going to update and equal to front .
      }
  

        // Add
        public static void add(int data){
            if(isFull()){
              System.out.println("Queue is Full");
              return;
            }

            if(front == -1){ // We have to update front also.
                front = 0 ;
            }
            rear = (rear + 1) % size; // rear is now update and its going to zero.
            arr[rear] = data;
        
        }

        // remove
        public static int remove(){
        
            if(isEmpty()){
              System.out.println("Empty Queue");
              return -1;
             }
 
        int result = arr[front];
        // last element delete
        if(rear == front){
            rear = front = -1;
        }else{
            front = (front +1) % size;
        }
        return result;
      }   
      
      //////// peek
      public static int peek(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return -1;
        }
        return arr[front];
      }
    }
    public static void main(String args[]){
     CircularArrayQueue q = new CircularArrayQueue(5);
     q.add(1);
     q.add(2);
     q.add(3);
     q.add(4);
     q.add(5);
     

     while(!q.isEmpty()){// while Queue is not empty loop is run
        System.out.println(q.peek());//peek the fornt.
        q.remove();// after peeking front remove the fornt.
     }
    }
}
