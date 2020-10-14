package 字符串.leet_38_外观数列;

/**
 * @author: theTian
 * @date: 2020/10/14 20:03
 */
public class Solution {
    public String countAndSay(int n) {
        if (n == 1) return "1";
        String s = countAndSay(n - 1);
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        int left = 0;
        for (int i = 1; i < chars.length; i++) {
            if (chars[left] != chars[i]) {
                sb.append(i - left).append(chars[left]);
                left = i;
            }
        }
        sb.append(chars.length - left).append(chars[left]);
        return sb.toString();
    }
}
