package org.leetcode.dfs;

/**
 * <a href="https://leetcode.com/problems/symmetric-tree/?envType=problem-list-v2&envId=depth-first-search">DFS Symmetric</a>
 * Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
 */
public class SymmetricTree {

  public static void main(String[] args) {
    TreeNode root = new TreeNode(2);
    root.left = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);

    root.right = new TreeNode(3);
    root.right.left = new TreeNode(5);
    root.right.right = null;

    System.out.println("Should be false: " + new SymmetricTree().isSymmetric(root));


    TreeNode root2 = new TreeNode(1);
    root2.left = new TreeNode(2);
    root2.left.left = new TreeNode(3);
    root2.left.right = new TreeNode(4);

    root2.right = new TreeNode(2);
    root2.right.left = new TreeNode(4);
    root2.right.right = new TreeNode(3);

    System.out.println("Should be true: " + new SymmetricTree().isSymmetric(root2));

  }

  public boolean isSymmetric(TreeNode root) { //O(n)
    return areSymmetric(root.left, root.right); //we skip the starting root as it doesn't make sense to check it.
  }

  private static boolean areSymmetric(TreeNode left, TreeNode right) {
    if (left == null && right == null) { //nothing to compare anymore, means false.
      return true;
    }

    if (left == null || right == null) { //one of them is null, means no mirror.
      return false;
    }

    if (left.val == right.val){ //if both values are the same, it means we can keep iterating through the tree.
      return areSymmetric(left.right, right.left) && areSymmetric(left.left, right.right); //both opposite sides must be true (it is a mirror).
    }

    return false; //we haven't found any match.
  }
}
