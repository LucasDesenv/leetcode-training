package org.leetcode.dfs;

/**
 * <a href="https://leetcode.com/problems/maximum-depth-of-binary-tree/?envType=problem-list-v2">DFS</a>
 */
public class MaximumDepthBinaryTree {
  public static void main(String[] args) {

  }
  public int maxDepth(TreeNode root) { //o(n)
    if (root == null) {
      return 0; //it means I reached the end.
    }

    if (root.left == null && root.right == null) { //if I reach this point, it means there is no other path to take, so I end the calculation.
      return 1; //return 1 because the $root itself must be taken into the sum.
    }


    return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1; //keep calculating recursively.
  }


}



