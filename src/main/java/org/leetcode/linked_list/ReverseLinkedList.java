package org.leetcode.linked_list;

/**
 * <a href="https://leetcode.com/problems/reverse-linked-list/description/">Reverse LinkedList</a>
 * Given the beginning of a singly linked list head, reverse the list, and return the new beginning of the list.
 *
 * Example 1:
 *
 * Input: head = [0,1,2,3]
 *
 * Output: [3,2,1,0]
 *
 * Example 2:
 *
 * Input: head = []
 *
 * Output: []
 *
 */
public class ReverseLinkedList {
  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
//    head.next.next = new ListNode(3);
//    head.next.next.next = new ListNode(4);
    ListNode x = reverseList(head);
    System.out.println(x);
  }
  public static ListNode reverseList(ListNode head) {

    ListNode prev = null;
    ListNode curr = head;

    while (curr != null) {
      ListNode temp = curr.next;
      curr.next = prev;
      prev = curr;
      curr = temp;
    }

    return prev;
  }
}
