package org.leetcode.linked_list;

public class ListNode {
  int val;
  ListNode next;

  ListNode(){

  }

  ListNode(int x) {
    val = x;
  }

  ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }

  @Override
  public String toString() {
    return "ListNode{" + "val=" + val + '}';
  }
}
