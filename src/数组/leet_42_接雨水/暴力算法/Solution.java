package 数组.leet_42_接雨水.暴力算法;

/**
 * @author zhangtianhao
 * @date 2024-02-05 16:29
 */
public class Solution {

    /**
     * 像俄罗斯方块一样 层层进行消除
     */
    public int trap(int[] height) {
        if (height.length == 0) {
            return 0;
        }
        boolean findLeftWall = false;
        int finalTotal = 0;
        int wallTotal = 0;
        int leftWallIdx = 0;
        int rightWallIdx = 0;
        for (int i = 0; i < height.length; i++) {
            int wallHeight = height[i];
            if (wallHeight > 0) {
                if (!findLeftWall) {
                    findLeftWall = true;
                    leftWallIdx = i;
                }
                rightWallIdx = i;
                height[i] = wallHeight - 1;
                wallTotal++;
            }
        }
        int length = rightWallIdx - leftWallIdx + 1;
        if (length == 1) {
            return 0;
        }
        int waterTotal = rightWallIdx - leftWallIdx - wallTotal + 1;
        int[] newArr = new int[length];
        System.arraycopy(height, leftWallIdx, newArr, 0, length);
        waterTotal = leftWallIdx == rightWallIdx ? 0 : waterTotal;
        finalTotal += waterTotal;
        return finalTotal + trap(newArr);
    }

    public static void main(String[] args) {
        // expect 9
        System.out.println(new Solution().trap(new int[]{4,2,0,3,2,5}));
    }
}
