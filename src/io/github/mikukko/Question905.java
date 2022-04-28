package io.github.mikukko;

public class Question905 {


    /*
     * 905. 按奇偶排序数组
     *
     * 双指针 + 一次遍历 + 原地交换
     *
     * 给你一个整数数组 nums，将 nums 中的的所有偶数元素移动到数组的前面，后跟所有奇数元素。
     *
     * 返回满足此条件的 任一数组 作为答案。
     *
     */
    public int[] sortArrayByParity(int[] nums) {
        int length = nums.length;
        int left = 0;
        int right = 0;

        while (right < length) {
            if ((nums[right] & 1) != 1) {
                //不相同时交换
                if (left != right) {
                    int temp = nums[left];
                    nums[left] = nums[right];
                    nums[right] = temp;
                }
                left++;
            }
            right++;
        }

        return nums;
    }

    /**
     * 双指针 + 一次遍历 + 新数组
     */
    public int[] sortArrayByParity2(int[] nums) {
        int length = nums.length;
        int left = 0;
        int right = length - 1;
        int[] res = new int[length];

        for (int num : nums) {
            if ((num & 1) == 1) {
                res[right--] = num;
            } else {
                res[left++] = num;
            }
        }

        return res;
    }
}
