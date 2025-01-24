package org.leetcode.sliding_window;

/**
 * You are given an integer array prices where prices[i] is the price of NeetCoin on the ith day.
 *
 * You may choose a single day to buy one NeetCoin and choose a different day in the future to sell it.
 *
 * Return the maximum profit you can achieve. You may choose to not make any transactions, in which case the profit would be 0.
 */
public class BestTimeToBuyAndSellStock {
  public static void main(String[] args) {

    System.out.println("Should be 6 : " + maxProfit(new int[]{10,1,5,6,7,1}));
    System.out.println("Should be 0 : " + maxProfit(new int[]{10,8,7,5,2}));
  }

  public static int maxProfit(int[] prices) {

    int maxProfit = 0;

    for (int i = 0; i < prices.length; i++) {
      int possibleBuy = prices[i];

      if (i + 1 == prices.length) {
        break;
      }

      for (int j = i+1; j < prices.length; j++) {
        int sellingPrice = prices[j];
        if (possibleBuy < sellingPrice) {
          int possibleProfit = sellingPrice - possibleBuy;
          maxProfit = Math.max(maxProfit, possibleProfit);
        }

      }
    }

    return maxProfit;
  }
}
