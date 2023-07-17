import java.util.*;

public class pattern {
    public static void hollo_rectangle(int totalRows, int toatalColm) {
        // Outer loop
        for (int i = 1; i <= totalRows; i++) {
            // inner loop
            for (int j = 1; j <= toatalColm; j++) {
                if (i == 1 || i == totalRows || j == 1 || j == toatalColm) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void inveted_roteted_half_pyramid(int n) {
        // Outer loop for Rows
        for (int i = 1; i <= n; i++) {
            // Space
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            // Star
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }

    public static void floyds_triangle(int n) {
        // Outet Loop
        int counter = 1;
        for (int i = 1; i <= n; i++) {
            // inner loop - How many time wil print in one line.
            for (int j = 1; j <= i; j++) {
                System.out.print(counter + " ");
                counter++;
            }
            System.out.println();
        }
    }

    public static void inverted_half_pyNum(int n) {
        // Outer loop
        for (int i = 1; i <= n; i++) {
            // Inner loop
            for (int j = 1; j <= (n - i + 1); j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }

    public static void zero_one_tringle(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                if ((i + j) % 2 == 0) {
                    System.out.print(" 1 ");
                } else {
                    System.out.print(" 0 ");
                }
            }
            System.out.println();
        }

    }

    public static void butterfly(int n) {
        // 1st half outer loop
        for (int i = 1; i <= n; i++) {
            // Star
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }

            // Space is = 2*(n-i)
            for (int j = 1; j <= 2 * (n - i); j++) {
                System.out.print(" ");
            }

            // Star
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        // 2nd Half Inverted
        for (int i = n; i >= 1; i--) {
            // // Star
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }

            // // Space is = 2*(n-i)
            for (int j = 1; j <= 2 * (n - i); j++) {
                System.out.print(" ");
            }

            // // Star
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }

    public static void solid_rhombus(int n) {
        // out line loop
        for (int i = 1; i <= n; i++) {
            // inner loop
            for (int j = 1; j <= (n - i); j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= n; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void hollo_rhombus(int n) {
        for (int i = 1; i <= n; i++) {
            // space
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            // star and space
            for (int j = 1; j <= n; j++) {
                if (i == 1 || i == n || j == 1 || j == n) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void dimond(int n) {
        // 1st line
        // outer loop
        for (int i = 1; i <= n; i++) {
            // inner loop
            // space
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            // star
            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.print("*");

            }

            System.out.println();
        }

        // 2nd half
        for (int i = n; i >= 1; i--) {
            // inner loop
            // space
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            // star
            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.print("*");

            }

            System.out.println();
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        // System.out.println("Enter the number of Rows : ");
        // int totalRows = sc.nextInt();
        // System.out.println("Enter the number of Columns :");
        // int toatalColm = sc.nextInt();
        // hollo_rectangle(totalRows, toatalColm);
        // inveted_roteted_half_pyramid(50);
        // inverted_half_pyNum(5);
        // floyds_triangle(5);
        // zero_one_tringle(5);
        // butterfly(5);
        // solid_rhombus(5);
        // hollo_rhombus(10);
        dimond(4);
    }
}
