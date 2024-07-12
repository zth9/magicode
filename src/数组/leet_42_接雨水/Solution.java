package 数组.leet_42_接雨水;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author zhangtianhao
 * @date 2024-02-05 16:29
 */
public class Solution {

    /**
     * 核心是每个墙上最多能承载多少雨水
     * 单调栈
     */
    public int trap(int[] arr) {
        int res = 0;
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < arr.length; ++i) {
            while (!stack.isEmpty() && arr[i] > arr[stack.peek()]) {
                int top = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int left = stack.peek();
                int currWidth = i - left - 1;
                int currHeight = Math.min(arr[left], arr[i]) - arr[top];
                res += currWidth * currHeight;
            }
            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().trap(new int[]{4, 2, 0, 3, 2, 5}));
    }
}
