package org.leetcode.linked_list;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/linked-list-cycle/
 */
public class LinkedListCycle {
  public static void main(String[] args) {
    ListNode head = new ListNode(3);
    head.next = new ListNode(2);
    head.next.next = new ListNode(0);
    head.next.next.next = new ListNode(-4);
  }

  public static boolean hasCycle_UsingTwoPointers(ListNode head) {
    if (head == null || head.next == null) {
      return false;
    }

    ListNode slow = head;
    ListNode fast = head;
    while (fast !=  null && fast.next != null){
      fast = fast.next.next;
      slow = slow.next;
      if (fast == slow) {
        return true;
      }
    }

    return false;
  }
  public static boolean hasCycle_UsingSet(ListNode head) {
    if (head == null || head.next == null) {
      return false;
    }
    ListNode next = head.next;

    Set<ListNode> visited = new HashSet<>();
    visited.add(head);

    while (next != null){
      if (!visited.add(next)){
        return true;
      }
      next = next.next;
    }

    return false;
  }

}
