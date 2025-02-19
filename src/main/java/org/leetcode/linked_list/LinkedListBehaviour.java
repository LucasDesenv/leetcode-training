package org.leetcode.linked_list;

public class LinkedListBehaviour {

  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
//    ListNode listNode = removeNthFromEnd(head, 2);
//    System.out.println(listNode);
    ListNode listNode2 = removeNthFromEnd(head.next.next.next, 1);
  }

  /**
   * Typical reverse of a LinkedList.
   *
   * Always store the next ones to avoid losing the pointers.
   * Then simply move the pointers (current.next, previous, current + nextPointers)
   *
   * @param head
   * @return
   */
  public ListNode reverseList(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }

    ListNode previous = null;
    ListNode current = head;

    while (current != null){
      ListNode nextPointers = current.next;
      current.next = previous;
      previous = current;
      current = nextPointers;
    }

    return previous;

  }

  /**
   * Here the logic is to iterate through the LinkedList as usual, but iterate through both of them at same time.
   * Check the value between both of them and assign to the current.
   * @param list1
   * @param list2
   * @return
   */
  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

    ListNode dummyHead = new ListNode(0);
    ListNode current = dummyHead;

    while (list1 != null && list2 != null) {
      if (list1.val < list2.val) {
        current.next = list1;
        list1 = list1.next;
      }else {
        current.next = list2;
        list2 = list2.next;
      }

      current = current.next;

    }

    if (list1 != null){
      current.next = list1;
    } else {
      current.next = list2;
    }

    return dummyHead.next;

  }

  /**
   * A cycle means when one node points to a previous node.
   * E.g.: 1 → 2 → 3 → 4 → 2 the last node 4 points back to the 2.
   *
   * Use the slow-fast technique.
   *
   * @param head
   * @return
   */
  public boolean hasCycle(ListNode head) {
    if (head == null || head.next == null) {
      return false;
    }

    ListNode slow = head;
    ListNode fast = head;

    while (fast != null && fast.next != null){
      fast = fast.next.next;
      slow = slow.next;
      if (slow.val == fast.val) {
        return true;
      }
    }

    return false;
  }

  /**
   * It is basically a removal with a condition.
   * The condition is: remove the nth node from the end.
   * E.g.: Input: head = [1,2,3,4], n = 2
   * This means we need to remove the 2nd node from the last, which will be the node 3 -> 1, 2, 4
   *
   * @param head
   * @param n
   * @return
   */
  public static ListNode removeNthFromEnd(ListNode head, int n) {
    if (head == null){
      return null;
    }

    ListNode dummy = head;
    int length = 0;
    while (dummy != null){
      dummy = dummy.next;
      length++;
    }


    int indexToRemove = length - n;

    if (indexToRemove == 0){
      return head.next;
    }

    ListNode current = head;
    int count = 0;
    while (current != null){
      if (++count == indexToRemove){
        current.next = current.next.next;
        break;
      }
      current = current.next;
    }

    return head;

  }

  }
