public class DivideAndConquer {

    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    ///// Merge Sort

    public static void mergeSort(int arr[], int si, int ei) {
        //// Base Case
        if (si >= ei) {
            return;
        }

        // kaam

        int mid = si + (ei - si) / 2; /// We can write this formula like this also : ( si + ei)/2
        mergeSort(arr, si, mid); /// Left part is sorted
        mergeSort(arr, mid + 1, ei); /// Right Part is sorted
        merge(arr, si, mid, ei); /// Both Left and Right part is going to merge

    }

    public static void merge(int arr[], int si, int mid, int ei) {
        int temp[] = new int[ei - si + 1];
        int i = si; // Iterator for Left part of starting index.
        int j = mid + 1; // Iterator for Right part of Starting Index.
        int k = 0; // Iteratior for temporarry index.

        while (i <= mid && j <= ei) {
            if (arr[i] < arr[j]) {
                temp[k] = arr[i]; // Temp array store the value of arr[i] from Left Part.
                i++;
            } else {
                temp[k] = arr[j]; // Temp array store the value of arr[j] from Right Part.
                j++;
            }
            k++;
        }

        //// Left Part
        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        //// Right Part
        while (j <= ei) {
            temp[k++] = arr[j++];
        }

        //// Copy the temporarry arr to Original array.
        for (k = 0, i = si; k < temp.length; k++, i++) {
            arr[i] = temp[k];
        }
    }

    //// ⭐⭐⭐⭐⭐⭐ Quick Sort⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐

    public static void printArr2(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");

        }
        System.out.println();
    }

    public static void quickSort(int arr[], int si , int ei){
        // Base case
        if(si>=ei){
            return;
        }

        int pidx = partition(arr, si , ei);  //Find the pivit index of all the array and sub-array
        quickSort(arr , si , pidx-1); // left part
        quickSort(arr, pidx+1, ei); // Right Part
    }
    public static int partition(int arr[], int si , int ei){
        int pivot =  arr[ei]; // find the pivot
        int i = si - 1; // to make place for element which is smaller element  then pivot

        for(int j = si; j< ei; j++){  // Run the for loop from starting indix to ending index
            if(arr[j]<= pivot){
                i++; // update the i
                //Swap
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        //Let's define the position of pivot or ending index
        i++; // update the i

        int temp = pivot; //pivod is variable
        arr[ei] = arr[i];
        arr[i] = temp;

        return i;

    }

    //// ⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐ Search in Rotated sorted Array ⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐

    public static int search(int arr[], int target, int si, int ei) {
        // Base
        if (si > ei) {
            return -1;
        }
        // Kaam
        int mid = si + (ei - si) / 2;

        /// Case Found
        if (arr[mid] == target) {
            return mid;
        }
        // Mid on L1
        if (arr[si] <= arr[mid]) {
            // Case 1
            // Case a: for Left side
            if (arr[si] <= target && target <= arr[mid]) {
                return search(arr, target, si, mid - 1);
            }
            // Case b : Right side
            else {
                return search(arr, target, mid + 1, ei);
            }

        }
        // Mid on L2
        else {
            // Case 2
            // case c: Right Side
            if (arr[mid] <= target && target <= arr[ei]) {
                return search(arr, target, mid + 1, ei);
            }

            // case d : Left Side
            else {
                return search(arr, target, si, mid - 1);
            }
        }
    }

    public static void main(String[] args) {
        // int arr[] = { 6, 3, 9, 5, 2, 8 };
        // mergeSort(arr, 0, arr.length - 1);
        // printArr(arr);
        // int arr[] = { 6, 3, 9, 8, 2, 5 };
        // printArr2(arr);
        // quickSort(arr, 0, arr.length - 1);
        // printArr2(arr);
        int arr[] = { 4, 5, 6, 7, 0, 1, 2 };
        int target = 7;
        int result = search(arr, target, 0, arr.length - 1);
        System.out.println(result);
    }

}
