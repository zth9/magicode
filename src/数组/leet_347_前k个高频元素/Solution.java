package 数组.leet_347_前k个高频元素;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author: theTian
 * @date: 2020/10/8 23:10
 */
public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int length = nums.length;
        if (length < 2) return new int[]{nums[0]};
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            int v = 1;
            if (map.containsKey(nums[i])) v = map.get(nums[i]) + 1;
            map.put(nums[i], v);
        }
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        int size = entries.size();
        Map.Entry<Integer, Integer>[] arr = new Map.Entry[size];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : entries) {
            arr[i++] = entry;
        }
        // 初始化堆
        int h = size / 2;
        while (h >= 0) heapfy(arr, h--, size - 1);
        // 排序
        int[] res = new int[k];
        int last = size - 1;
        for (int j = 0; j < k; j++) {
            swap(arr, 0, last);
            res[j] = (Integer) arr[last--].getKey();
            heapfy(arr, 0, last);
        }
        return res;
    }

    private void heapfy(Map.Entry[] arr, int root, int last) {
        while (true) {
            int left = root * 2 + 1;
            int right = root * 2 + 2;
            int maxPos = root;
            if (left <= last && (Integer) arr[maxPos].getValue() < (Integer) arr[left].getValue()) maxPos = left;
            if (right <= last && (Integer) arr[maxPos].getValue() < (Integer) arr[right].getValue()) maxPos = right;
            if (maxPos == root) break;
            swap(arr, root, maxPos);
            root = maxPos;
        }
    }

    private void swap(Map.Entry[] arr, int root, int maxPos) {
        Map.Entry tmp = arr[maxPos];
        arr[maxPos] = arr[root];
        arr[root] = tmp;
    }
}
