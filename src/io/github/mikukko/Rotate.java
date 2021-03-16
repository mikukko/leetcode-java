package io.github.mikukko;

/**
 * @author Mikukko
 * @date 2021/3/16
 */
public class Rotate {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        new Rotate().rotate(nums, 4);

        for (int num : nums) {
            System.out.println(num);
        }
    }


    /**
     * 189. 旋转数组
     * <p>
     * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
     * <p>
     * 输入: nums = [1,2,3,4,5,6,7], k = 3
     * 输出: [5,6,7,1,2,3,4]
     * 解释:
     * 向右旋转 1 步: [7,1,2,3,4,5,6]
     * 向右旋转 2 步: [6,7,1,2,3,4,5]
     * 向右旋转 3 步: [5,6,7,1,2,3,4]
     */
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int y = k % n;
        int[] rs = new int[n];
        System.arraycopy(nums, 0, rs, 0, nums.length);
        for (int i = 0; i < n; i++) {
            nums[(i + k) % n] = rs[i];
        }

    }
}
