package io.github.mikukko;

public class Question704 {

    public static void main(String[] args) {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        int target = 2;
        System.out.println(new Question704().search(nums, target));
    }

    /**
     * 给定一个n个元素有序的（升序）整型数组nums 和一个目标值target，
     * 写一个函数搜索nums中的 target，如果目标值存在返回下标，否则返回 -1。
     */
    public int search(int[] nums, int target) {
        int size = nums.length;

        int start = 0;
        int end = size - 1;

        while (start <= end) {
            int index = (start + end) / 2;
            if (nums[index] == target) {
                return index;
            } else if (nums[index] > target) {
                end = index - 1; // target 在左区间，所以[start, end - 1]
            } else if (nums[index] < target) {
                start = index + 1; // target 在右区间，所以[start + 1, end]
            }
        }
        return -1;

    }


}
