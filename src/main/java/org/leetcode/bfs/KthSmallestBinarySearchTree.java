package org.leetcode.bfs;

import org.leetcode.dfs.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class KthSmallestBinarySearchTree {

  public static void main(String[] args) {
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(1);
    root.left.right = new TreeNode(2);
    root.right = new TreeNode(4);

//    System.out.println(kthSmallest_dfs(root, 1));

    TreeNode root2 = new TreeNode(2);
    root2.left = new TreeNode(1);
    root2.right = new TreeNode(3);

    System.out.println(kthSmallest_dfs(root2, 2));

  }

  public static int kthSmallest_dfs(TreeNode root, int k) {
    if (root == null) {
      return -1;
    }

    Stack<TreeNode> lifoStack = new Stack<>();
    TreeNode current = root;
    int kth = k;

    while (!lifoStack.isEmpty() || current != null) {

      while (current != null) {
        lifoStack.push(current);
        current = current.left;
      }

      current = lifoStack.pop();
      if (--kth == 0){
        return current.val;
      }

      current = current.right;
    }

    return -1;

  }
  public static int kthSmallest_bfs(TreeNode root, int k) {
    if (root == null) {
      return 0;
    }

    /**
     * A binary search tree satisfies the following constraints:
     *
     * The left subtree of every node contains only nodes with keys less than the node's key.
     * The right subtree of every node contains only nodes with keys greater than the node's key.
     * Both the left and right subtrees are also binary search trees.
     */

    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);

    List<Integer> res = new ArrayList<>();

    while (!queue.isEmpty()) {
      int size = queue.size();

      for (int i = 0; i < size; i++) {
        TreeNode node = queue.poll();
        if (node != null){
          queue.offer(node.left);
          queue.offer(node.right);
          res.add(node.val);
        }
      }
    }

    res.sort(Integer::compareTo);
    return res.get(k - 1);
  }
}
