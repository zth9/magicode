package 树.leet_105_从前序与中序遍历序列构造二叉树;

import commons.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: theTian
 * @date: 2020/10/6 17:17
 */
public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int preLen = preorder.length;
        int inLen = inorder.length;
        if (preLen != inLen) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>(inLen);
        for (int i = 0; i < inLen; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(preorder, 0, preLen - 1, map, 0, inLen - 1);
    }

    /**
     * 先序遍历数组的第一个元素为根节点 其余元素根据中序遍历数组中根节点对应索引pIndex分为左右子树节点
     *
     * @param preorder 先序遍历数组
     * @param preLeft  先序遍历数组的根节点索引
     * @param preRight 先序遍历数组最后一个子树节点索引
     * @param map      key：节点元素值 value：中序遍历数组对应下标
     * @param inLeft   中序遍历数组左子树节点第一个索引
     * @param inRight  中序遍历数组右子树节点第一个索引
     * @return
     */
    private TreeNode buildTree(int[] preorder, int preLeft, int preRight,
                               Map<Integer, Integer> map, int inLeft, int inRight) {
        if (preLeft > preRight || inLeft > inRight) return null;
        int rootVal = preorder[preLeft];
        TreeNode root = new TreeNode(rootVal); // 构造根节点
        Integer pIndex = map.get(rootVal); // 得出分区索引
        // [preLeft + 1, pIndex + preLeft - inLeft] 表示左子树所有节点
        root.left = buildTree(preorder, preLeft + 1, pIndex + preLeft - inLeft,
                map, inLeft, pIndex - 1);
        // [pIndex + preLeft - inLeft + 1, preRight] 表示右子树所有节点
        root.right = buildTree(preorder, pIndex + preLeft - inLeft + 1, preRight,
                map, pIndex + 1, inRight);
        return root;
    }
}
