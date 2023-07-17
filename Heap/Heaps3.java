import java.util.*;
class Heaps3 {
  static class Heap {
    ////////  Insert in Heap  /////////////////
        ArrayList<Integer> arr = new ArrayList<>(); // Defined Arraylis

        public void add(int data) { // Create a funciton add.
            arr.add(data); //add at last of arraylist

            int x = arr.size()-1; // x is a child index
            int parent = (x - 1) / 2; // parent index

            while (arr.get(x) < arr.get(parent)) {//while child x is lessthen  parent loop is run

                /// Swap
                int temp = arr.get(x);
                arr.set(x, arr.get(parent));
                arr.set(parent, temp);
               x = parent;
               parent = (x-1)/2;
            }
        }
 //////////////// Peek in Heap  ////////
        public int peek(){
          return arr.get(0); // 
        }

       private void heapify(int i){
         int left = 2*i+1;
          int right = 2* i +2;
              int minIndex  = i;

  if(left < arr.size() && arr.get(minIndex) < arr.get(left)){
    minIndex = left;
  }

  if(right < arr.size() && arr.get(minIndex) < arr.get(right)){
    minIndex = right;
  }

 if(minIndex != i){
    int temp = arr.get(i);
     arr.set(i , arr.get(minIndex));
   arr.set(minIndex, temp);
    heapify(minIndex);
 }
}
    /////// Remove in Heap /////////////
    public int remove(){
      int data = arr.get(0);
//// Swap first and last index
      int temp = arr.get(0);
      arr.set(0, arr.get(arr.size()-1));
      arr.set(arr.size()-1, temp);
//// Remove the last index
      arr.remove(arr.size()-1);
      //// Hipify
      heapify(0);
      return data;
    }

    public boolean isEmpty(){
      return arr.size() == 0;
    }
  }
    
  public static void main(String []args) {
    Heap hp = new Heap();
    hp.add(2);
    hp.add(5);
    hp.add(3);
    hp.add(1);
    hp.add(4);

    while(!hp.isEmpty()){
      System.out.println(hp.peek());
      hp.remove();
    }
  }
  
}
