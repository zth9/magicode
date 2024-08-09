package 数组.leet_39_组合总数;

import java.util.*;

/**
 * 回溯 剪枝
 * @author zhangtianhao
 * @date 2024-07-26 16:27
 */
public class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int len = candidates.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) return res;
        int beginIdx = 0;
        Deque<Integer> path = new ArrayDeque<>();
        Arrays.sort(candidates);
        dfs(candidates, target, len, beginIdx, path, res);
        return res;
    }

    private void dfs(int[] candidates, int target, int len, int beginIdx, Deque<Integer> path, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = beginIdx; i < candidates.length; i++) {
            if (candidates[i] > target) {
                break;
            }
            path.add(candidates[i]);
            dfs(candidates, target - candidates[i], len, i, path, res);
            path.removeLast();
        }
    }


    public static void main(String[] args) {
        System.out.println(new Solution().combinationSum(new int[]{2, 1, 3}, 5));
    }
}
