package 字符串.leet_2042_检查句子中的数字是否递增;

/**
 * @author: theTian
 * @date: 2020/10/14 19:40
 */
public class Solution {


    public boolean areNumbersAscending(String s) {
        int len = s.length();
        int max = -1;
        StringBuilder num = new StringBuilder();
        boolean isNum = true;
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                if (isNum) num.append(c);
            } else if (c == ' ') {
                if (!isNum) {
                    isNum = true;
                } else {
                    int tmp = Integer.parseInt(num.toString());
                    if (tmp <= max) {
                        return false;
                    }
                    max = tmp;
                }
                num = new StringBuilder();
            } else {
                isNum = false;
            }

        }
        return !isNum || Integer.parseInt(num.toString()) > max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().areNumbersAscending("2 3 4 6 7 8 10 royal reach 12"));
    }


}
