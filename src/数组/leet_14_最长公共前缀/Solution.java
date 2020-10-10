package 数组.leet_14_最长公共前缀;

/**
 * @author: theTian
 * @date: 2020/10/10 22:10
 */
public class Solution {
    public static void main(String[] args) {
        String[] arrs = {"aaa", "aa", "aaa", "aa"};
        System.out.println(new Solution().longestCommonPrefix(arrs));
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length <= 1) return strs.length == 0 ? "" : strs[0];
        String common = strs[0];
        int comLength = common.length();
        for (int i = 1; i < strs.length; i++) {
            comLength = Math.min(comLength, strs[i].length());
            if (comLength == 0) return "";
            for (int j = 0; j < comLength; j++) {
                if (common.charAt(j) != strs[i].charAt(j)){
                    comLength = j;
                    break;
                }
            }
        }
        return common.substring(0, comLength);
    }
}
