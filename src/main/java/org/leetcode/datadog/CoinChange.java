package org.leetcode.datadog;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/coin-change/description/">Leetcode coin change</a>
 *You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
 *
 * Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
 *
 * You may assume that you have an infinite number of each kind of coin.
 */
public class CoinChange {
  public static int coinChange(int[] coins, int amount) {
    int[] minCoins = new int[amount + 1];
    Arrays.fill(minCoins, amount + 1);
    minCoins[0] = 0; //At index 0, I put 0 as a value, because to make up amount 0, we don't need any coins, so we can start from index 1(= amount 1)
    System.out.println("minCoins : " + Arrays.toString(minCoins));

    //formula: amount = current amount - current value of coin
    for (int i = 1; i <= amount; i++){
      for (int j = 0; j < coins.length; j++){
        var currentAmount = i;
        var currentCoinValue = coins[j];
        var totalAmount = currentAmount - currentCoinValue;
        if (totalAmount >= 0){
          minCoins[i] = Math.min(minCoins[i], 1 + minCoins[totalAmount]);
        }

      }

    }


    return minCoins[amount] != amount + 1 ? minCoins[amount] : -1;
  }

  public static void main(String[] args) {
    int output = coinChange(new int[] {1, 2, 5}, 11);
    System.out.println(output);
    assert output == 3;

    int output2 = coinChange(new int[] {2}, 3);
    System.out.println(output2);
    assert output2 == -1;

    int output3 = coinChange(new int[] {1}, 0);
    System.out.println(output3);
    assert output3 == 0;
  }
}
