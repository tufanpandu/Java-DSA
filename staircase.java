public class staircase {
    public static boolean staircaseSearch(int matrix[][], int key) {
        int row = 0;
        int col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == key) {
                System.out.println("key is found at (" + row + " , " + col + " ).");
                return true;
            } else if (key < matrix[row][col]) {
                col--;
            } else {
                row++;
            }
        }
        System.out.println("Key is not found");
        return false;

    }

    public static boolean staircaseSearch2(int matrix[][], int key) {
        int row = matrix.length - 1;
        int col = 0;
        while (col < matrix[0].length && row >= 0) {
            if (matrix[row][col] == key) {
                System.out.println("key is found at (" + row + " , " + col + " ).");
                return true;
            } else if (key > matrix[row][col]) {
                col++;

            } else {
                row--;
            }
        }
        System.out.println("Key is not found");
        return false;
    }

    public static void main(String[] args) {
        int matrix[][] = { { 10, 20, 30, 40 },
                { 15, 25, 35, 45 },
                { 27, 29, 37, 48 },
                { 32, 33, 39, 50 } };
        // staircaseSearch(matrix, 33);
        staircaseSearch2(matrix, 37);

    }

}
