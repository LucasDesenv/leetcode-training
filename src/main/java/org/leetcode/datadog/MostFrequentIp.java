package org.leetcode.datadog;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * From a logfile show the top-n most frequently occurring IPs with their count
 * <a href="https://leetcode.com/discuss/interview-question/949160/goldman-sachs-phone-most-frequent-ip-address-from-the-logs">Leetcode</a>
 *
 * Given a list of logs with IP addresses in the following format.
 * lines = ["10.0.0.1 - GET 2020-08-24", "10.0.0.1 - GET 2020-08-24", "10.0.0.2 - GET 2020-08-20"]
 *
 *
 * Return the most frequent IP address from the logs. The returned IP address value must be in a string format.
 * If multiple IP addresses have the count equal to max count, then return the address as a comma-separated string with IP addresses in sorted order.
 *
 */
public class MostFrequentIp {

  public static void main(String[] args) {
    List<String> ips_1 = Arrays.asList("10.0.0.1 - GET 2020-08-24", "10.0.0.1 - GET 2020-08-24",
      "10.0.0.2 - GET 2020-08-20");

    System.out.println(mostFrequentIps_MaxHeap(ips_1));
    System.out.println(mostFrequentIps_HashMap(ips_1));


    List<String> ips_2 = Arrays.asList("10.0.0.1 - GET 2020-08-24", "10.0.0.1 - GET 2020-08-24",
      "10.0.0.2 - GET 2020-08-20", "10.0.0.2 - GET 2020-08-20", "10.0.0.3 - GET 2020-08-20");

    System.out.println(mostFrequentIps_MaxHeap(ips_2));
    System.out.println(mostFrequentIps_HashMap(ips_2));


  }

  private static List<String> mostFrequentIps_HashMap(List<String> logs) { //O(n + m log m)
    List<String> ips = logs.stream().map(s -> s.split(" ")).map(ip -> ip[0]).toList(); //O(n)

    Map<String, Integer> ipFrequency = new HashMap<>();

    for (String ip :ips){ //O(n)
      ipFrequency.put(ip, ipFrequency.getOrDefault(ip, 0) + 1);
    }

    Integer max = Integer.MIN_VALUE;

    for (Map.Entry<String, Integer> m : ipFrequency.entrySet()){ //O(n)
      if (m.getValue() >= max){
        max = m.getValue();
      }
    }

    final Integer highestFound = max;


    //Filtering and sorting: O(n + m log m), where m is the number of most frequent IPs.
    return ipFrequency.entrySet().stream().filter(b -> b.getValue().equals(highestFound))
      .map(Map.Entry::getKey)
      .sorted((a,b) -> a.compareTo(b))
      .toList();
  }

  private static List<String> mostFrequentIps_MaxHeap(List<String> logs) { //Time Complexity: O(n + m log m) (due to sorting tied IPs).
    List<String> ips = logs.stream().map(s -> s.split(" ")).map(ip -> ip[0]).toList(); //O(n)

    Map<String, Integer> ipFrequency = new HashMap<>();

    for (String ip :ips){ //O(n)
      ipFrequency.put(ip, ipFrequency.getOrDefault(ip, 0) + 1);
    }


    PriorityQueue<Map.Entry<String, Integer>> maxHeap = new PriorityQueue<>(
      (a, b) -> b.getValue().equals(a.getValue()) ? a.getKey().compareTo(b.getKey()) : b.getValue() - a.getValue()
    );

    for (Map.Entry<String, Integer> f :  ipFrequency.entrySet()){
      maxHeap.offer(f); //O(m * log m) Inserting m entries (unique IPs) into the PriorityQueue takes O(m * log m), where m is the number of unique IPs.
    }

    Map.Entry<String, Integer> highest = maxHeap.poll();
    List<String> mostFrequentIps = new ArrayList<>();
    mostFrequentIps.add(highest.getKey());

    for (Map.Entry<String, Integer> f : maxHeap){ //O(m)
      if (f.getValue() < highest.getValue()){
        break;
      }
      mostFrequentIps.add(f.getKey());
    }

    return mostFrequentIps;
  }
}
