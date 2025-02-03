package org.leetcode.binary_search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/find-target-indices-after-sorting-array
 */
public class FindTargetIndices {
  public static void main(String[] args) {
    System.out.println("Should be 1,2: " + targetIndices(new int[]{1,2,5,2,3}, 2));
    System.out.println("Should be 4: " + targetIndices(new int[]{1,2,5,2,3}, 5));
  }

  public static List<Integer> targetIndices(int[] nums, int target) {
    Arrays.sort(nums); //o (n log m)

    List<Integer> res = new ArrayList<>();
    boolean found = false;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == target) {
        res.add(i);
        found = true;
      }else if (found){
        break;
      }
    }


    return res;
  }
}
