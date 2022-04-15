package io.github.mikukko;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author chens
 * @date 2021/3/17
 */
public class Question350 {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};

        int[] arr = new Question350().intersect(nums1, nums2);

        for (int i : arr) {
            System.out.println(i);
        }
    }

    /**
     * 350. 两个数组的交集 II
     * <p>
     * 给定两个数组，编写一个函数来计算它们的交集。
     * 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
     * <p>
     * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
     * 输出：[2,2]
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map1 = new HashMap<>(16);
        HashMap<Integer, Integer> map2 = new HashMap<>(16);

        for (int i : nums1) {
            map1.put(i, map1.getOrDefault(i, 0) + 1);
        }
        for (int i : nums2) {
            map2.put(i, map2.getOrDefault(i, 0) + 1);
        }
        ArrayList<Integer> list = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : map1.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            int loop = 0;
            if (map2.containsKey(key)) {
                if (value < map2.get(key)) {
                    loop = value;
                } else {
                    loop = map2.get(key);
                }

                for (int i = 0; i < loop; i++) {
                    list.add(key);
                }
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
