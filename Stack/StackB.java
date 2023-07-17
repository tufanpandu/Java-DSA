import java.util.*;
public class StackB {
    //////// Q1️⃣  Push at the bottom at the stack ///////////////
    public static void pushAtBottom(Stack<Integer> s , int data){
        if(s.isEmpty()){
            s.push(data);
            return;
        }

        int top = s.pop(); // Store all remove tops
        pushAtBottom(s, data);
        s.push(top);// add all data which is stor in top data like 1,2,3

    }

    ////// Q2️⃣   Reverse a String using a Stack ///////
    public static String reverseString(String str){
        Stack<Character> s = new Stack();
        int idx = 0;
        while(idx < str.length()){
           s.push(str.charAt(idx));
           idx++;
        }
        StringBuffer result = new StringBuffer("");
        while(!s.isEmpty()){
            char curr = s.pop();
            result.append(curr);
        }
         return result.toString();
    }

    ///////////  Q3️⃣  Reverse Stack  //////////

   public static void reverseStack(Stack<Integer> s ){
    if(s.isEmpty()){
        return;
    }
    int top = s.pop();
    reverseStack(s);
    pushAtBottom(s, top);

   }
   
   public static void printStack(Stack<Integer> s ){
       while(!s.isEmpty()){
           System.out.println(s.pop());
        }
    }
    
    /////////////Q4️⃣   Stock Span Problem //////////////////////////////
 public static void stocksSpan(int stocks[], int span[]){
    Stack<Integer> s = new Stack<>();  // create a stack
     span[0] = 1;  // Index zero is have value 1
    s.push(0);  // push the index on bottom of stack

   for(int i = 1; i< stocks.length; i++){
     int currentPrice = stocks[i];  //created current price of stocks
// Now run a while loop while a stack is not empty and pop() the all index based on  give condition
     while(!s.isEmpty() && currentPrice > stocks[s.peek()]){
       s.pop();
     }
    if(s.isEmpty()){ //if stack is empty then last index is going to i+1
        span[i] =i+1;
    }else{
        int previousHigh = s.peek();
        span[i] = i - previousHigh ; // claculat the previous high
    }
    s.push(i); 
   }

 }

 //////////////////  Q6️⃣ Valid Parentheses /////////////////////

   public static boolean isValid(String str){
    Stack<Character> s = new Stack<>();
    
    for(int i =0; i< str.length(); i++){
        char ch = str.charAt(i);
        //Opening Bracket
        if(ch == '(' || ch == '{'|| ch == '['){
            s.push(ch);
        }else{
            //Closing
            if(s.isEmpty()){
                return false;
            }
            if((s.peek()== '(' && ch == ')')
             || (s.peek() == '{' && ch == '}') 
             || (s.peek() == '[' && ch == ']')){

                s.pop();
            }else{
                return false;
            }
        }
    }
    if(s.isEmpty()){
        return true;
    }else{
        return false;
    }
   }


   //////////// Q7️⃣  Duplicate Parentheses ////////////////////////////

   public static boolean isDuplicate(String str){
    Stack<Character> s = new Stack<>();

    for(int i = 0; i< str.length();i++){
        char ch = str.charAt(i);

        // Closing
        if(ch == ')'){
            int count = 0;
            while(s.peek() != '('){
                s.pop();
                count++;
            }
            if(count < 1){
                return true; // Duplicate
            }else{
                s.pop(); // opening pair
            }

        }else{
            // Opening 
            s.push(ch);
        }
    }
    return false;
   }

    /////////////Q8️⃣ Max Area in Histogram   /////////////////////////////
    public static void largesRectangle(int arr[]){
        int maxArea=0;
        int nsr[] = new int[arr.length];
        int nsl[] = new int[arr.length];
        //Next Smaller Right 
        Stack<Integer> s = new Stack<>();
for(int i = arr.length-1; i>=0;i--){
    while(!s.isEmpty()&& arr[s.peek()]>= arr[i]){ // if you want to find smaller element then remove  Big element first
        s.pop();
    }
    if(s.isEmpty()){
    nsr[i] = arr.length;  // for right side i have to take arr.length means last extra index
    }else{
        nsr[i]= s.peek();  // Pick the Top and stor it on NSR index
    }
    s.push(i);
}
        // Next Smaller Left
         s = new Stack<>(); //create new stack
        for(int i = 0 ; i< arr.length; i++){
            while(!s.isEmpty() && arr[s.peek()] >= arr[i]){
                s.pop();
            }
            if(s.isEmpty()){
                nsl[i] =-1;
            }else{
                nsl[i] =s.peek();
            }
            s.push(i);
        }

        //Count the current area : width = (j-i-1)  or( nsl[i] - nsr[i] -1 )
         
        for(int i=0; i<arr.length; i++){
            int heigh = arr[i];  //We know height is arr of index
            int width = nsr[i] - nsl[i]-1;
            int currArea = heigh * width;
            maxArea = Math.max(currArea, maxArea);
        }
   System.out.println("Max area in Histogram : " + maxArea);
       
    }

    public static void main(String args[]){
         //////// Q1️⃣  Push at the bottom at the stack ///////////////

       // Stack<Integer> s = new Stack<>();
    //     s.push(1);
    //     s.push(2);
    //     s.push(3);

    //     pushAtBottom(s , 4);
       

    //   while(!s.isEmpty()){
    //     System.out.println(s.pop());

    //   }
 ////// Q2️⃣   Reverse a String using a Stack ///////
    // String str = "abc";
    // String result =  reverseString(str);
    // System.out.println(result);

  ///////////  Q3️⃣  Reverse Stack  //////////
//    Stack<Integer> s = new Stack();
//    s.push(1);
//    s.push(2);
//    s.push(3);

//    printStack(s);
//    reverseStack(s);
//    printStack(s);

    /////////////Q4️⃣   Stock Span Problem //////////////////////////////

    // int stocks[] = { 100,80,60,70,60,85,100};  //create a stock price list
    // int span[] = new int[stocks.length];  // store length of stock in span
    // stocksSpan(stocks,span);  // call the method

    // for(int i = 0; i< span.length;i++){
    //     System.out.println(span[i] + " ");
    // }

    /////////////  Problem 5️⃣ Next Gratest Element  /////////////////////
    // int arr[] = {6,8,0,1,3};
    // Stack<Integer> s = new Stack<>();
    // int nextGrater[] = new int[arr.length];

    // for(int i = arr.length-1; i>=0; i--){
    //     //while
    //      while(!s.isEmpty() && arr[s.peek()] <= arr[i]){
    //          s.pop();
    //      }
    //     //if- else
    //     if(s.isEmpty()){
    //         nextGrater[i] = -1;
    //     }else{ 
    //         nextGrater[i] = arr[s.peek()];
    //     }
    //     // push
    //     s.push(i);
    // }

    // for(int i = 0 ; i< nextGrater.length;i++){
    //     System.out.print(nextGrater[i]+ " ");
    // }
    // System.out.println();
//----------------------------------------------------------------------------------------
 //////////////////  Q6️⃣ Valid Parentheses /////////////////////
    // String str = "(({})[]";
    // System.out.println(isValid(str));

    //-----------------------------------------------------------------------------------

 //////////// Q7️⃣  Duplicate Parentheses ////////////////////////////

//  String str = "((a+))";
//  System.out.println(isDuplicate(str));

 /////////////Q8️⃣ Max Area in Histogram   /////////////////////////////
 int arr[] = {2,1,5,6,2,3};
  largesRectangle(arr);


 } 
}
