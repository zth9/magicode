package 字符串.leet_344_反转字符串;

import java.util.Arrays;

/**
 * @author: theTian
 * @date: 2020/10/14 19:40
 */
public class Solution {
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left <= right) {
            char tmp = s[left];
            s[left++] = s[right];
            s[right--] = tmp;
        }
    }
}
