package 树.leet_110_平衡二叉树.自顶向下;

import commons.TreeNode;

/**
 * @author: theTian
 * @date: 2020/10/7 14:47
 */
public class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return Math.abs(height(root.left) - height(root.right)) <= 1
                && isBalanced(root.left)
                && isBalanced(root.right);
    }

    private int height(TreeNode root) {
        if (root == null) return 0;
        return Math.max(height(root.left), height(root.right)) + 1;
    }
}
