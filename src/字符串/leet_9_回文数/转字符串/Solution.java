package 字符串.leet_9_回文数.转字符串;

/**
 * @author: theTian
 * @date: 2020/10/5 21:06
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().isPalindrome(-121));
    }

    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;
        char[] chars = String.valueOf(x).toCharArray();
        int left = 0;
        int right = chars.length - 1;
        while (left < right) {
            if (chars[left] != chars[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
