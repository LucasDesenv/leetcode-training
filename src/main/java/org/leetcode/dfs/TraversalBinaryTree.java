package org.leetcode.dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 */
public class TraversalBinaryTree {
  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);
    root.right.left = new TreeNode(6);
    root.right.right = new TreeNode(7);
    levelOrder(root);
  }

  public static List<List<Integer>> levelOrder(TreeNode root) {
    if (root == null) {
      return new ArrayList<>();
    }

    List<List<Integer>> result = new ArrayList<>();

    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);

    while (!queue.isEmpty()) {
      List<Integer> list = new ArrayList<>();
      int size = queue.size();

      for (int i = 0; i < size; i++) {
        TreeNode node = queue.poll();
        if (node != null){
          list.add(node.val);
          queue.offer(node.left);
          queue.offer(node.right);
        }
      }

      if (!list.isEmpty()) {
        result.add(list);
      }
    }

    return result;
  }

}
