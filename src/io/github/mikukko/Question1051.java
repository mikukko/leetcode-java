package io.github.mikukko;

import java.util.Arrays;

public class Question1051 {


    /**
     * 1051. 高度检查器
     * <p>
     * 学校打算为全体学生拍一张年度纪念照。根据要求，学生需要按照 非递减 的高度顺序排成一行。
     * <p>
     * 排序后的高度情况用整数数组 expected 表示，其中 expected[i] 是预计排在这一行中第 i 位的学生的高度（下标从 0 开始）。
     * <p>
     * 给你一个整数数组 heights ，表示 当前学生站位 的高度情况。heights[i] 是这一行中第 i 位学生的高度（下标从 0 开始）。
     * <p>
     * 返回满足 heights[i] != expected[i] 的 下标数量 。
     * <p>
     * 输入：heights =[1,1,4,2,1,3]
     * 输出：3
     * 解释：
     * 高度：[1,1,4,2,1,3]
     * 预期：[1,1,1,2,3,4]
     * 下标 2 、4 、5 处的学生高度不匹配。
     * <p>
     * 输入：heights = [5,1,2,3,4]
     * 输出：5
     * 解释：
     * 高度：[5,1,2,3,4]
     * 预期：[1,2,3,4,5]
     * 所有下标的对应学生高度都不匹配。
     */
    public int heightChecker(int[] heights) {
        //先排序 再比较
        int ans = 0;
        int[] expected = new int[heights.length];

        System.arraycopy(heights, 0, expected, 0, heights.length);

        Arrays.sort(expected);

        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != expected[i]) {
                ans++;
            }
        }

        return ans;
    }


    /**
     * 桶排序
     */
    public int heightChecker2(int[] heights) {
        // 值的范围是1 <= heights[i] <= 100，因此需要1,2,3,...,99,100，共101个桶
        int[] arr = new int[101];

        // 遍历数组heights，计算每个桶中有多少个元素，也就是数组heights中有多少个1，多少个2 ... 多少个100
        // 将这101个桶中的元素，一个一个桶地取出来，元素就是有序的

        //[0, 0, 0, 0, 0, 0, 0, 0 ...]
        //每个下标表示对应的值, 数组的值代表值出现的次数, 后续按下标从数组桶中取出元素即是有序的
        //height的值作为arr数组的下标
        for (int height : heights) {
            arr[height]++;
        }

        int ans = 0;

        for (int i = 0, j = 0; i < arr.length; i++) {
            // arr[i]，i就是桶中存放的元素的值，arr[i]是元素的个数
            // arr[i]-- 就是每次取出一个，一直取到没有元素，成为空桶
            while (arr[i]-- > 0) {
                //注意这里需要用桶下标值与原数组值比较 不同的话计数器+1
                if (i != heights[j++]) {
                    ans++;
                }
            }
        }

        return ans;
    }
}
