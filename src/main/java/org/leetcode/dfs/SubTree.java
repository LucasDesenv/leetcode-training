package org.leetcode.dfs;

public class SubTree {
  public static void main(String[] args) {

  }

  public boolean isSubTree(TreeNode root, TreeNode subRoot) {
    if (root == null) {
      return false;
    }

    if (subRoot == null) {
      return true;
    }

    if (isSameTree(root, subRoot)){
      return true;
    }

    return isSubTree(root.left, subRoot) || isSubTree(root.right, subRoot);

  }

  public boolean isSameTree(TreeNode s, TreeNode t) {
    if (s == null && t == null) {
      return true;
    }
    if (s == null || t == null) {
      return false;
    }
    if (s.val != t.val) {
      return false;
    }

    return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);

  }
}
