package 字符串.leet_3_无重复字符的最长子串;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: theTian
 * @date: 2020/9/27 20:17
 */
class Solution {
    /**
     * @param s
     * @return 无重复字符的最长子串的起始索引
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.equals("")) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int n = chars.length;
        Map<Character, Integer> map = new HashMap<>();
        int curLen = 0;
        int max = 0;
        int startIndex = 0;
        for (int i = 0; i < n; i++) {
            char curChar = chars[i];
            if (map.containsKey(curChar)){
                max=Math.max(curLen, max); //如果重复字符不在窗口内 按起使位置最大值
                startIndex = Math.max(map.get(curChar)+1, startIndex);
                curLen = i-startIndex+1;
                map.put(curChar, i);
            }else {
                map.put(curChar, i);
                curLen++;
            }
        }
        max = Math.max(curLen, max);
        return max;
    }
}
