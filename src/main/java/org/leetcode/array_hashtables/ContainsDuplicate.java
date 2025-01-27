package org.leetcode.array_hashtables;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/contains-duplicate/description/">Contains Duplicate</a>
 */
public class ContainsDuplicate {
  public static void main(String[] args) {
    System.out.println("should be true: " + hasDuplicate(new int[]{1, 2, 3, 1}));
    System.out.println("should be false: " + hasDuplicate(new int[]{1, 2, 3, 4}));
  }
  public static boolean hasDuplicate(int[] nums) {
    if (nums == null || nums.length <= 1) {
      return false;
    }

    Set<Integer> uniqueNumbers = new HashSet<>();
    for (int i = 0; i < nums.length; i++){
      if (!uniqueNumbers.add(nums[i])){
        return true;
      }
    }

    return false;
  }
}
