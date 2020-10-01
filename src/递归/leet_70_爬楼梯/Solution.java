package 递归.leet_70_爬楼梯;

import java.util.HashMap;

/**
 * @author: theTian
 * @date: 2020/9/30 14:11
 */
public class Solution {
    /**
     * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
     * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     * @param n
     * @return
     */
    static HashMap<Integer, Integer> map = new HashMap<>();
    public int climbStairs(int n) {
        if (n<=2){
            return n;
        }
        int res;
        if (map.containsKey(n)){
            return map.get(n);
        }else {
            res = climbStairs(n-1) + climbStairs(n-2);
            map.put(n, res);
            return res;
        }
    }
}
