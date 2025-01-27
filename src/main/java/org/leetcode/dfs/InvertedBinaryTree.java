package org.leetcode.dfs;

/**
 * https://leetcode.com/problems/invert-binary-tree/
 */
public class InvertedBinaryTree {

  public static void main(String[] args) {
    TreeNode root = new TreeNode(4);

    root.right = new TreeNode(7);
    root.right.left = new TreeNode(6);
    root.right.right = new TreeNode(9);

    root.left = new TreeNode(2);
    root.left.left = new TreeNode(1);
    root.left.right = new TreeNode(3);

    TreeNode inverted = invertTree(root);
    System.out.println(inverted);

  }

  public static TreeNode invertTree(TreeNode root) {//O(n)
    if (root == null) {
      return null;
    }

    if (root.left == null && root.right == null) {
      return root;
    }

    TreeNode tempLeft = root.left;

    root.left = root.right;
    root.right = tempLeft;

    invertTree(root.left);
    invertTree(root.right);

    return root;
  }

}
