package org.leetcode.array_hashtables;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/valid-anagram/description/">Valid Anagram</a>
 */
public class ValidAnagram {

  public static void main(String[] args) {
    System.out.println("should be true: " + isAnagram("anagram", "nagaram"));
    System.out.println("should be false: " + isAnagram("rat", "car"));
  }

  public static boolean isAnagram(String s, String t) { //O(n + m), where n is the length of 's' and m the length of 't'
    if (s.length() != t.length()) {
      return false;
    }

    s = s.toLowerCase();
    t = t.toLowerCase();

    Map<Character, Integer> firstWord = new HashMap<>();
    Map<Character, Integer> secondWord = new HashMap<>();

    char[] charArray = s.toCharArray();

    for (int i = 0; i < charArray.length; i++) {
      firstWord.put(s.charAt(i), firstWord.getOrDefault(s.charAt(i), 1) + 1);
      secondWord.put(t.charAt(i), secondWord.getOrDefault(t.charAt(i), 1) + 1);
    }


//    for (int i = 0; i < charArray.length; i++) {
//      String s1 = String.valueOf(charArray[i]);
//      if (!t.contains(s1)){
//        return false;
//      }
//      t =  t.replaceFirst(s1, "");
//    }

    return firstWord.equals(secondWord);

  }
}
