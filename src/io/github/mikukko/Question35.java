package io.github.mikukko;

public class Question35 {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        int target = 21;
        System.out.println(new Question35().searchInsert(nums, target));
    }

    /**
     * 35. 搜索插入位置
     * 二分查找
     * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
     * 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
     *
     * 请必须使用时间复杂度为 O(log n) 的算法。
     */
    public int searchInsert(int[] nums, int target) {
        int size = nums.length;

        int start = 0;
        int end = size - 1;

        while (start <= end) {
            int index = (end - start) / 2 + start; //防止溢出
            if (nums[index] == target) {
                return index;
            } else if (nums[index] > target) {
                end = index - 1; // target 在左区间，所以[start, end - 1]
            } else if (nums[index] < target) {
                start = index + 1; // target 在右区间，所以[start + 1, end]
            }
        }
        return end + 1;

    }
}
