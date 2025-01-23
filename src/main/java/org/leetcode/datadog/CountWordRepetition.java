package org.leetcode.datadog;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Count Word Repetitions in a Paragraph: Calculate the total number of repetitions for each word in a paragraph.
 *     1. Input: `"The quick brown fox jumps over the lazy dog. The dog barked."`
 *     2. Output: `{ "the": 3, "quick": 1, "brown": 1, "fox": 1, "jumps": 1, "over": 1, "lazy": 1, "dog": 2, "barked": 1 }`
 */
public class CountWordRepetition {
  public static void main(String[] args) {
    String paragraph = "The quick brown fox jumps over the lazy dog. The dog barked.";
    System.out.println(countRepeatedWords(paragraph));
  }

  private static Map<String, Integer> countRepeatedWords(String paragraph) { //O(n)
    String[] words = paragraph.split(" ");
    Map<String, Integer> counter = new LinkedHashMap<>(); //LinkedHashMap to keep the order of insertion

    for (String word : words){
      String normalizedWord = word.toLowerCase();
      counter.put(normalizedWord, counter.getOrDefault(normalizedWord, 0) + 1); //counting
    }

    return counter;
  }
}
