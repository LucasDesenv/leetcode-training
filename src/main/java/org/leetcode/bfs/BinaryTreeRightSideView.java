package org.leetcode.bfs;

import org.leetcode.dfs.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/binary-tree-level-order-traversal/description/
 */
public class BinaryTreeRightSideView {
  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.left.right = new TreeNode(5);

    root.right = new TreeNode(3);
    root.right.right = new TreeNode(4);

    rightSideView(root);
  }

  public static List<Integer> rightSideView(TreeNode root) {
    if (root == null) {
      return new ArrayList<>();
    }

    List<Integer> res = new ArrayList<>();
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);

    while (!queue.isEmpty()) {
      int size = queue.size();
      TreeNode rightNode = null;

      for (int i = 0; i < size; i++) {
        TreeNode node = queue.poll();
        if (node != null){
          rightNode = node;
          queue.offer(node.left);
          queue.offer(node.right);
        }
      }

      if (rightNode != null) {
        res.add(rightNode.val);
      }
    }

    return res;

  }
}
