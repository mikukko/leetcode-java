package io.github.mikukko;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author chens
 * @date 2021/3/17
 */
public class Question136 {
    public static void main(String[] args) {
        int[] nums = {4, 1, 2, 1, 2};
        System.out.println(new Question136().singleNumber3(nums));
    }

    /**
     * 136. 只出现一次的数字
     * <p>
     * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
     * <p>
     * 输入: [4,1,2,1,2]
     * 输出: 4
     */
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>(16);
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        int r = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                r = entry.getKey();
            }
        }
        return r;
    }


    /**
     * 先对数组进行排序，判定第奇数位数字，与偶数位字符是否相等，如不相等则该数字为单个字符
     */
    public int singleNumber2(int[] nums) {
        Arrays.sort(nums);
        int r = -1;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                if (i == nums.length - 1 || nums[i] != nums[i + 1]) {
                    return nums[i];
                }
            }
        }
        return r;
    }

    /**
     * 异或运算
     * <p>
     * 性质：
     * 任何数和 0 做异或运算，结果仍然是原来的数；
     * 任何数和其自身做异或运算，结果是 0；
     * 异或运算满足交换律和结合律；
     * 如果a、b两个值不相同，则异或结果为1。如果a、b两个值相同，异或结果为0。
     * <p>
     * 相同为0 不同为1
     */
    public int singleNumber3(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }

}
