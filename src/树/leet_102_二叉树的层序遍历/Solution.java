package 树.leet_102_二叉树的层序遍历;

import commons.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: theTian
 * @date: 2020/10/6 19:34
 */
public class Solution {
    List<List<Integer>> levelList = new LinkedList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return levelList;
        buildList(root, 0);
        return levelList;
    }

    private void buildList(TreeNode root, int level) {
        if (levelList.size() == level) {
            levelList.add(new LinkedList<>());
        }
        levelList.get(level).add(root.val);
        if (root.left != null) {
            buildList(root.left, level + 1);
        }
        if (root.right != null) {
            buildList(root.right, level + 1);
        }
    }
}
