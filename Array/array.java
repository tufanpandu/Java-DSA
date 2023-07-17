import java.util.Arrays;
import java.util.Collections;

public class array {

    public static void maxsubarray(int numbers[]) {
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < numbers.length; i++) {
            int start = i;
            for (int j = i; j < numbers.length; j++) {
                int end = j;
                sum = 0;
                for (int k = start; k <= end; k++) {
                    sum += numbers[k];
                }
                System.out.println(sum);
                if (maxSum < sum) {
                    maxSum = sum;
                }

            }

        }
        System.out.print("Max Sum " + maxSum);

    }

    public static void kadanse(int numbers[]) {
        int ms = Integer.MIN_VALUE;
        int cs = 0;

        for (int i = 0; i < numbers.length; i++) {
            cs = cs + numbers[i];
            if (cs < 0) {
                cs = 0;
            }
            ms = Math.max(ms, cs);
        }
        System.out.print("Our maximum subarray sum is : " + ms);

    }

    public static void bubbleSort(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

    }

    public static void selecationSort(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minPos = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[minPos] < arr[j]) {
                    minPos = j;
                }
            }
            // swap
            int temp = arr[minPos];
            arr[minPos] = arr[i];
            arr[i] = temp;
        }
    }

    public static void printArr(Integer arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");

        }
    }

    public static void main(String args[]) {

        // int numbers[] = { -2, -3, 4 - 1, -2, 1, 5, -3 };
        // int height[] = {0 , 1 , 2 , 1 , 0 , 1 , 3 , 2 , 1 , 2 , 1}
        Integer arr[] = { 5, 4, 1, 3, 2 };
        Arrays.sort(arr, 0, 3, Collections.reverseOrder());

        // maxsubarray(numbers);
        // kadanse(numbers);
        // selecationSort(arr);
        printArr(arr);

    }

}
