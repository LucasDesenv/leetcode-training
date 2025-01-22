package org.leetcode.dfs;

/**
 * <a href="https://leetcode.com/problems/minimum-depth-of-binary-tree/description/?envType=problem-list-v2">Minimum Depth DFS</a>
 */
public class MinimumDepthBinaryTree {
  public static int minDepth(TreeNode root) { //o(n)
    if (root == null) {
      return 0;
    }

    System.out.println("Current node: " + root.val);

    if (root.left == null && root.right == null){
      System.out.println("Final: " + root.val);
      return 1;
    }

    // If one of the subtrees is null, only consider the other subtree
    if (root.left == null){
      return minDepth(root.right) + 1;
    }else if (root.right == null){
      return minDepth(root.left) + 1;
    }

    // If both subtrees are non-null, take the minimum of the two depths
    return Math.min(minDepth(root.left), minDepth(root.right)) + 1;

  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(9);
    root.right = new TreeNode(20);
    root.right.left = new TreeNode(15);
    root.right.right = new TreeNode(7);
    System.out.println(minDepth(root));


    TreeNode root5 = new TreeNode(2);
    root5.right = new TreeNode(3);
    root5.right.right = new TreeNode(4);
    root5.right.right.right = new TreeNode(5);
    root5.right.right.right.right = new TreeNode(6);

    System.out.println(minDepth(root5));

  }
}
