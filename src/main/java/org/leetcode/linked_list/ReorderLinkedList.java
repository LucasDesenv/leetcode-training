package org.leetcode.linked_list;

public class ReorderLinkedList {
  public static void main(String[] args) {

  }

  public ListNode reorderList(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }

    ListNode slow = head;
    ListNode fast = head;

    while (fast != null && fast.next != null){
      slow = slow.next;
      fast = fast.next.next;
    }

    return null;

  }

}