package org.leetcode.dfs;

/**
 * https://leetcode.com/problems/validate-binary-search-tree/description/
 */
public class ValidBinarySearch {
  public static void main(String[] args) {

    TreeNode root = new TreeNode(2);
    root.left = new TreeNode(1);
    root.right = new TreeNode(3);
    root.right.left = new TreeNode(2);
    root.right.right = new TreeNode(4);

    isValidBST(root);
  }

  public static boolean isValidBST(TreeNode root) {
    return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
  }

  public static boolean isValid(TreeNode root, long left, long right) {
    if (root == null) {
      return true;
    }

    //left should be less than current node
    //right should be greater than current node
    //both left & right are BST

    if (!(left < root.val && right > root.val)){
      return false;
    }

    return isValid(root.left, left, root.val) && isValid(root.right, root.val, right);
  }
}
