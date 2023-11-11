import java.util.*;

//========== Indian Coins ===================
public class IndianCoins {
    public static void indianCoins(Integer coins[]) {
        // Sort the 'coins' array in descending order
        Arrays.sort(coins, Comparator.reverseOrder());
        int count = 0;
        int amount = 590;
        ArrayList<Integer> coinList = new ArrayList<>();

        // Iterate through the sorted coins array
        for (int i = 0; i < coins.length; i++) {
            if (coins[i] <= amount) {
                // While the current coin can be used to reduce the remaining 'amount'
                while (coins[i] <= amount) {
                    count++;
                    coinList.add(coins[i]);
                    amount -= coins[i];
                }
            }
        }

        // Print the total count of coins used
        System.out.println("Number of Coins Used: " + count);

        // Print the list of coins used
        System.out.print("Coins Used: ");
        for (int coin : coinList) {
            System.out.print(coin + " ");
        }
    }

    public static void main(String[] args) {
        Integer coins[] = { 1, 2, 5, 10, 20, 50, 100, 500, 2000 };

        indianCoins(coins);
    }
}
