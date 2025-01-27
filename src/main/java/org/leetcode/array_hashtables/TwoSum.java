package org.leetcode.array_hashtables;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/two-sum/description/">Arrays & Hashtable</a>
 */
public class TwoSum {
  public int[] twoSum(int[] nums, int target) {

    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++){
      var difference = target - nums[i]; //7-3=4, 7-4=3

      if (map.containsKey(difference)){ //contains 3?
        return new int[]{map.get(difference), i};
      }

      //[3, 0]
      map.put(nums[i], i);


//      for (int j = i + 1; j < nums.length; j++){
//        if (nums[i] + nums[j] == target){
//          result[0] = i;
//          result[1] = j;
//          break;
//        }
//
//      }
    }

    return new int[]{};
  }
}
