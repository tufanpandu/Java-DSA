import java.util.*;

public class GreedyAlgo1 {

  //////// Functional Knapsack /////////////////////////////////////////////
public static void main(String args[]){
  int value[] = {60,100,120};
  int weight[]= {10,20,30};
  int w = 50;
  double ratio[][] = new double[value.length][2];  // Create and 2d array
  // 0th col = index and 1st col = ratio
  for(int i = 0 ;i< value.length;i++){
        ratio[i][0] = i;  // Store index value
        ratio[i][1] = value[i]/(double)weight[i];  // Calculate and store the ratio  // Because of double value we have to type cast.
    
  }
 /// Now short  the ratio array // We short the array because of if array is not sorted on acending or decending order then shorting is helping.
  Arrays.sort(ratio, Comparator.comparingDouble(o -> o [1])); //This sorting  as Acending order.  

  //Decending order sorting using reverse for loop
  int capacity = w;
  int finalValue = 0;''
  for(int i = ratio.length-1;i>=0;i--){
    int idx = (int)ratio[i][0];
    if(capacity >= weight[idx]){ // include full item
      finalValue += value[idx];  // add the value to the final value 
      capacity -= weight[idx]; // remove the weight from the capacity
    }else{
      finalValue += (ratio[i][1] * capacity); // include fractional item
        capacity = 0 ;
      break;
    }
    
  }
  System.out.println("final val " + finalValue);
  
  
}
}