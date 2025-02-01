package org.leetcode.binary_search;

public class MaximumCountNumbers {
  public static void main(String[] args) {
    System.out.println("Should be 3: " + maxCount(new int[]{-2,-1,-1,1,2,3}));
    System.out.println("Should be 4: " + maxCount(new int[]{5,20,66,1314}));
  }
  public static int maxCount(int[] nums) {

    int positiveCount = nums.length - search(nums, 1);
    int negativeCount = search(nums, 0);

    return Math.max(negativeCount, positiveCount);
  }


  public static int search(int[] nums, int target){
    int low = 0;
    int high = nums.length ;
    while (low < high){
      int mid = (high - low) / 2 + low;
      if (nums[mid] < target){
        low = mid + 1;
      }else{
        high = mid;
      }
    }
    return low;
  }
}
