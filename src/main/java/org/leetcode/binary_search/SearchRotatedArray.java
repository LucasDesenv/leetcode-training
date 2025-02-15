package org.leetcode.binary_search;

/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array/description/
 */
public class SearchRotatedArray {
  public static void main(String[] args) {

    System.out.println(search(new int[]{4,5,6,7,0,1,2}, 0));
    System.out.println(search(new int[]{5, 1, 3}, 3));
  }

  public static int search(int[] nums, int target) {
    if (nums == null || nums.length == 0) {
      return -1;
    }

    //[4,5,6,7,0,1,2], 0
    int left = 0;
    int right = nums.length - 1;

    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] == target) {
        return mid;
      }

      if (nums[left] <= nums[mid]){
        if (target < nums[left] || target > nums[mid]){
          left = mid + 1;
        } else {
          right = mid - 1;
        }
      } else {
        if (target < nums[mid] || target > nums[right]){
          right = mid - 1;
        }else {
          left = mid + 1;
        }
      }

    }


    return -1;
  }
}
