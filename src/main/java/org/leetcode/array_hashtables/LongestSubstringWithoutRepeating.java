package org.leetcode.array_hashtables;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 */
public class LongestSubstringWithoutRepeating {
  public static void main(String[] args) {
    System.out.println("Should be 3 : " + lengthOfLongestSubstring_bruteForce("abcabcbb"));
    System.out.println("Should be 1 : " + lengthOfLongestSubstring_bruteForce("bbbbb"));
    System.out.println("Should be 3 : " + lengthOfLongestSubstring_bruteForce("pwwkew"));
    System.out.println("Should be 5 : " + lengthOfLongestSubstring_bruteForce("abccjklm"));
    System.out.println("Should be 3 : " + lengthOfLongestSubstring_bruteForce("dvdf"));
  }
  public static int lengthOfLongestSubstring_slidingWindow(String s) { // o(n)
    if (s == null || s.isEmpty()) {
      return 0;
    }
    int maxLength = Integer.MIN_VALUE;
    int left = 0;

    Set<Character> nonRepeatingChars = new HashSet<>();
    for (int i = 0; i < s.length(); i++) {
      while (nonRepeatingChars.contains(s.charAt(i))) {
        nonRepeatingChars.remove(s.charAt(left));
        left++;
      }

      nonRepeatingChars.add(s.charAt(i));
      maxLength = Math.max(maxLength, i - left + 1);
    }

    return maxLength;

  }

  public static int lengthOfLongestSubstring_bruteForce(String s) { //o (n * m)
    if (s == null || s.isEmpty()) {
      return 0;
    }

    Set<Character> nonRepeatingChars = new HashSet<>();
    Integer max = Integer.MIN_VALUE;

    for (int i = 0; i < s.length(); i++) {
      nonRepeatingChars.clear();
      nonRepeatingChars.add(s.charAt(i));
      for (int j = i + 1; j < s.length(); j++) {
        if (!nonRepeatingChars.add(s.charAt(j))) {
          max = Math.max(max, nonRepeatingChars.size());
          break;
        }
      }
      max = Math.max(max, nonRepeatingChars.size());
    }

    return Math.max(max, nonRepeatingChars.size());
  }
}
