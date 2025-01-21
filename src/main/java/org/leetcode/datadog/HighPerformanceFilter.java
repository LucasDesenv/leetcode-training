package org.leetcode.datadog;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * There is a stream that has coming tags and also has a list of keywords, design a high performance filter to output these keywords remaining tags.
 * For example: given stream ['apple, facebook, google', 'banana, facebook', 'facebook, google, tesla', 'intuit, google, facebook'],
 * if the keyword is ['apple'] the output should ['facebook', 'google'] because only 'apple, facebook, google' has apple.
 * Similarly if the keyword is ['facebook', 'google'], the output should ['apple', 'tesla', 'intuit'].
 *
 * The output can be in any order and can be put into a single list/array.
 */
public class HighPerformanceFilter {

  private static List<String> tags = new ArrayList<>();
  private static Map<String, Set<Integer>> tagsIndexes = new HashMap<>();


  public static void main(String[] args) {

    addTags("apple, facebook, google");
    addTags("banana, facebook");
    addTags("facebook, google, tesla");
    addTags("intuit, google, facebook");

    System.out.println(searchTags(Arrays.asList("apple")));
    System.out.println(searchTagsV2(Arrays.asList("facebook", "google"))); //[apple, tesla, intuit]
  }

  /**
   * <a href="https://www.cockroachlabs.com/blog/inverted-indexes/">Inverted index approach</a>
   * @param tag
   */
  private static void addTags(String tag) { // "apple, facebook, google"
    int index = HighPerformanceFilter.tags.size();
    for (String singleTag : tag.split(",")){
      singleTag = singleTag.trim().toLowerCase();

      tagsIndexes.putIfAbsent(singleTag, new HashSet<>());
      tagsIndexes.get(singleTag).add(index);
    }

    tags.add(tag);

  }


  private static Set<String> searchTagsV2(List<String> search) {

    Map<Integer, Integer> counterMap = new HashMap<>();

    for (String tag : search){
      Set<Integer> tagsIndexesFound = tagsIndexes.getOrDefault(tag, new HashSet<>());
      for (int documentIndex : tagsIndexesFound){
        counterMap.put(documentIndex, counterMap.getOrDefault(documentIndex, 0) + 1);
      }
    }
    Set<String> result = new HashSet<>();
    for (int key : counterMap.keySet()){
      if (counterMap.get(key) == search.size()){
        String[] split = tags.get(key).split(", ");
        result.addAll(Arrays.asList(split));
      }
    }

    for (String s : search) {
      result.remove(s);
    }

    return result;
  }

  private static Set<String> searchTags(List<String> search) { //O (n^2)
    Set<String> foundTags = new HashSet<>();
    for (String tag : tags) {
      boolean found = false;

      for (String tagToSearch : search) { //facebook + google
        if (tag.contains(tagToSearch)) {
          found = true;
          tag = tag.replace(tagToSearch, "");
          continue;
        }
        found = false;
        break;
      }

      if (found) {
        foundTags.add(tag);
      }
    }

    return foundTags;
  }

}
