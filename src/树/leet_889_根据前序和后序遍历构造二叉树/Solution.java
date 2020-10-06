package 树.leet_889_根据前序和后序遍历构造二叉树;

import commons.TreeNode;

import java.util.HashMap;

/**
 * @author: theTian
 * @date: 2020/10/6 18:24
 */
public class Solution {
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        int preLen = pre.length;
        int postLen = post.length;
        if (preLen != postLen) return null;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < post.length; i++) {
            map.put(post[i], i);
        }
        return buildTree(pre, 0, preLen - 1, map, 0, postLen - 1);
    }

    private TreeNode buildTree(int[] pre, int preLeft, int preRight,
                               HashMap<Integer, Integer> map, int postLeft, int postRight) {
        if (preLeft > preRight || postLeft > postRight) return null;
        int rootVal = pre[preLeft];
        TreeNode root = new TreeNode(rootVal);
        if (preLeft + 1 <= preRight) {
            Integer leftIndex = map.get(pre[preLeft + 1]);
            root.left = buildTree(pre, preLeft + 1, preLeft + 1 + leftIndex - postLeft,
                    map, postLeft, leftIndex);
            root.right = buildTree(pre, preLeft + 2 + leftIndex - postLeft, preRight,
                    map, leftIndex + 1, postRight - 1);
        }
        return root;
    }
}
