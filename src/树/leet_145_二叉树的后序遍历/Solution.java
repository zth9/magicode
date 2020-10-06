package 树.leet_145_二叉树的后序遍历;

import commons.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: theTian
 * @date: 2020/10/6 16:58
 */
public class Solution {
    LinkedList<Integer> res = new LinkedList();

    public List<Integer> postorderTraversal(TreeNode root) {
        postorderRecursion(root);
        return res;
    }

    private void postorderRecursion(TreeNode root) {
        if (root == null) return;
        postorderRecursion(root.left);
        postorderRecursion(root.right);
        res.add(root.val);
    }
}
