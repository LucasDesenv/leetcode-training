package org.leetcode.binary_search;

/**
 * https://leetcode.com/problems/search-insert-position/?envType=problem-list-v2&envId=binary-search
 */
public class SearchInsertPosition {
  public static void main(String[] args) {
    System.out.println("Should be 5: " + searchInsert(new int[]{2,5,8,12,16,23,38,56,72,91}, 23));
    System.out.println("Should be 1: " + searchInsert(new int[]{1,3,5, 6}, 2));
    System.out.println("Should be 0: " + searchInsert(new int[]{1,3,5, 6}, 0));
    System.out.println("Should be 4: " + searchInsert(new int[]{1,3,5, 6}, 9));
  }

  public static int searchInsert(int[] nums, int target){

    int low = 0;
    int high = nums.length - 1;
    while (low <= high){
      int mid = (high - low) / 2 + low; //4
      if (nums[mid] == target){
        return mid;
      }
      if (target > nums[mid]){
        low = mid + 1; //move to the right
      }else{
        high = mid - 1; //move to the left
      }
    }
    return low;
  }
}
