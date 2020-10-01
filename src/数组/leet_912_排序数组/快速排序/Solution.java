package 数组.leet_912_排序数组.快速排序;

/**
 * @author: theTian
 * @date: 2020/10/1 20:47
 */
public class Solution {
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    /**
     * 递归分区
     * @param arr
     * @param p
     * @param r
     */
    private static void quickSort(int[] arr, int p, int r) {
        if (p >= r){
            return;
        }
        int q = partition(arr, p , r);
        quickSort(arr, p, q-1);
        quickSort(arr, q+1, r);
    }

    /**
     * 将最后一个元素作为中间值 前后分区
     * @param arr
     * @param p
     * @param r
     * @return
     */
    private static int partition(int[] arr, int p, int r) {
        int cursor = r;
        boolean findBig = false;
        for (int i = 0; i < r; i++) {
            if (arr[i] > arr[r] && !findBig){
                cursor = i;
                findBig = true;
            }
            if (arr[i] < arr[r] && findBig){
                int tmp = arr[i];
                arr[i] = arr[cursor];
                arr[cursor] = tmp;
                cursor++;
            }
        }
        if (cursor != r){
            int tmp = arr[r];
            arr[r] = arr[cursor];
            arr[cursor] = tmp;
        }
        return cursor;
    }
}
