import java.util.*;

public class Heap4 {
    public static void heapify(int arr[], int i, int size) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int maxIndex = i;

        if (left < size && arr[maxIndex] < arr[left]) {
            maxIndex = left;
        }
        if (right < size && arr[maxIndex] < arr[right]) {
            maxIndex = right;
        }

        if (maxIndex != i) {
            int temp = arr[i];
            arr[i] = arr[maxIndex];
            arr[maxIndex] = temp;

            heapify(arr, maxIndex, size);
        }
    }
    public static void heapSort(int arr[]) {
        //build maxheap
        int n = arr.length;
        for (int i = n / 2; i >= 0; i--) {
            heapify(arr, i, n);
        }
        
        // 2nd - Swap Largest value / first index  with smallest value / last index.
        for (int i = n - 1; i > 0; i--) {
          // Push the largest at end .
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, 0, i);

        }
    }
    public static void main(String[] args) {
        int arr[] = { 1, 2, 4, 5, 3 };

        heapSort(arr);

        for (int i = 0; i <arr.length; i++) {
            System.out.println(arr[i]+ " ");
        }

    }
}
