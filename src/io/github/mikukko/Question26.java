package io.github.mikukko;

/**
 * @author chens
 * @date 2021/3/11
 */
public class Question26 {
    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(new Question26().removeDuplicates(nums));
        System.out.println("-----------------");
        for (int num : nums) {
            System.out.println(num);
        }
    }

    /**
     * 26. 删除排序数组中的重复项
     * <p>
     * <p>
     * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
     * <p>
     * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
     * <p>
     * 双指针法：快指针和慢指针
     */
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        //慢指针指向重复的要被替换掉的元素
        int index = 1;
        //第一个元素始终保留
        int count = 1;
        //第一个元素保留，循环从第二个元素开始
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[index - 1]) {
                continue;
            }
            nums[index] = nums[i];
            index++;
            count++;
        }

        return count;

    }

    /**
     * 数组完成排序后，我们可以放置两个指针 i 和 j ，其中 i 是慢指针，而 j 是快指针。
     * 只要 nums[i] = nums[j]，我们就增加 j 以跳过重复项。
     * 当我们遇到 nums[j] != nums[i]时，跳过重复项的运行已经结束，
     * 因此我们必须把它（nums[j]）的值复制到 nums[i + 1]。
     * 然后递增 i，接着我们将再次重复相同的过程，直到 j 到达数组的末尾为止。
     */
    public int removeDuplicates2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        //慢指针
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}
