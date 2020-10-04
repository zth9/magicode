package 数组.leet_7_整数反转;

import java.util.ArrayList;

/**
 * @author: theTian
 * @date: 2020/10/4 20:55
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().reverse(-123));
    }
    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10
                    || (rev == Integer.MAX_VALUE / 10 && pop > 7))
                return 0;
            if (rev < Integer.MIN_VALUE/10
                    || (rev == Integer.MIN_VALUE / 10 && pop < -8))
                return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }
}
