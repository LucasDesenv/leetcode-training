package org.leetcode.binary_search;

/**
 * <a href="https://leetcode.com/problems/minimum-common-value">Minimum Common Value</a>
 */
public class MinimumCommonValue {
  public static void main(String[] args) {
    System.out.println("Should be 2: " + getCommon_enhanced(new int[]{1,2,3}, new int[]{2,4}));
    System.out.println("Should be 2: " + getCommon_enhanced(new int[]{1,2,3,6}, new int[]{2,3,4,5}));
    System.out.println("Should be -1: " + getCommon_enhanced(new int[]{1,2,3,6}, new int[]{4,5,7}));

  }
  public static int getCommon_enhanced(int[] nums1, int[] nums2) {

    int i = 0, j = 0;

    while (i < nums1.length && j < nums2.length){
      if (nums1[i] == nums2[j]){
        return nums1[i];
      }

      if (nums1[i] < nums2[j]){
        i++;
      }else {
        j++;
      }

    }

    return -1;

  }
  public static int getCommon_1(int[] nums1, int[] nums2) {
    for (int i = 0; i < nums1.length; i++) {
      if (exists(nums2, nums1[i])){
        return nums1[i];
      }
    }
    return -1;
  }

  private static boolean exists(int[] nums2, int target) {
    int low = 0;
    int high = nums2.length - 1;

    while (low <= high) {
      int mid = low +(high - low) / 2;
      if (target == nums2[mid]) {
        return true;
      }
      if (target < nums2[mid]) {
        high = mid - 1;
      }
      else if (target > nums2[mid]) {
        low = mid + 1;
      }
    }
    return false;
  }
}
