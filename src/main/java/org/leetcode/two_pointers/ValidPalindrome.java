package org.leetcode.two_pointers;

import java.util.Arrays;
import java.util.List;

/**
 * Given a string s, return true if it is a palindrome, otherwise return false.
 *
 * A palindrome is a string that reads the same forward and backward. It is also case-insensitive and ignores all non-alphanumeric characters.
 */
public class ValidPalindrome {

  public static void main(String[] args) {
    System.out.println("Should be true: " + isPalindrome("Was it a car or a cat I saw?"));
    System.out.println("Should be true: " + isPalindrome("Was saw?"));
    System.out.println("Should be false: " + isPalindrome("tab a cat"));
  }

  public static boolean isPalindrome(String s) {
    if (s == null || s.trim().length() == 0) {
      return true;
    }

    s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

    char[] chars = s.toCharArray();

    int last = chars.length - 1;

    for (int i = 0; i < chars.length; i++){
      if (chars[i] != chars[last--]){
        return false;
      }
    }

    return true;
  }
}
