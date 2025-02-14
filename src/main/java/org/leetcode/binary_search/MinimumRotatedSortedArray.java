package org.leetcode.binary_search;

/**
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/
 */
public class MinimumRotatedSortedArray {
  public static void main(String[] args) {
    System.out.println(findMin(new int[]{3, 4, 1, 2}));
    System.out.println(findMin(new int[]{2, 1}));
  }

  public static int findMin(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    int res = nums[0];

    int left = 0, right = nums.length - 1;

    while (left <= right) {

      if (nums[left] < nums[right]) {
        return Math.min(res, nums[left]);
      }

      int mid = left + (right - left) / 2;
      res = Math.min(res, nums[mid]);

      if (nums[mid] >= nums[left]){
        left = mid + 1;
      } else{
        right = mid - 1;
      }

    }

    return res;


  }
}
