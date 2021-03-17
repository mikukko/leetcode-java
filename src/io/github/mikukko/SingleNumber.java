package io.github.mikukko;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chens
 * @date 2021/3/17
 */
public class SingleNumber {
    public static void main(String[] args) {
        int[] nums = {4, 1, 2, 1, 2};
        System.out.println(new SingleNumber().singleNumber(nums));
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
}
