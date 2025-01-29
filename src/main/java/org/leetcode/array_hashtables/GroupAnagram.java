package org.leetcode.array_hashtables;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/group-anagrams/description/">Group anagram medium</a>
 */
public class GroupAnagram {

  public static void main(String[] args) {
    System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
  }
  public static List<List<String>> groupAnagrams(String[] strs) { //o(m * n log n)
    Map<String, List<String>> map = new HashMap<>();

    for (String str : strs) {
      char[] charArray = str.toCharArray();
      Arrays.sort(charArray);
      String wordSorted = new String(charArray);
      map.putIfAbsent(wordSorted, new ArrayList<>());
      map.get(wordSorted).add(str);
    }

    return new ArrayList<>(map.values());
  }

}
