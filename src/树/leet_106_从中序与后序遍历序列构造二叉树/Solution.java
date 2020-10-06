package 树.leet_106_从中序与后序遍历序列构造二叉树;

import commons.ListNode;
import commons.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: theTian
 * @date: 2020/10/6 18:06
 */
public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int inLen = inorder.length;
        int postLen = inorder.length;
        if (inLen != postLen) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>(inLen);
        for (int i = 0; i < inLen; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(postorder, 0, postLen - 1, map, 0, inLen - 1);
    }

    private TreeNode buildTree(int[] postorder, int postLeft, int postRight,
                               Map<Integer, Integer> map, int inLeft, int inRight) {
        if (postLeft > postRight || inLeft > inRight) return null;
        int rootVal = postorder[postRight];
        TreeNode root = new TreeNode(rootVal);
        Integer pIndex = map.get(rootVal);
        root.left = buildTree(postorder, postLeft, postLeft + pIndex - inLeft - 1,
                map, inLeft, pIndex - 1);
        root.right = buildTree(postorder, postLeft + pIndex - inLeft, postRight - 1,
                map, pIndex + 1, inRight);
        return root;
    }
}