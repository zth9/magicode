package 树.leet_700_二叉搜索树中的搜索;

import commons.TreeNode;

/**
 * @author: theTian
 * @date: 2020/10/7 12:44
 */
public class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        return root == null ? null :
                root.val == val ? root :
                        searchBST(root.val > val ? root.left : root.right, val);
    }
}
