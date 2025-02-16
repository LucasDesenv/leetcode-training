package org.leetcode.linked_list;

/**
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
 */
public class RemoveNodeFromLinkedList {
  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(5);
    head.next.next.next.next.next = new ListNode(6);
    ListNode listNode = removeNthFromEnd(head, 2);
    System.out.println(listNode);


  }

  public static ListNode removeSpecificNode(ListNode head, int value) {
    if (head == null || head.next == null) {
      return head;
    }

    if (head.val == value) {
      return head.next;
    }

    ListNode current = head;

    while (current.next != null){
      if (current.next.val == value){
        current.next = current.next.next;
        break;
      }
      current = current.next;
    }

    return head;
  }
  public static ListNode removeNthFromEnd(ListNode head, int n) {
    if (head == null){
      return null;
    }

    ListNode dummy = new ListNode(0);
    ListNode current = dummy;

    ListNode tempHead = head;

    int count = 0;
    int length = 0;

    while (tempHead != null){
      tempHead = tempHead.next;
      length++;
    }

    while (head != null){
      boolean isNthFromEnd = length - count == n;
      if (isNthFromEnd){
        head = head.next;
      }

      current.next = head;
      current = current.next;
      head = head == null ? null : head.next;

      count++;

    }

    return dummy.next;

  }
}
