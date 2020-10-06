package 树.leet_94_二叉树的中序遍历;

import commons.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: theTian
 * @date: 2020/10/6 16:54
 */
public class Solution {
    LinkedList<Integer> res = new LinkedList();

    public List<Integer> inorderTraversal(TreeNode root) {
        inorderRecursion(root);
        return res;
    }

    private void inorderRecursion(TreeNode root) {
        if (root == null) return;
        inorderRecursion(root.left);
        res.add(root.val);
        inorderRecursion(root.right);
    }
}
