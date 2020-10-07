package 树.leet_450_删除二叉搜索树中的节点;

import commons.TreeNode;

/**
 * @author: theTian
 * @date: 2020/10/7 13:11
 */
public class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val > key) root.left = deleteNode(root.left, key); // 从左子树中删除
        else if (root.val < key) root.right = deleteNode(root.right, key); // 从右子树中删除
        else {
            // 找到对应节点
            if (root.left == null && root.right == null) root = null; // 找到该节点
            else if (root.right != null) {
                // 有右子节点
                TreeNode tmp = root.right;
                while (tmp.left != null) tmp = tmp.left;
                root.val = tmp.val;
                root.right = deleteNode(root.right, root.val);
            } else {
                // 只有左子节点
                TreeNode tmp = root.left;
                while (tmp.right != null) tmp = tmp.right;
                root.val = tmp.val;
                root.left = deleteNode(root.left, root.val);
            }
        }
        return root;
    }
}
