package 树.leet_1457_二叉树中的伪回文路径;

/**
 * dfs + 用数组统计每个数字出现的个数
 * 1.当路径节点数为奇数时，最多只能有一个奇下标
 * 2.当路径节点数为偶数时，不能有任何奇下标
 * 奇下标：数组中某个出现的次数为奇数的数字所对应的下标
 * @author tian
 * @date 2025-03-24
 */
public class Solution {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int pseudoPalindromicPaths(TreeNode root) {
        return dfs(root, new int[10]);
    }

    private int dfs(TreeNode root, int[] arr) {
        if (root == null) {
            return 0;
        }
        int idx = root.val - 1;
        arr[idx] = arr[idx] + 1;
        if (root.left == null && root.right == null) {
            int res = check(arr) ? 1 : 0;
            arr[idx] = arr[idx] - 1;
            return res;
        }
        int res = dfs(root.left, arr) + dfs(root.right, arr);
        arr[idx] = arr[idx] - 1;
        return res;
    }

    private boolean check(int[] arr) {
        int size = 0;
        int res = 0;
        for (int i : arr) {
            size += i;
            if (i % 2 != 0) {
                res++;
            }
            if (res > 1) {
                return false;
            }
        }
        return size % 2 != 0 || res <= 0;
    }
}
