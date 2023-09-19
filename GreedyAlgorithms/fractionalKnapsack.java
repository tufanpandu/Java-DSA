import java.util.Arrays;
import java.util.Comparator;

public class fractionalKnapsack {
    // ============= Find Maximum total value in Fractional Kanpsack
    // ==================
    public static double fractionalKnapsack(int val[], int weight[], int W) {
        // Create Double type 2D array
        double ratio[][] = new double[val.length][2];
        // Find Fractional value and index then store into the ratio 2D array
        for (int i = 0; i < val.length; i++) {
            // {{0,faction Value},{0 , fraction value}}
            ratio[i][0] = i;
            ratio[i][1] = val[i] / (double) weight[i]; // you get the fraction value
        }
        // stor the array(It's sort the array in Assending order ) . we use here lambda
        // Expression
        // Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));
        Arrays.sort(ratio, Comparator.comparingDouble(a -> a[1]));

        // Capacity variable
        int capacity = W;
        int finalValue = 0;
        // It's sort in assending order but we need max value so iterate from last index
        // using loop.
        for (int i = ratio.length - 1; i >= 0; i--) {
            int idx = (int) ratio[i][0];
            // check the condion
            if (capacity >= weight[idx]) {
                finalValue += val[idx];
                capacity -= weight[idx];
            } else {// This condition for capacity is 9 kg and we have weight 18 kg
                finalValue += (capacity * ratio[i][1]);
                capacity = 0;
                break;
            }
        }

        return finalValue;

    }

    public static void main(String[] args) {
        int val[] = { 60, 100, 120 };
        int weight[] = { 10, 20, 30 };
        int W = 50;

        System.out.println(fractionalKnapsack(val, weight, W));
    }
}
