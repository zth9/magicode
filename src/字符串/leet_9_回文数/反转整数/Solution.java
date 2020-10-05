package 字符串.leet_9_回文数.反转整数;

/**
 * @author: theTian
 * @date: 2020/10/5 21:11
 */
public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;
        int rHalf = 0;
        while (x > rHalf) {
            rHalf = rHalf * 10 + x % 10;
            x /= 10;
        }
        return x == rHalf || x == rHalf / 10; // 奇数 中间为0情况也要考虑
    }
}
