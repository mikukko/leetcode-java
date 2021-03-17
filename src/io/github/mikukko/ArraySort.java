package io.github.mikukko;

/**
 * @author chens
 * @date 2021/3/17
 */
public class ArraySort {
    /**
     * 冒泡排序
     * <p>
     * 比较相邻的元素。如果第一个比第二个大，就交换他们两个。
     * <p>
     * 比较n-1轮
     */
    public void sort1(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }

    }

    /**
     * 选择排序
     * <p>
     * 首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置。
     * <p>
     * 再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的后面。
     * <p>
     * 重复第二步，直到所有元素均排序完毕。
     * <p>
     * 比较n-1轮
     */
    public void sort2(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (nums[j] < nums[min]) {
                    min = j;
                }
            }
            int temp = nums[i];
            nums[i] = nums[min];
            nums[min] = temp;
        }

    }


}
