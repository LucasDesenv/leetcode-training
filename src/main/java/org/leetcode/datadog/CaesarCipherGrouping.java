package org.leetcode.datadog;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Question 1:
 * Caesar Cipher Encrpytion
 * You are given a list of string, group them if they are same after using Ceaser Cipher Encrpytion.
 * Definition of "same", "abc" can right shift 1, get "bcd", here you can shift as many time as you want, the string will be considered as same.
 *
 *
 * Example:
 *
 *
 * Input: ["abc", "bcd", "acd", "dfg"]
 * Output: [["abc", "bcd"], ["acd", "dfg"]]
 */
public class CaesarCipherGrouping {

  public static void main(String[] args) {
    String[] input = {"abc", "bcd", "acd", "dfg"};
    List<List<String>> result = groupCaesarCipher(input);
    System.out.println(result);

    assert result.toString().equals("[[abc, bcd], [acd, dfg]]");
  }

  private static List<List<String>> groupCaesarCipher(String[] input) {
    Map<String, List<String>> ciphersGroup = new HashMap<>();

    for (String text : input) {
      StringBuilder cipherValue = new StringBuilder();
      for (int i = 1; i < text.length(); i++) {
        cipherValue.append(text.charAt(i) - text.charAt(i-1)).append(",");
      }

      String cipherValueString = cipherValue.toString();
      ciphersGroup.putIfAbsent(cipherValueString, new ArrayList<>());
      ciphersGroup.get(cipherValueString).add(text);
    }

    return new ArrayList<>(ciphersGroup.values());
  }
}
