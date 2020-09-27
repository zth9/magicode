package 字符串.leet_5_最长回文子串.暴力;

/**
 * @author: theTian
 * @date: 2020/9/27 20:21
 */
class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;
        char[] charArray = s.toCharArray();
        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len; j++) {
                if (j - i + 1 > maxLen && isPalindrome(charArray, i, j)) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin+maxLen);
    }

    public boolean isPalindrome(char[] chars, int start, int end) {
        while (start < end) {
            if (chars[start++] != chars[end--]) {
                return false;
            }
        }
        return true;
    }
}
