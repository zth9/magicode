package 树.leet_110_平衡二叉树.自下向顶;

import commons.TreeNode;

/**
 * @author: theTian
 * @date: 2020/10/7 15:23
 */
public class Solution {
    public boolean isBalanced(TreeNode root) {
        return check(root) != -1;
    }

    private int check(TreeNode root) {
        if (root == null) return 0;
        int checkLeft = check(root.left);
        if (checkLeft == -1) return -1;
        int checkRight = check(root.right);
        if (checkRight == -1) return -1;
        // root的左右子树满足高度平衡二叉树 返回root的检查结果 如果左右高度差不满足<=1就返回-1 表示root不满足
        return Math.abs(checkLeft - checkRight) <= 1 ? Math.max(checkLeft, checkRight) + 1 : -1;
    }
}
