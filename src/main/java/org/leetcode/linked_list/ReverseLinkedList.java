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
    System.out.println(reverseList(head));
  }
  public static ListNode reverseList(ListNode head) {
    ListNode current = head;
    ListNode previous = null;

    while (current != null) {
      ListNode temp = current.next;
      current.next = previous;
      previous = current;
      current = temp;
    }

    /**
     * is my head/current null ? head : continue
     *
     * 0, 1, 2, 3
     *
     * var previous = head; //0
     * var current = head.current; //1
     *
     * head = current; //[1, 1, 2, 3]
     * head.current = previous; //[1, 0, 2, 3]
     *
     *
     *
     *
     *
     */

    return previous;
  }
}
