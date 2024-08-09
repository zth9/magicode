package 字符串.leet_6_Z字形变换;

import java.util.*;

/**
 * 回溯 剪枝
 *
 * @author zhangtianhao
 * @date 2024-07-26 16:27
 */
public class Solution {

    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        List<LinkedList<Character>> res = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++) {
            res.add(new LinkedList<>());
        }
        boolean comeback = false;
        int bucketIdx = 0;
        for (Character c : s.toCharArray()) {
            res.get(bucketIdx).add(c);
            if (comeback) {
                if (bucketIdx == 0) {
                    bucketIdx = 1;
                    comeback = false;
                } else {
                    bucketIdx--;
                }
            } else {
                if (bucketIdx == numRows - 1) {
                    bucketIdx--;
                    comeback = true;
                } else {
                    bucketIdx++;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (LinkedList<Character> bucket : res) {
            for (Character c : bucket) {
                sb.append(c);
            }
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        /**
         * P   A   H   N
         * A P L S I I G
         * Y   I   R
         *
         * PAHNAPLSIIGYIR
         */
        System.out.println(new Solution().convert("PAYPALISHIRING", 4));
    }
}
