package org.leetcode.dfs;

/**
 * <a href="https://leetcode.com/problems/same-tree/?envType=problem-list-v2">Same tree DFS</a>
 */
public class SameTree {
  public boolean isSameTree(TreeNode p, TreeNode q) { //o(n)
    if (p == null && q == null) {
      return true;
    }
    if (p == null || q == null) {
      return false;
    }

    if (p.val != q.val) {
      return false;
    }

    return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
  }

  }

