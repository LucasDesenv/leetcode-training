package org.leetcode.linked_list;

/**
 * https://leetcode.com/problems/merge-two-sorted-lists/
 */
public class MergeLinkedList {
  public static void main(String[] args) {
    ListNode l1 = new ListNode(1);
    l1.next = new ListNode(2);

    ListNode l2 = new ListNode(1);
    l2.next = new ListNode(3);
    System.out.println(mergeTwoLists(l1, l2));

  }

  public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    ListNode head = new ListNode(Integer.MIN_VALUE);
    ListNode cur = head;


    while (list1 != null && list2 != null) {
      if (list1.val < list2.val) {
        cur.next = list1;
        list1 = list1.next;
      }else{
        cur.next = list2;
        list2 = list2.next;
      }
      cur = cur.next;
    }

    if (list1 != null) {
      cur.next = list1;
    }else {
      cur.next = list2;
    }

    return head.next;
  }
}
