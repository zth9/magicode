package 字符串.leet_8_字符串转换整数;

/**
 * @author zhangtianhao
 * @date 2024-08-09 15:00
 */
public class Solution {

    public int myAtoi(String s) {
        String str = s.trim();
        if (str.isEmpty()) return 0;
        char firstChar = str.charAt(0);
        boolean positive = firstChar != '-';
        if (firstChar == '-' || firstChar == '+') str = str.substring(1);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char tmp = str.charAt(i);
            if (tmp >= '0' && tmp <= '9') sb.append(tmp);
            else break;
        }
        if (sb.length() == 0) return 0;
        try {
            int res = Integer.parseInt(sb.toString());
            return positive ? res : -res;
        } catch (NumberFormatException e) {
            return positive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
    }
}
