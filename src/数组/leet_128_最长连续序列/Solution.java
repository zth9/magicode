package 数组.leet_128_最长连续序列;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * @author zhangtianhao
 * @date 2024-02-05 16:29
 */
public class Solution {

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        int max = 0;
        for (Integer num : set) {
            if (set.contains(num - 1)) continue;
            int steps = 1;
            while (set.contains(++num)) steps++;
            max = Math.max(max, steps);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestConsecutive(new int[]{100, 4, 200, 1, 3, 2, 0, -1}));
    }
}
