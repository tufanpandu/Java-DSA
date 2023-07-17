import java.net.SocketTimeoutException;
import java.util.*;

public class strings {
    public static boolean palindrome(String name) {
        for (int i = 0; i < name.length() / 2; i++) {

            if (name.charAt(i) == name.charAt(name.length() - i - 1)) {
                return true;
            }
        }
        return false;
    }

    public static float pathShortest(String path) {
        int x = 0, y = 0;
        for (int i = 0; i < path.length(); i++) {
            char diar = path.charAt(i);
            // Sout
            if (diar == 'S') {
                y--;
            }
            // North
            else if (diar == 'N') {
                y++;
            }
            // East
            else if (diar == 'E') {
                x++;
            }
            // West
            else {
                x--;
            }

        }
        int x2 = x * x;
        int y2 = y * y;
        return (float) Math.sqrt(x2 + y2);
    }

    public static String subStrings(String name, int si, int ei) {
        String substr = "";
        for (int i = si; i < ei; i++) {
            substr += name.charAt(i);
        }
        return substr;
    }

    public static String largestFruits(String fruits[]) {
        String largest = fruits[0];
        for (int i = 1; i < fruits.length; i++) {
            if (largest.compareTo(fruits[i]) < 0) {
                largest = fruits[i];
            }
        }
        return largest;
    }

    // Contvert each of the first later of each word to UppearCase

    public static String toUpperCase(String name) {
        StringBuilder sb = new StringBuilder("");
        char ch = Character.toUpperCase(name.charAt(0));
        sb.append(ch);
        for (int i = 1; i < name.length(); i++) {
            if (name.charAt(i) == ' ' && i < name.length() - 1) {
                sb.append(name.charAt(i));
                i++;
                sb.append(Character.toUpperCase(name.charAt(i)));
            } else {
                sb.append(name.charAt(i));
            }
        }
        return sb.toString();
    }

    // String Compression
    public static String compression(String str) {
        StringBuilder sb = new StringBuilder("");

        for (int i = 0; i < str.length(); i++) {
            Integer count = 1;
            while (i < str.length() - 1 && str.charAt(i) == str.charAt(i + 1)) {
                count++;
                i++;
            }
            sb.append(str.charAt(i));
            if (count > 1) {
                sb.append(count.toString());
            }
        }
        return sb.toString();
    }

    public static void main(String args[]) {
        // Scanner sc = new Scanner(System.in);
        // String name = sc.nextLine();
        // String path = "WNEENESEN";
        // System.out.println(palindrome(name));
        // System.out.println(pathShortest(path));
        // String name = "TufanPandu";
        // System.out.println(name.substring(0, 6));
        // System.out.println(subStrings(name, 0, 6));
        // String fruits[] = { "apple", "mango", "bananana", "grapes" };
        // System.out.println(largestFruits(fruits));
        // StringBuilder sb = new StringBuilder("");
        // for (char ch = 'a'; ch <= 'z'; ch++) {
        // sb.append(ch);
        // }
        // System.out.println(sb.length());
        // }

        // String name = "tufna chandra pandu";
        // System.out.println(toUpperCase(name));

        ////// String Compression
        String str = "tuufffaaaannnnn";
        System.out.println(compression(str));

    }

}
