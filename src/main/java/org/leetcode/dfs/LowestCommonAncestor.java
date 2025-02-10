package org.leetcode.dfs;

/**
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/description/
 */
public class LowestCommonAncestor {
  public static void main(String[] args) {
    TreeNode root = new TreeNode(5);

    root.right = new TreeNode(8);
    root.right.left = new TreeNode(7);
    root.right.right = new TreeNode(9);

    root.left = new TreeNode(3);
    root.left.left = new TreeNode(1);
    root.left.right = new TreeNode(4);

    System.out.println(lowestCommonAncestor(root, new TreeNode(3), new TreeNode(8)));
  }

  public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null || p == null ||  q == null) return null;

    if (Math.max(p.val, q.val) < root.val){ //it means I need to go to the left, because I want the lowest.
      return lowestCommonAncestor(root.left, p, q);
    } else if (Math.min(p.val, q.val) > root.val)  {
      return lowestCommonAncestor(root.right, p, q);
    }else{
      return root;
    }
  }
}
