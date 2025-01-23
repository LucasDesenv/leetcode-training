package org.leetcode.dfs;

/**
 * <a href="https://leetcode.com/problems/path-sum/description/?envType=problem-list-v2&envId=depth-first-search">Path Sum DFS</a>
 * Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.
 *
 * A leaf is a node with no children.
 */
public class PathSum {
  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    boolean shouldBeFalse = new PathSum().hasPathSum(root, 5);
    System.out.println(shouldBeFalse);

    TreeNode root2 = new TreeNode(5);
    root2.left = new TreeNode(4);
    root2.left.left = new TreeNode(11);
    root2.left.left.right = new TreeNode(2);
    root2.left.left.left = new TreeNode(7);

    root2.right = new TreeNode(8);
    root2.right.left = new TreeNode(13);
    root2.right.right = new TreeNode(4);
    root2.right.right.right = new TreeNode(1);

    boolean shouldBeTrue = new PathSum().hasPathSum(root2, 22);
    System.out.println(shouldBeTrue);

  }
  public boolean hasPathSum(TreeNode root, int targetSum) {
    return hasPathSum(root, targetSum, 0);

  }

  private static boolean hasPathSum(TreeNode root, int targetSum, int currentSum) { //O(n)
    if (root == null) {
      return false;
    }

    currentSum += root.val;

    boolean isLeaf = root.left == null && root.right == null;

    if (isLeaf){
      return currentSum == targetSum;
    }

    return hasPathSum(root.left, targetSum, currentSum) || hasPathSum(root.right, targetSum, currentSum);
  }
}
