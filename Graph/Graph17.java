import java.util.*;

public class Graph17 {
    public static void helper(int[][] image, int sr, int sc, int color, boolean visit[][], int orgColor) {
        // Base Case : Check if current poistion is valid for flood fill .
        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || visit[sr][sc]
                || image[sr][sc] != orgColor) {
            return; // If base case condition is not vaile then stop the
        }
        image[sr][sc] = color; // change the colour of current cell.
        // left
        helper(image, sr, sc - 1, color, visit, orgColor);
        // right
        helper(image, sr, sc + 1, color, visit, orgColor);
        // top
        helper(image, sr - 1, sc, color, visit, orgColor);
        // bottom
        helper(image, sr + 1, sc, color, visit, orgColor);
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        boolean visit[][] = new boolean[image.length][image[0].length];
        helper(image, sr, sc, color, visit, image[sr][sc]);
        return image; // return updated image 2D array.
    }

    public static void main(String args[]) {
        int image[][] = { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };
        int sr = 1, sc = 1, color = 2;
        int[][] result = floodFill(image, sr, sc, color);// Store the image 2D array into result 2D array

        // print image
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}
