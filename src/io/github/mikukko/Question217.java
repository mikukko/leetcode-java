package io.github.mikukko;

import java.util.HashSet;

/**
 * @author Mikukko
 * @date 2021/3/16
 */
public class Question217 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 2, 3};
        System.out.println(new Question217().containsDuplicate(nums));
    }


    /**
     * 217. 存在重复元素
     * <p>
     * 哈希表
     * <p>
     * <p>
     * 给定一个整数数组，判断是否存在重复元素。
     * <p>
     * 如果存在一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
     * <p>
     * 输入: [1,2,3,1]
     * 输出: true
     * <p>
     * 输入: [1,2,3,4]
     * 输出: false
     */
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }
}
