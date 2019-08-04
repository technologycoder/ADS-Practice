package praxis;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add(0, "abc");
        int amount = 5;
        int[] coins = {1, 2, 3, 4};
        //System.out.println(coinChange(amount, coins, 0));
        amount++;
        System.out.println(amount);

    }

    public static int coinChange(int amount, int[] coins, int index) {
        if (amount == 0) {
            return 1;
        } else if (amount < 0 || index >= coins.length) {
            return 0;
        } else {
            return coinChange(amount - coins[index], coins, index + 1) +
                    coinChange(amount, coins, index + 1);
        }

    }

}
