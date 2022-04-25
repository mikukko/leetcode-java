package io.github.mikukko;

import java.util.Arrays;

public class Question977 {

    public static void main(String[] args) {
        int[] nums = {-7, -3, 2, 3, 11};
        System.out.println(Arrays.toString(new Question977().sortedSquares(nums)));
    }

    /*
     * 977. 有序数组的平方
     *
     * 双指针
     *
     * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
     *
     * 设计时间复杂度为 O(n) 的算法解决本问题
     *
     * 输入：nums = [-4,-1,0,3,10]
     * 输出：[0,1,9,16,100]
     * 解释：平方后，数组变为 [16,1,0,9,100]
     * 排序后，数组变为 [0,1,9,16,100]
     */
    public int[] sortedSquares(int[] nums) {
        int length = nums.length;
        int left = 0;
        int right = length - 1;
        //平方结果的最大值的位置 因为数组是按照递增的顺序排列的,因此平方后要么左边最大要么右边最大
        int index = length - 1;
        int[] ans = new int[length];
        //分别指向边界两边 平方后的值取最大逆序放在结果数组中
        while (left <= right) {
            int s1 = nums[left] * nums[left];
            int s2 = nums[right] * nums[right];
            if (s1 > s2) {
                ans[index] = s1;
                left++;
            } else {
                ans[index] = s2;
                right--;
            }
            //当前最大值已确定, index减一
            index--;
        }

        return ans;
    }


}
