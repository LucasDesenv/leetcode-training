package org.leetcode.binary_search;

public class Sqrt {
  public static void main(String[] args) {
    System.out.println(sqrt(8));
    System.out.println(sqrt(64));
    System.out.println(sqrt(2147483647));
  }

  public static int sqrt(int x) {
    if (x == 0) return 0;
    if (x == 1) return 1;

    int low = 1, high = x, result = 0;
    while (low <= high){
      int mid = low + (high - low) / 2;
      int possibleCandidate = x / mid;

      if (mid <= possibleCandidate){
        result = mid;
        low = mid + 1;
      }else {
        high = mid - 1;
      }
    }

    return result;
  }

  private static int search() {
    return 0;
  }
}
