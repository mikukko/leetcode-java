package io.github.mikukko;

import java.util.Arrays;

public class Question283 {

    public static void main(String[] args) {

        int[] nums = {0,1,0,3,12};
        new Question283().moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }


    /**
     * 283. 移动零
     * <p>
     * 双指针
     * <p>
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     * <p>
     * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
     * <p>
     * 示例 1:
     * 输入: nums = [0,1,0,3,12]
     * 输出: [1,3,12,0,0]
     * <p>
     * 示例 2:
     * 输入: nums = [0]
     * 输出: [0]
     */
    public void moveZeroes(int[] nums) {
        int length = nums.length;

        if (nums.length == 0) {
            return;
        }
        //a指向之后全是零的坐标
        int a = 0;
        //把非零的数字向前移动, 覆盖为零的数
        //左指针左边均为非零数；
        //右指针左边直到左指针处均为零
        for (int i = 0; i < length; i++) {
            if (nums[i] != 0) {
                nums[a] = nums[i];
                a++;
            }
        }

        //该坐标及其之后皆为零
        while (a < length) {
            nums[a] = 0;
            a++;
        }

    }
}
