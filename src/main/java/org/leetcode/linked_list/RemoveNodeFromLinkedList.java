package org.leetcode.linked_list;

import java.util.HashSet;
import java.util.Set;

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
    ListNode listNode1 = new ListNode(1);
    listNode1.next = new ListNode(1);
    listNode1.next.next = new ListNode(1);
    listNode1.next.next.next = new ListNode(3);
    listNode1.next.next.next.next = new ListNode(3);
    listNode1.next.next.next.next.next = new ListNode(4);
    listNode1.next.next.next.next.next.next = new ListNode(9);
    ListNode x = deleteDuplicates_V2(listNode1);
    System.out.println(x);


  }

  /**
   * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/submissions/1550764882/?envType=problem-list-v2&envId=linked-list
   * @param head
   * @return
   */
  public static ListNode deleteDuplicates_V2(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }

    ListNode dummy = new ListNode(0, head);
    ListNode prev = dummy;
    ListNode cur = head;

    while (cur != null) {
      if (cur.next != null && cur.val == cur.next.val) {
        int duplicatedValue = cur.val;
        while (cur != null && duplicatedValue == cur.val) {
          cur = cur.next; //keep skipping the duplicated values
        }
        prev.next = cur; //once a unique value is found, store it.
      }else{
        prev = cur; //it means the current and next are different, so we can move safely.
        cur = cur.next;
      }
    }

    return dummy.next;
  }

  public static ListNode deleteDuplicates(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }

    ListNode current = head;


    while (current != null && current.next != null){
      if (current.val == current.next.val) {
        current.next = current.next.next;
      }else {
        current = current.next;
      }
    }

    return head;
  }


  public static ListNode removeElements(ListNode head, int val) {
    //First cover the corner case where we have all elements equal to val. E.g.: 7, 7, 7, 7
    while (head != null && head.val == val){
      head = head.next;
    }

    if (head == null){
      return head;
    }

    ListNode current = head;
    while (current != null && current.next != null){
      if (current.next.val == val){ //check if the next is the one to be deleted
        current.next = current.next.next; //if yes, skip it by getting the next of the next.
      }else current = current.next; //otherwise keep iterating.
    }

    return head;

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
