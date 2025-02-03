package org.leetcode.binary_search;

public class KthPositiveNumber {
  public static void main(String[] args) {
    System.out.println("Should be 6 : " + findKthPositive(new int[]{1,2,3,4}, 2));
    System.out.println("Should be 9 : " + findKthPositive(new int[]{2,3,4,7,11}, 5));

  }
  public static int findKthPositive(int[] nums, int k) {
   int low = 0;
   int high = nums.length - 1;
   while (low <= high) {
     int mid = (low + high) / 2;
     int missing = nums[mid] - (mid + 1);
     if (missing < k){
       low = mid + 1;
     }else {
       high = mid - 1;
     }
   }

   return k + high + 1;
  }
}
