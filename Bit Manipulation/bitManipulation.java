
public class bitManipulation {

    ////// Check if a number is odd or even .

    public static void oddOrEven(int n) {
        int bitMask = 1;
        if ((n & bitMask) == 0) {
            // Even Number
            System.out.println("Number is Even ");

        } else {
            System.out.println("Number is odd");
        }
    }

    /// Operation
    //// Get ith Bit
    public static int getIthBit(int n, int i) {
        int bitMask = 1 << i;
        if ((n & bitMask) == 0) {
            return 0;

        } else {
            return 1;
        }
    }

    //// Set ith Bit
    public static int setIthBit(int n, int i) {
        int bitMask = 1 << i;
        return n | bitMask;
    }

    ////// Clear ith Bit

    public static int clearIthBit(int n, int i) {
        int bitMask = ~(1 << i);
        return n & bitMask;
    }
    //// Update Ith Bit

    public static int updateIthBit(int n, int i, int newBit) {
        // ////1st approch
        // if (newBit == 0) {
        // return clearIthBit(n, i);
        // } else {
        // return setIthBit(n, i);
        // }

        //// 2nd Approch
        n = clearIthBit(n, i);
        int bitMask = newBit << i;
        return n | bitMask;
    }

    //// Clear I Bit

    public static int clearIbit(int n, int i) {
        int bitMask = (~0) << i;
        return n & bitMask;
    }

    //// Clear range of bits

    public static int clearRangeofBits(int n, int j, int i) {
        int a = ((~0) << (j + 1));
        int b = (1 << i) - 1;
        int bitMask = a | b;
        return n & bitMask;
    }

    //// Number is power of two
    public static boolean isPowerofTwo(int n) {
        return (n & (n - 1)) == 0;
    }

    ///// Count set Bits

    public static int countSetBits(int n) {
        int count = 0;
        while (n > 0) {
            if ((n & 1) != 0) {
                count++;
            }
            n = n >> 1;
        }
        return count;
    }

    ///// Fast Exponentiation

    public static int fastExponentiation(int n, int a) {
        int ans = 1;
        while (n > 0) {
            if ((n & 1) != 0) {
                ans = ans * a;
            }
            a = a * a;
            n = n >> 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        // oddOrEven(4);
        // oddOrEven(2);
        // oddOrEven(19);

        // System.out.println(getIthBit(11, 2));
        // System.out.println(setIthBit(11, 2));
        // System.out.println(clearIthBit(10, 2));
        // System.out.println(updateIthBit(10, 2, 1));
        // System.out.println(clearIbit(15, 2));
        // System.out.println(clearRangeofBits(10, 4, 2));
        // System.out.println(isPowerofTwo(6));
        // System.out.println(countSetBits(10));
        System.out.println(fastExponentiation(4, 8));

    }
}