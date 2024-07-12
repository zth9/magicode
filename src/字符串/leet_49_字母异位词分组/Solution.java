package 字符串.leet_49_字母异位词分组;

import java.util.*;

/**
 * @author zhangtianhao
 * @date 2024-02-05 16:08
 */
public class Solution {

    public List<List<String>> groupAnagrams(String[] strArr) {
        Map<String, List<String>> map = new HashMap<>();
        Arrays.stream(strArr).forEach(s -> map.computeIfAbsent(format(s), k -> new ArrayList<>()).add(s));
        return new ArrayList<>(map.values());
    }

    private String format(String origin) {
        if (origin.isEmpty()) return "";
        char[] charArray = origin.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }

}
