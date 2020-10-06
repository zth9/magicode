package 树.leet_144_二叉树的前序遍历;

import commons.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: theTian
 * @date: 2020/10/6 16:29
 */
public class Solution {
    LinkedList<Integer> res = new LinkedList();

    public List<Integer> preorderTraversal(TreeNode root) {
        preorderRecursion(root);
        return res;
    }

    private void preorderRecursion(TreeNode root) {
        if (root == null) return;
        res.add(root.val);
        preorderRecursion(root.left);
        preorderRecursion(root.right);
    }
}
